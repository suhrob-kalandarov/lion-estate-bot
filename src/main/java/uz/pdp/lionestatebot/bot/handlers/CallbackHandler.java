package uz.pdp.lionestatebot.bot.handlers;

import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CallbackHandler implements Consumer<CallbackQuery> {

    @Override
    public void accept(CallbackQuery callbackQuery) {

    }
}
