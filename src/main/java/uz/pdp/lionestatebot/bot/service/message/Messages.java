package uz.pdp.lionestatebot.bot.service.message;

import uz.pdp.lionestatebot.bot.models.enums.entity.Language;

import java.util.Arrays;
import java.util.Optional;

public enum Messages implements LocalizedMessage {
    /// BASE
    TECHNICAL_WORKS_MSG(
            "\uD83D\uDEE0 Texnik ishlar olib borilmoqda...\nIltimos, birozdan so'ng qayta urinib ko‘ring.",
            "\uD83D\uDEE0 Ведутся технические работы...\nПожалуйста, попробуйте снова через некоторое время.",
            "\uD83D\uDEE0 Technical maintenance in progress...\nPlease try again in a few moments.",
            "\uD83D\uDEE0 正在进行系统维护…\n请稍后再试。"
    ),
    UPDATING_MSG(
            "🔄 Yangilanishlar yuklanmoqda! Iltimos, kuting...",
            "🔄 Загружаются обновления! Пожалуйста, подождите...",
            "🔄 Updates are loading! Please wait...",
            "🔄 更新正在加载中！请稍等..."
    ),
    WELCOME_BACK_MSG(
            "Sizni botimizda yana ko‘rib turganimizdan xursandmiz 😊",
            "Мы рады снова видеть вас в нашем боте 😊",
            "We’re happy to see you back in our bot 😊",
            "很高兴再次在我们的机器人中见到您 😊"
    ),
    BACK_BTN("🔙 Orqaga", "🔙 Назад", "🔙 Back", "🔙 返回"),
    BACK_TO_HOME_BTN("🔙 Bosh menyuga qaytish", "🔙 Вернуться в меню", "🔙 Back to Home", "🔙 返回主页"),
    SHARE_CONTACT_BTN(
            "📱 Kontakt ulashish",
            "📱 Поделиться контактом",
            "📱 Share contact",
            "📱 分享联系方式"
    ),
    SHARE_LOCATION_BTN(
            "📍 Joylashuvni ulashish",
            "📍 Поделиться локацией",
            "📍 Share location",
            "📍 分享位置"
    ),

    LANG_SET_SUCCESS_MSG(
            "✅ Til muvaffaqiyatli tanlandi!",
            "✅ Язык успешно выбран!",
            "✅ Language has been successfully set!",
            "✅ 语言已成功设置！"
    ),

    CHOOSE_MENU_MSG(
            "⏬ Quyidagilardan birini tanlang:",
            "⏬ Выберите один из следующих пунктов:",
            "⏬ Please choose one of the following options:",
            "⏬ 请选择以下选项之一："
    ),

