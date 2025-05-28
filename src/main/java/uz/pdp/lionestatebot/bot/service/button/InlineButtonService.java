package uz.pdp.lionestatebot.bot.service.button;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.service.message.Messages;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InlineButtonService {

    public InlineKeyboardMarkup languageBtns(){
        return new InlineKeyboardMarkup(
                new InlineKeyboardButton("\uD83C\uDDFA\uD83C\uDDFFO‘zbek").callbackData("lang_uz"),
                new InlineKeyboardButton("\uD83C\uDDF7\uD83C\uDDFAРусский").callbackData("lang_ru")
        ).addRow(
                new InlineKeyboardButton("\uD83C\uDDEC\uD83C\uDDE7English").callbackData("lang_ru"),
                new InlineKeyboardButton("\uD83C\uDDE8\uD83C\uDDF3中文").callbackData("lang_cn")
        );
    }

    public InlineKeyboardMarkup rentBtns(Language language) {
        return new InlineKeyboardMarkup(
                new InlineKeyboardButton(Messages.APARTMENT_BTN.get(language)).callbackData(Messages.APARTMENT_BTN.name()),
                new InlineKeyboardButton(Messages.OFFICE_BTN.get(language)).callbackData(Messages.OFFICE_BTN.name()),
                new InlineKeyboardButton(Messages.NON_RES_BTN.get(language)).callbackData(Messages.NON_RES_BTN.name())
        ).addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );
    }

    public InlineKeyboardMarkup apartmentBtns(Language language) {
        return new InlineKeyboardMarkup(
                new InlineKeyboardButton(Messages.FAMILY_BTN.get(language)).callbackData(Messages.FAMILY_BTN.name()),
                new InlineKeyboardButton(Messages.STUDENT_BTN.get(language)).callbackData(Messages.STUDENT_BTN.name()),
                new InlineKeyboardButton(Messages.SINGLE_BTN.get(language)).callbackData(Messages.SINGLE_BTN.name())
        ).addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );
    }

    public InlineKeyboardMarkup citizenshipBtns(Language language) {
        return new InlineKeyboardMarkup(
                new InlineKeyboardButton(Messages.LOCAL_BTN.get(language)).callbackData(Messages.LOCAL_BTN.name()),
                new InlineKeyboardButton(Messages.FOREIGNER_BTN.get(language)).callbackData(Messages.FOREIGNER_BTN.name())
        ).addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );
    }

    public InlineKeyboardMarkup regionsBtn(Language language) {
        List<String> regions = List.of(
                "Chilonzor", "Yunusobod", "Shayxontohur", "Mirzo Ulugbek",
                "Yakkasaroy", "Yashnobod", "Sergeli", "Uchtepa",
                "Olmazor", "Bektemir", "Yangihayot", "Mirobod"
        );

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        for (int i = 0; i < regions.size(); i += 2) {
            InlineKeyboardButton btn1 = new InlineKeyboardButton(regions.get(i)).callbackData("region_" + regions.get(i));
            InlineKeyboardButton btn2 = (i + 1 < regions.size())
                    ? new InlineKeyboardButton(regions.get(i + 1)).callbackData("region:" + regions.get(i + 1))
                    : null;

            if (btn2 != null) {
                markup.addRow(btn1, btn2);
            } else {
                markup.addRow(btn1);
            }
        }

        markup.addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );

        return markup;
    }

    public InlineKeyboardMarkup renovationBtns(Language language) {
        return new InlineKeyboardMarkup(
                new InlineKeyboardButton(Messages.EURO_RE_BTN.get(language)).callbackData(Messages.EURO_RE_BTN.name()),
                new InlineKeyboardButton(Messages.MINIMALISM_RE_BTN.get(language)).callbackData(Messages.MINIMALISM_RE_BTN.name()),
                new InlineKeyboardButton(Messages.HIGHTECH_RE_BTN.get(language)).callbackData(Messages.HIGHTECH_RE_BTN.name())
        ).addRow(
                new InlineKeyboardButton(Messages.SIMPLE_RE_BTN.get(language)).callbackData(Messages.SINGLE_BTN.name())
        ).addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );
    }

    public InlineKeyboardMarkup costBtns(Language language) {
        return new InlineKeyboardMarkup(
                new InlineKeyboardButton("100-300").callbackData("cost_100-300"),
                new InlineKeyboardButton("300-600").callbackData("cost_300-600")
        ).addRow(
                new InlineKeyboardButton("600-900").callbackData("cost_600-900"),
                new InlineKeyboardButton("900+").callbackData("cost_900+")
        ).addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );
    }

    public InlineKeyboardMarkup floorBtns(Language language) {
        var markup = new InlineKeyboardMarkup();
        for (int i = 1; i < 10; i++) {
            markup.addRow(new InlineKeyboardButton(i + "").callbackData("floor_" + i));
        }
        return markup.addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );
    }

    public InlineKeyboardMarkup officeCostBtns(Language language) {
        return new InlineKeyboardMarkup(
                new InlineKeyboardButton("50-100 K").callbackData("cost_50-100"),
                new InlineKeyboardButton("100-200 K").callbackData("cost_100-200")
        ).addRow(
                new InlineKeyboardButton("200-500 K").callbackData("cost_200-500"),
                new InlineKeyboardButton("500-900 K").callbackData("cost_500-900")
        ).addRow(
                new InlineKeyboardButton("900+ K").callbackData("cost_900+")
        ).addRow(
                new InlineKeyboardButton(Messages.BACK_BTN.get(language)).callbackData(Messages.BACK_BTN.name())
        );
    }

    public InlineKeyboardMarkup areaBtns(Language language) {
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        // 10dan 100gacha bo'lganlar
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10) {
            String label = switch (language) {
                case uz -> i + " m²";
                case ru -> i + " м²";
                case en -> i + " sqm";
                case cn -> i + " 平方米";
            };
            row1.add(new InlineKeyboardButton(label).callbackData("area_" + i));
            if (row1.size() == 5) {
                rows.add(row1);
                row1 = new ArrayList<>();
            }
        }
        if (!row1.isEmpty()) rows.add(row1);

        // 100–300, 300–500, 500–1000
        List<String> ranges = List.of("100-300", "300-500", "500-1000");
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        for (String range : ranges) {
            String label = switch (language) {
                case uz -> range + " m²";
                case ru -> range + " м²";
                case en -> range + " sqm";
                case cn -> range + " 平方米";
            };
            row2.add(new InlineKeyboardButton(label).callbackData("area_" + range));
        }
        rows.add(row2);

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        for (List<InlineKeyboardButton> row : rows) {
            markup.addRow(row.toArray(new InlineKeyboardButton[0]));
        }

        return markup;
    }

}
