package uz.pdp.lionestatebot.bot.service.execute;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.EditMessageText;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BotEditMessageSender {

    private final TelegramBot bot;

    public void editMessage(Long chatId, Integer messageId, String text) {
        bot.execute(new EditMessageText(chatId, messageId, text));
    }

    public SendResponse editMessage(Long chatId, Integer messageId, String text, InlineKeyboardMarkup inlineMarkup) {
        return (SendResponse)bot.execute(new EditMessageText(chatId, messageId, text).replyMarkup(inlineMarkup));
    }
}
