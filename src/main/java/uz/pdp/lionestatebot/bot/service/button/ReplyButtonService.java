package uz.pdp.lionestatebot.bot.service.button;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.service.message.Messages;

@Service
@RequiredArgsConstructor
public class ReplyButtonService {

    public ReplyKeyboardMarkup homeBtns(Language language) {
        return new ReplyKeyboardMarkup(
                new KeyboardButton(Messages.RENT_BTN.get(language)),
                new KeyboardButton(Messages.SALE_BTN.get(language))
        ).addRow(
                new KeyboardButton(Messages.ABOUT_US_MSG.get(language))
        ).addRow(
                new KeyboardButton(Messages.ADD_AD_BTN.get(language)),
                new KeyboardButton(Messages.LANGUAGE_BTN.get(language))
        );
    }

    public ReplyKeyboardMarkup shareContactBtn(Language language) {
        return new ReplyKeyboardMarkup(new KeyboardButton(Messages.SHARE_CONTACT_BTN.get(language)).requestContact(true));
    }

    public ReplyKeyboardMarkup shareLocationBtn(Language language) {
        return new ReplyKeyboardMarkup(new KeyboardButton(Messages.SHARE_LOCATION_BTN.get(language)).requestLocation(true));
    }
}
