package uz.pdp.lionestatebot.bot.handlers;
import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.process.HomeService;
import uz.pdp.lionestatebot.bot.process.RentService;
import uz.pdp.lionestatebot.bot.service.message.Messages;
import uz.pdp.lionestatebot.bot.service.model.user.LanguageService;
import uz.pdp.lionestatebot.bot.service.model.user.SessionService;

import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageHandler implements Consumer<Message> {

    private final SessionService sessionService;
    private final LanguageService languageService;

    private final HomeService homeService;
    private final RentService rentService;

    @Override
    public void accept(Message message) {
        Long userId = message.from().id();
        String text = message.text();
        Session session = sessionService.getOrCreateSession(userId);

        if (text.equals("/start") && session.getState().equals(SessionState.START)) {
            languageService.sendLanguageMenu(userId);
        }

        else if (session.getState().equals(SessionState.HOME_MENU)) {
            homeService.accept(message, session);

        } else if (session.getState().equals(SessionState.RENT_MENU)) {
            rentService.accept(message, session);

        } else if (session.getState().equals(SessionState.SALE_MENU)) {
            
        } else if (session.getState().equals(SessionState.LANG_MENU)) {
            
        } else if (session.getState().equals(SessionState.ADD_AD_MENU)) {

        } else {
            log.info("UNK {}", message);
        }
    }
}
