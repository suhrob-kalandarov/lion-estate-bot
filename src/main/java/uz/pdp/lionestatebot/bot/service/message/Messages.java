package uz.pdp.lionestatebot.bot.service.message;

import uz.pdp.lionestatebot.bot.models.enums.entity.Language;

import java.util.Arrays;
import java.util.Optional;

public enum Messages implements LocalizedMessage {
    // HOME
    RENT_BTN("🏠 Arenda", "🏠 Аренда", "🏠 Rent", "🏠 租房"),
    SALE_BTN("🏠 Sotuv", "🏠 Продажа", "🏠 Sale", "🏠 出售"),
    ABOUT_US_BTN("ℹ️ Biz haqimizda", "ℹ️ О нас", "ℹ️ About us", "ℹ️ 关于我们"),
    ADD_AD_BTN("📢 E'lon qo'shish", "📢 Добавить объявление", "📢 Add ad", "📢 添加广告"),
    LANGUAGE_BTN("🌐 Tilni o'zgartirish", "🌐 Сменить язык", "🌐 Change language", "🌐 更改语言"),
    ADD_AD_MSG("📢 E'lon qo'shish uchun @Lion_estate761 bilan bog'laning", "📢 Свяжитесь с @Lion_estate761", "📢 Contact @Lion_estate761", "📢 联系 @Lion_estate761"),
    ABOUT_US_MSG("ℹ️ Biz haqimizda ma'lumot", "ℹ️ Информация о нас", "ℹ️ About us information", "ℹ️ 关于我们的信息"),

    // RENT
    APARTMENT_BTN("🏠 Kvartira", "🏠 Квартира", "🏠 Apartment", "🏠 公寓"),
    OFFICE_BTN("🏢 Ofis", "🏢 Офис", "🏢 Office", "🏢 办公室"),
    APARTMENT_MSG("Kvartira ijarasi bo‘limi", "Раздел аренды квартир", "Apartment rental section", "公寓租赁部分"),
    OFFICE_MSG("Ofis ijarasi bo‘limi", "Раздел аренды офисов", "Office rental section", "办公室租赁部分"),

    // PROFILE
    FAMILY_BTN("👨‍👩‍👧 Oilaviy", "👨‍👩‍👧 Семейный", "👨‍👩‍👧 Family", "👨‍👩‍👧 家庭"),
    STUDENT_BTN("🎓 Talaba", "🎓 Студент", "🎓 Student", "🎓 学生"),
    SINGLE_BTN("👤 Yolg‘iz", "👤 Одинокий", "👤 Single", "👤 单身");

    private final String uz;
    private final String ru;
    private final String en;
    private final String cn;

    Messages(String uz, String ru, String en, String cn) {
        this.uz = uz;
        this.ru = ru;
        this.en = en;
        this.cn = cn;
    }

    @Override
    public String get(Language lang) {
        return switch (lang) {
            case uz -> uz;
            case ru -> ru;
            case en -> en;
            case cn -> cn;
        };
    }

    public Optional<Messages> findByText(String text, Language lang) {
        return Arrays.stream(values())
                .filter(e -> e.get(lang).equals(text))
                .findFirst();
    }
}