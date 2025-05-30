package uz.pdp.lionestatebot.bot.process.callback;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.service.button.InlineButtonService;
import uz.pdp.lionestatebot.bot.service.button.ReplyButtonService;
import uz.pdp.lionestatebot.bot.service.execute.BotEditMessageSender;
import uz.pdp.lionestatebot.bot.service.execute.BotMessageSender;
import uz.pdp.lionestatebot.bot.service.message.Messages;
import uz.pdp.lionestatebot.bot.service.model.faces.SessionService;

import java.util.function.BiConsumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class LanguageHomeService implements BiConsumer<CallbackQuery, Session> {

    private final BotMessageSender messageSender;
    private final ReplyButtonService replyButtonService;
    private final InlineButtonService inlineButtonService;
    private final SessionService sessionService;
    private final BotEditMessageSender botEditMessageSender;

    @Override
    public void accept(CallbackQuery callbackQuery, Session session) {
        String data = callbackQuery.data();

        if (data.startsWith("lang_")) {
            String langCode = data.split("_")[1]; // "uz", "ru", "cn", "en"
            try {
                Language language = Language.valueOf(langCode);
                session.setLanguage(language);
                session.setState(SessionState.HOME_MENU);

                botEditMessageSender.editMessage(
                        session.getUserId(), session.getMessageId(),
                        Messages.LANG_SET_SUCCESS_MSG.get(language)
                );

                SendResponse response = messageSender.sendMarkupMessage(
                        session.getUserId(),
                        Messages.CHOOSE_MENU_MSG.get(language),
                        replyButtonService.homeBtns(language)
                );

                session.setMessageId(response.message().messageId());
                sessionService.save(session);
            } catch (IllegalArgumentException e) {
                log.error("UNK {}", e.getMessage());
                messageSender.sendMessage(session.getUserId(), "❌ Noto‘g‘ri til kodi tanlandi.");
            }
        } else {
            messageSender.sendMessage(session.getUserId(), "❌ Illegal btn.");
            log.error("UNK: {}", data);
        }
    }

    public void sendMenu(Session session) {
        Long userId = session.getUserId();
        SessionState state = session.getState();
        Language language = session.getLanguage();

        if (state.equals(SessionState.START) || state.equals(SessionState.LANG_MENU)) {
            SendResponse response = messageSender.sendInlineMarkupMessage(
                    userId,
                    "Choose language:",
                    inlineButtonService.languageBtns()
            );
            session.setState(SessionState.LANG_MENU);
            session.setMessageId(response.message().messageId());
            sessionService.save(session);
            return;
        }

        messageSender.sendCompanyPhotoMessage(userId,
                Messages.WELCOME_BACK_MSG.get(language)
                        + "\n\n" + Messages.ABOUT_COMPANY_MSG.get(language),
                new ReplyKeyboardRemove()
        );

        messageSender.sendMarkupMessage(userId, Messages.CHOOSE_MENU_MSG.get(language), replyButtonService.homeBtns(language));
        session.setState(SessionState.HOME_MENU);
        sessionService.save(session);
    }
}