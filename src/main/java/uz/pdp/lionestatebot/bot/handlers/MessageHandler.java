package uz.pdp.lionestatebot.bot.handlers;
import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.service.model.user.LanguageService;
import uz.pdp.lionestatebot.bot.service.model.user.SessionService;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class MessageHandler implements Consumer<Message> {

    private final SessionService sessionService;
    private final LanguageService languageService;

    @Override
    public void accept(Message message) {
        Long userId = message.from().id();
        String text = message.text();

        if (text.equals("/start")) {
            /*Session session = sessionService.getOrCreateSession(userId);
            Language language = session.getLanguage();*/
            languageService.sendLanguageMenu(userId);
        }

    }
}
