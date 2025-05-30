package uz.pdp.lionestatebot.bot.service.execute;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

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

    /// lion-estate-logo.jpeg
    ///
    /// @return
    public SendResponse sendCompanyPhotoMessage(Long chatId, String text, Keyboard keyboard) {
        SendResponse response = null;
        try {
            // Faylning resurslardan to‘liq pathini olish
            URL resource = getClass().getClassLoader().getResource("lion-estate-logo.jpeg");
            if (resource == null) {
                System.err.println("Fayl topilmadi: lion-estate-logo.jpeg");
                return response;
            }

            File photoFile = new File(resource.toURI());

            response = bot.execute(new SendPhoto(chatId, photoFile)
                    .caption("<blockquote>" + text + "</blockquote>")
                    .parseMode(ParseMode.HTML)
                    .replyMarkup(keyboard)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