    /// HOME
    RENT_BTN("🏠 Arenda", "🏠 Аренда", "🏠 Rent", "🏠 租房"),
    SALE_BTN("🏠 Sotuv", "🏠 Продажа", "🏠 Sale", "🏠 出售"),
    ABOUT_US_BTN("ℹ️ Biz haqimizda", "ℹ️ О нас", "ℹ️ About us", "ℹ️ 关于我们"),
    ADD_AD_BTN("📢 E'lon qo'shish", "📢 Добавить объявление", "📢 Add ad", "📢 添加广告"),
    LANGUAGE_BTN("🌐 Tilni o'zgartirish", "🌐 Сменить язык", "🌐 Change language", "🌐 更改语言"),
    ADD_AD_MSG(
            "📢 E'lon qo'shish uchun @Lion_estate761 bilan bog'laning",
            "📢 Свяжитесь с @Lion_estate761",
            "📢 Contact @Lion_estate761",
            "📢 联系 @Lion_estate761"
    ),
    ABOUT_US_INFO_MSG(
            """
                    🏡 LION ESTATE – SIZNING ISHONCHLI UY AGENTLIGINGIZ!
                    
                    📍 Toshkent shahri bo‘yicha
                    ✅ 15 000+ qonuniy uylar bazasi!
                    📂 Har bir uy — hujjatlari to‘liq va tayyor!
                    
                    👨‍⚖️ Yuristlarimiz sizga yordam beradi — sotib olish, ijaraga olish yoki hujjatlashtirishda to‘liq yuridik qo‘llab-quvvatlash kafolatlanadi.
                    
                    🔐 Ishonch, sifat va qulaylik — barchasi LION ESTATE bilan!
                    
                    📞 Biz bilan bog‘laning va orzuyingizdagi uyni toping!
                    """,
            """
                    🏡 LION ESTATE – ВАШ НАДЕЖНЫЙ АГЕНТ ПО НЕДВИЖИМОСТИ!
                    
                    📍 По городу Ташкент
                    ✅ База данных из более 15 000 законных домов!
                    📂 Каждый дом — с полными и готовыми документами!
                    
                    👨‍⚖️ Наши юристы помогут вам на всех этапах — от покупки до аренды и оформления документов.
                    
                    🔐 Доверие, качество и удобство — всё с LION ESTATE!
                    
                    📞 Свяжитесь с нами и найдите дом своей мечты!
                    """,
            """
                    🏡 LION ESTATE – YOUR TRUSTED REAL ESTATE AGENCY!
                    
                    📍 Covering the city of Tashkent
                    ✅ Database of 15,000+ legal properties!
                    📂 Each house comes with complete and verified documents!
                    
                    👨‍⚖️ Our lawyers will assist you — from buying and renting to full legal documentation support.
                    
                    🔐 Trust, quality, and convenience — all with LION ESTATE!
                    
                    📞 Contact us and find your dream home!
                    """,
            """
                    🏡 LION ESTATE – 您值得信赖的房地产代理！
                    
                    📍 涵盖塔什干市
                    ✅ 超过 15,000 套合法房源数据库！
                    📂 每套房屋都配有完整的合法文件！
                    
                    👨‍⚖️ 我们的律师将为您提供全程协助——购买、租赁或文件处理。
                    
                    🔐 信任、质量和便利——尽在 LION ESTATE！
                    
                    📞 联系我们，寻找您梦想中的家！
                    """
    ),
    BACK_TO_ABOUT_US_MSG(
            "Sizga ma'lumot berganimizdan xursandmiz 😊",
            "Мы рады, что предоставили вам информацию 😊",
            "We're happy to have informed you 😊",
            "很高兴为您提供了信息 😊"
    ),
    ABOUT_COMPANY_MSG(
            "🛅 \"LION ESTATE\" ko‘chmas mulk agentligi professionallar jamoasi tomonidan tashkil etilgan.\n" +
                    "✅ Bizning xodimlarimiz turar joy, tijorat mulki, yangi binolar va ijaraga oid bozor segmentlarida faoliyat yuritadi.",

            "🛅 Агентство недвижимости “LION ESTATE” основано профессиональной командой риелторов.\n" +
                    "✅ Наши сотрудники работают во всех сегментах рынка с объектами жилой, коммерческой недвижимости, новостроек и аренде.",

            "🛅 “LION ESTATE” real estate agency was founded by a professional team of realtors.\n" +
                    "✅ Our staff operates in all market segments, including residential, commercial, new buildings, and rentals.",

            "🛅 “LION ESTATE”房地产代理公司由专业的房地产经纪人团队创立。\n" +
                    "✅ 我们的员工在住宅、商业、新建项目和租赁等各个市场领域开展业务。"
    ),


    /// RENT
    RENT_MENU_MSG("🏡 Iltimos, arenda turini tanlang:", "🏡 Пожалуйста, выберите тип аренды:", "🏡 Please select the type of rent:", "🏡 请选择租赁类型："),
    APARTMENT_BTN("🏠 Kvartira", "🏠 Квартира", "🏠 Apartment", "🏠 公寓"),
    OFFICE_BTN("🏢 Ofis", "🏢 Офис", "🏢 Office", "🏢 办公室"),
    NON_RES_BTN("🏢 No turar joy", "🏢 Нежилое помещение", "🏢 Non-residential", "🏢 非住宅"),
    APARTMENT_MSG("Kvartira ijarasi bo‘limi", "Раздел аренды квартир", "Apartment rental section", "公寓租赁部分"),
    OFFICE_MSG("Ofis ijarasi bo‘limi", "Раздел аренды офисов", "Office rental section", "办公室租赁部分"),

    /// PROFILE
    PROFILE_MENU_MSG(
            "👨‍👩‍👧‍👦 Kim yashaydi? Iltimos, tanlang:",
            "👨‍👩‍👧‍👦 Кто будет проживать? Пожалуйста, выберите:",
            "👨‍👩‍👧‍👦 Who will live there? Please choose:",
            "👨‍👩‍👧‍👦 谁将居住？请选择："
    ),
    FAMILY_BTN("👨‍👩‍👧 Oilaviy", "👨‍👩‍👧 Семейный", "👨‍👩‍👧 Family", "👨‍👩‍👧 家庭"),
    STUDENT_BTN("🎓 Talaba", "🎓 Студент", "🎓 Student", "🎓 学生"),
    SINGLE_BTN("👤 Yolg‘iz", "👤 Одинокий", "👤 Single", "👤 单身"),

