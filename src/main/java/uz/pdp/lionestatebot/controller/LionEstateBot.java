package uz.pdp.lionestatebot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.lionestatebot.config.TelegramBotProperties;
import uz.pdp.lionestatebot.models.enums.Language;
import uz.pdp.lionestatebot.models.enums.UserState;
import uz.pdp.lionestatebot.service.botService.UserService;

@Component
@RequiredArgsConstructor
public class LionEstateBot extends TelegramLongPollingBot {

    private final UserService userService;
    private final TelegramBotProperties properties;

    @Override
    public String getBotUsername() {
        return properties.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return properties.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) return;

        Message message = update.getMessage();
        Long chatId = message.getChatId();
        String text = message.getText();

        var user = userService.registerOrGetUser(chatId, message.getFrom().getFirstName());
        UserState state = user.getState();

        if ("/start".equals(text)) {
            sendLanguageMenu(chatId);
            userService.updateUserState(chatId, UserState.LANGUAGE_SELECTION);
            return;
        }

        switch (state) {
            case LANGUAGE_SELECTION -> handleLanguageSelection(chatId, text);
            case LANGUAGE_SELECTED -> sendMainMenu(chatId, user.getLanguage());
            default -> sendMessage(chatId, "Iltimos, /start buyrug‘i orqali botni qayta ishga tushiring.");
        }
    }

    private void handleLanguageSelection(Long chatId, String text) {
        switch (text) {
            case "🇺🇿 Uzbek" -> handleLanguage(chatId, Language.UZ);
            case "🇷🇺 Русский" -> handleLanguage(chatId, Language.RU);
            case "🇬🇧 English" -> handleLanguage(chatId, Language.EN);
            case "🇨🇳 中文" -> handleLanguage(chatId, Language.CN);
            default -> sendMessage(chatId, "Iltimos, quyidagi tugmalardan birini tanlang.");
        }
    }

    private void sendLanguageMenu(Long chatId) {
        String msg = "Tilni tanlang / Выберите язык / Choose language / 选择语言\n\n🇺🇿 Uzbek\n🇷🇺 Русский\n🇬🇧 English\n🇨🇳 中文";
        sendMessage(chatId, msg);
    }

    private void handleLanguage(Long chatId, Language lang) {
        userService.updateLanguage(chatId, lang);
        userService.updateUserState(chatId, UserState.LANGUAGE_SELECTED);
        sendMessage(chatId, switch (lang) {
            case UZ -> "Lion Estate – Toshkent shahrida 15 000+ qonuniy uylar bazasiga ega agentlik. Hujjatlashtirishda yuristlarimiz yordam beradi.";
            case RU -> "Lion Estate – агентство с базой из 15 000+ легальных домов в Ташкенте. Помощь юристов при оформлении.";
            case EN -> "Lion Estate – Agency with a database of 15,000+ legal homes in Tashkent. Legal assistance provided.";
            case CN -> "Lion Estate – 拥有塔什干15,000多个合法房源的中介机构。我们提供法律文件协助。";
        });
        sendMainMenu(chatId, lang);
    }

    private void sendMainMenu(Long chatId, Language lang) {
        String menu = switch (lang) {
            case UZ -> "🏡 Arenda\n🏠 Sotuv\n📤 E’lon qo‘shish\n📍 Lokatsiya asosida qidiruv\n🧾 Biz haqimizda (batafsil)";
            case RU -> "🏡 Аренда\n🏠 Продажа\n📤 Добавить объявление\n📍 Поиск по локации\n🧾 О нас";
            case EN -> "🏡 Rent\n🏠 Buy\n📤 Post listing\n📍 Search by location\n🧾 About us";
            case CN -> "🏡 出租\n🏠 出售\n📤 添加房源\n📍 根据位置搜索\n🧾 关于我们";
        };
        sendMessage(chatId, menu);
    }

    private void sendMessage(Long chatId, String text) {
        try {
            execute(SendMessage.builder()
                    .chatId(chatId.toString())
                    .text(text)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}