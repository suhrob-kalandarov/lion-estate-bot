package uz.pdp.lionestatebot.bot.process;

import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.service.button.InlineButtonService;
import uz.pdp.lionestatebot.bot.service.button.ReplyButtonService;
import uz.pdp.lionestatebot.bot.service.message.Messages;
import uz.pdp.lionestatebot.bot.service.model.user.SessionService;

import java.util.Optional;
import java.util.function.BiConsumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeService implements BiConsumer<Message, Session> {

    private final SessionService sessionService;
    private final ReplyButtonService replyButtonService;
    private final InlineButtonService inlineButtonService;

    @Override
    public void accept(Message message, Session session) {
        String text = message.text();
        Language lang = session.getLanguage();
        Optional<Messages> optionalBtn = Messages.findByText(text, lang);


        if (optionalBtn.isEmpty()) {
            log.error("UNK {}", optionalBtn);
            return;
        }

        Messages pressedBtn = optionalBtn.get();

        switch (pressedBtn) {
            case RENT_BTN -> handleRentBtn(session, lang);
            case SALE_BTN -> handleSaleBtn(session, lang);
            case ABOUT_US_BTN -> handleAboutUsBtn(session, lang);
            case ADD_AD_BTN -> handleAddAdBtn(session, lang);
            //case LANGUAGE_BTN -> languageService.sendLanguageMenu(session);
            default -> {

            }
        }
    }

    private void handleRentBtn(Session session, Language lang) {

        session.setState(SessionState.RENT_MENU);
        sessionService.save(session);
    }

    private void handleSaleBtn(Session session, Language lang) {

        session.setState(SessionState.SALE_MENU);
        sessionService.save(session);
    }

    private void handleAboutUsBtn(Session session, Language lang) {

        session.setState(SessionState.ABOUT_US);
        sessionService.save(session);
    }

    private void handleAddAdBtn(Session session, Language lang) {

        session.setState(SessionState.ADD_AD_MENU);
        sessionService.save(session);
    }
}
