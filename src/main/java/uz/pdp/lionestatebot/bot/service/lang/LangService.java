package uz.pdp.lionestatebot.bot.service.lang;

import java.util.Locale;
import java.util.ResourceBundle;

public class LangService {
    public static String getMessage(String langCode, String key) {
        Locale locale = switch (langCode) {
            case "uz" -> new Locale("uz");
            case "ru" -> new Locale("ru");
            case "en" -> new Locale("en");
            case "cn" -> new Locale("cn");
            default -> Locale.ENGLISH;
        };

        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return bundle.getString(key);
    }
}

