package uz.pdp.lionestatebot.bot.service.message;

import uz.pdp.lionestatebot.bot.models.enums.entity.Language;

public interface LocalizedMessage {
    String get(Language lang);
}
