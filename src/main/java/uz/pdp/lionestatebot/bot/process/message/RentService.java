package uz.pdp.lionestatebot.bot.process.message;

import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.lionestatebot.bot.models.entity.Session;

import java.util.function.BiConsumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentService implements BiConsumer<Message, Session> {

    @Override
    public void accept(Message message, Session session) {

    }
}

/*
public class RentService implements BiConsumer<CallbackQuery, Session> {

    @Override
    public void accept(CallbackQuery callbackQuery, Session session) {

    }
}
 */