    /// CITIZENSHIP
    CITIZENSHIP_MENU_MSG(
            "👍 Yahshi, endi kimligingizni kiriting:",
            "👍 Хорошо, теперь введите свою гражданство:",
            "👍 Great, now enter your citizenship:",
            "👍 好的，请输入您的国籍："
    ),
    LOCAL_BTN("🇺🇿 O'zbekiston fuqarosi", "🇺🇿 Гражданин Узбекистана", "🇺🇿 Local (Uzbek citizen)", "🇺🇿 乌兹别克斯坦公民"),
    FOREIGNER_BTN("🌍 Chet el fuqarosi", "🌍 Иностранец", "🌍 Foreigner", "🌍 外国人"),

    /// REGION
    REGION_MENU_MSG(
            "📍 Yahshi, endi rayon tanlang:",
            "📍 Хорошо, теперь выберите район:",
            "📍 Great, now select the district:",
            "📍 好的，现在请选择地区："
    ),

    /// RENOVATION
    RENOVATION_MENU_MSG(
            "🛠 Yahshi, endi remont tanlang:",
            "🛠 Хорошо, теперь выберите тип ремонта:",
            "🛠 Great, now select the renovation type:",
            "🛠 好的，现在请选择装修类型："
    ),
    EURO_RE_BTN("🛠 Euro", "🛠 Евро", "🛠 Euro", "🛠 欧式装修"),
    MINIMALISM_RE_BTN("🎨 Minimalizm", "🎨 Минимализм", "🎨 Minimalism", "🎨 极简装修"),
    HIGHTECH_RE_BTN("🔧 Haytek", "🔧 Хайтек", "🔧 High-tech", "🔧 高科技装修"),
    SIMPLE_RE_BTN("🏡 Oddiy uy", "🏡 Простой дом", "🏡 Simple house", "🏡 普通住宅"),

    /// BUDGET
    BUDGET_MENU_MSG(
            "💰 Yahshi, endi narx tanlang:",
            "💰 Хорошо, теперь выберите цену:",
            "💰 Great, now select the price:",
            "💰 好的，现在请选择价格："
    ),

    /// FLOOR
    FLOOR_MENU_MSG(
            "🏢 Nechinchi qavat kerak? (faqat raqam kiriting)",
            "🏢 Какой этаж вам нужен? (введите только цифру)",
            "🏢 Which floor do you need? (enter numbers only)",
            "🏢 您需要几楼？（仅输入数字）"
    ),

    /// ROOM-COUNT
    ROOM_COUNT_MENU_MSG(
            "🚪 Nechta xona kerak? (faqat raqam kiriting)",
            "🚪 Сколько комнат нужно? (введите только цифру)",
            "🚪 How many rooms do you need? (enter numbers only)",
            "🚪 您需要几间房？（仅输入数字）"
    ),

    /// PROPERTY-TYPE
    PROPERTY_TYPE_MENU_MSG(
            "🏠 Yahshi, endi turi tanlang:",
            "🏠 Хорошо, теперь выберите тип жилья:",
            "🏠 Great, now select the property type:",
            "🏠 好的，现在请选择房产类型："
    ),
    NEW_BUILDING_BTN("🏗 New Building", "🏗 Новостройка", "🏗 Yangi bino", "🏗 新楼"),
    SECONDARY_MARKET_BTN("🏚 Resale Property", "🏚 Вторичка", "🏚 Ikkilamchi uy", "🏚 二手房"),


    /// HOME
    HOME_INFO_MSG(
            """
                        🏡 Uy-joy haqida ma'lumotlar:
                        📍 Rayon: %s
                        📐 Maydon: %s
                        💵 Narx: %s USD
                    
                        ✅ Ma'lumotlar qabul qilindi, rahmat! 🥳
                    """,
            """
                        🏡 Информация о недвижимости:
                        📍 Район: %s
                        📐 Площадь: %s
                        💵 Цена: %s USD
                    
                        ✅ Данные приняты, спасибо! 🥳
                    """,
            """
                        🏡 Property information:
                        📍 District: %s
                        📐 Area: %s
                        💵 Price: %s USD
                    
                        ✅ Information received, thank you! 🥳
                    """,
            """
                        🏡 房产信息：
                        📍 地区：%s
                        📐 面积：%s
                        💵 价格：%s 美元
                    
                        ✅ 信息已接收，谢谢！🥳
                    """
    );

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

    public static Optional<Messages> findByText(String text, Language lang) {
        return Arrays.stream(values())
                .filter(e -> e.get(lang).equals(text))
                .findFirst();
    }
}