package uz.pdp.lionestatebot.bot.service.execute;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BotMessageSender {

    private final TelegramBot bot;

    public void sendMessage(Long chatId, String text){
        bot.execute(new SendMessage(chatId, text).parseMode(ParseMode.HTML));
    }

    public SendResponse sendMarkupMessage(Long chatId, String text, ReplyKeyboardMarkup replyMarkup){
        return bot.execute(new SendMessage(chatId, text)
                .replyMarkup(replyMarkup.oneTimeKeyboard(true))
                .parseMode(ParseMode.HTML)
        );
    }

    public SendResponse sendInlineMarkupMessage(Long chatId, String text, InlineKeyboardMarkup inlineKeyboardMarkup){
        return bot.execute(new SendMessage(chatId, text)
                .replyMarkup(inlineKeyboardMarkup)
                .parseMode(ParseMode.HTML)
        );
    }

    public void sendRemoveReplyMarkup(long chatId, String text) {
        bot.execute(new SendMessage(chatId, text)
                .replyMarkup(new ReplyKeyboardRemove())
                .parseMode(ParseMode.HTML)
        );
    }

    public void sendRemoveMarkupMessage(long chatId, String text, InlineKeyboardMarkup inlineMarkup) {
        bot.execute(new SendMessage(chatId, text)
                .replyMarkup(new ReplyKeyboardRemove())
                .replyMarkup(inlineMarkup)
                .parseMode(ParseMode.HTML)
        );
    }
}
