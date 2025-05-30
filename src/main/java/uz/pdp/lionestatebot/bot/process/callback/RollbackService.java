package uz.pdp.lionestatebot.bot.process.callback;

import com.pengrad.telegrambot.model.CallbackQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
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

    @Override
    public void accept(CallbackQuery callbackQuery, Session session) {
        String data = callbackQuery.data();

        if (data.equals("back_to_home_from_about_us")) {

            botEditMessageSender.editMessage(session.getUserId(), session.getMessageId(), Messages.BACK_TO_ABOUT_US_MSG.get(session.getLanguage()));
            botMessageSender.sendMarkupMessage(session.getUserId(), Messages.CHOOSE_MENU_MSG.get(session.getLanguage()), replyButtonService.homeBtns(session.getLanguage()));
            session.setState(SessionState.HOME_MENU);
            sessionService.save(session);

        } else if (data.equals("back_to_home_from_rent")) {
            botMessageSender.sendMarkupMessage(session.getUserId(), Messages.CHOOSE_MENU_MSG.get(session.getLanguage()), replyButtonService.homeBtns(session.getLanguage()));
            session.setState(SessionState.HOME_MENU);
            sessionService.save(session);
        } else {

        }
    }
}
