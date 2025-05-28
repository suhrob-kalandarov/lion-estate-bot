package uz.pdp.lionestatebot.bot.handlers;
import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.process.HomeService;
import uz.pdp.lionestatebot.bot.service.message.Messages;
import uz.pdp.lionestatebot.bot.service.model.user.LanguageService;
import uz.pdp.lionestatebot.bot.service.model.user.SessionService;

import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class MessageHandler implements Consumer<Message> {

    private final SessionService sessionService;
    private final LanguageService languageService;

    private final HomeService homeService;

    @Override
    public void accept(Message message) {
        Long userId = message.from().id();
        String text = message.text();

        Session session = sessionService.getOrCreateSession(userId);
        Language language = session.getLanguage();

        if (text.equals("/start") && session.getState().equals(SessionState.START)) {
            languageService.sendLanguageMenu(userId);
            return;

        }

        if (session.getState().equals(SessionState.HOME_MENU)) {
            homeService.accept(message, session);

        } else if (session.getState().equals(SessionState.RENT_MENU)) {

        }
    }
}
