package uz.pdp.lionestatebot.bot.models.enums.entity;

public enum ProfileType {
    FAMILY,    // Oila
    STUDENT,   // Talaba
    SINGLE;     // Yolg‘iz (yakka)

    public String getLabel() {
        return switch (this) {
            case FAMILY -> "Oila";
            case STUDENT -> "Talaba";
            case SINGLE -> "Yolg‘iz";
        };
    }
}