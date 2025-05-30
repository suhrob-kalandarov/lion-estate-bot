package uz.pdp.lionestatebot.bot.handlers;

import com.pengrad.telegrambot.model.CallbackQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.process.callback.LanguageHomeService;
import uz.pdp.lionestatebot.bot.process.callback.RentHomeService;
import uz.pdp.lionestatebot.bot.process.callback.RollbackService;
import uz.pdp.lionestatebot.bot.service.model.faces.SessionService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CallbackHandler implements Consumer<CallbackQuery> {

    private final SessionService sessionService;
    private final LanguageHomeService languageHomeService;
    private final RollbackService rollbackService;
    private final RentHomeService rentHomeService;

    @Override
    public void accept(CallbackQuery callbackQuery) {
        Long userId = callbackQuery.from().id();
        String data = callbackQuery.data();
        Session session = sessionService.getOrCreateSession(userId);
        SessionState state = session.getState();

        if (state.equals(SessionState.LANG_MENU) || state.equals(SessionState.START)) {
            languageHomeService.accept(callbackQuery, session);

        } else if (data.startsWith("back_to")) {
            rollbackService.accept(callbackQuery, session);

        } else if (state.equals(SessionState.RENT_MENU)) {
            rentHomeService.accept(callbackQuery, session);

        } else {

        }
    }
}
