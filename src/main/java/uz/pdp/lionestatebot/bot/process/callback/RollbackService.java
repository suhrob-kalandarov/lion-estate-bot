package uz.pdp.lionestatebot.bot.process.callback;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.models.enums.entity.PropertyCategory;
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
public class RollbackService implements BiConsumer<CallbackQuery, Session> {


    private final BotEditMessageSender botEditMessageSender;
    private final BotMessageSender botMessageSender;
    private final ReplyButtonService replyButtonService;
    private final SessionService sessionService;
    private final InlineButtonService inlineButtonService;

    @Override
    public void accept(CallbackQuery callbackQuery, Session session) {
        String data = callbackQuery.data();
        Long userId = session.getUserId();
        Integer messageId = session.getMessageId();
        Language language = session.getLanguage();

        if (data.equals("back_to_home_from_about_us")) {
            botEditMessageSender.editMessage(userId, messageId, Messages.BACK_TO_ABOUT_US_MSG.get(session.getLanguage()));
            botMessageSender.sendMarkupMessage(userId, Messages.CHOOSE_MENU_MSG.get(session.getLanguage()), replyButtonService.homeBtns(session.getLanguage()));
            session.setState(SessionState.HOME_MENU);

        } else if (data.equals("back_to_home_from_rent")) {
            botMessageSender.sendMarkupMessage(
                    userId,
                    Messages.CHOOSE_MENU_MSG.get(session.getLanguage()),
                    replyButtonService.homeBtns(session.getLanguage())
            );
            session.setState(SessionState.HOME_MENU);

        } else if (data.equals("back_to_rent_menu")){
            SendResponse sendResponse = botEditMessageSender.editMessage(
                    userId, messageId,
                    Messages.RENT_MENU_MSG.get(language),
                    inlineButtonService.rentBtns(language)
            );
            session.setMessageId(sendResponse.message().messageId());
            session.setState(SessionState.RENT_MENU);
        }

        sessionService.save(session);
    }
}
