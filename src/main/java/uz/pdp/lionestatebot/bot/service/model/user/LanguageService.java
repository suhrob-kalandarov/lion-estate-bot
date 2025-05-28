package uz.pdp.lionestatebot.bot.service.model.user;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final TelegramBot bot;

    public void sendLanguageMenu(Long chatId) {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup(
                new String[]{"O‘zbek", "Русский"},
                new String[]{"English", "中文"}
        ).resizeKeyboard(true);

        bot.execute(new SendMessage(chatId, "Tilni tanlang:").replyMarkup(keyboard));
    }
}
