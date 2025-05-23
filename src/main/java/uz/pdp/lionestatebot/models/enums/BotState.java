package uz.pdp.lionestatebot.models.enums;

public enum BotState {
    START,
    LANGUAGE_CHOICE,
    MAIN_MENU,

    // Arenda
    ARENDA_TYPE_SELECT,
    ARENDA_WHO_LIVES,
    ARENDA_CITIZENSHIP,
    ARENDA_DISTRICT,
    ARENDA_RENOVATION,
    ARENDA_PRICE_RANGE,
    ARENDA_HOUSE_TYPE,
    ARENDA_RESULTS,

    // Sotuv
    SALE_DISTRICT,
    SALE_HOUSE_TYPE,
    SALE_PRICE,
    SALE_RESULTS,

    // So‘rov
    REQUEST_INPUT,

    // Feedback
    FEEDBACK_WAITING
}
