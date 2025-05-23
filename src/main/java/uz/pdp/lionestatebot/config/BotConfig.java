package uz.pdp.lionestatebot.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.lionestatebot.controller.LionEstateBot;

@Configuration
public class BotConfig {

    private final LionEstateBot lionEstateBot;

    public BotConfig(LionEstateBot lionEstateBot) {
        this.lionEstateBot = lionEstateBot;
    }

    @PostConstruct
    public void init() throws Exception {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(lionEstateBot);
    }
}

