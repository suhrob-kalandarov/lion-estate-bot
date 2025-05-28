package uz.pdp.lionestatebot.bot.process;

import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.service.model.user.SessionService;

import java.util.function.BiConsumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeService implements BiConsumer<Message, Session> {

    private final SessionService sessionService;

    @Override
    public void accept(Message message, Session session) {
        String text = message.text();


    }
}
