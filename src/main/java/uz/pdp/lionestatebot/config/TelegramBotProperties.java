package uz.pdp.lionestatebot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "telegram")
@Getter
@Setter
public class TelegramBotProperties {
    private String botUsername = System.getenv("lion_estt_bot");
    private String botToken  = System.getenv("7562524530:AAHro4aXtrJGuegowTYT4Lt16dm0BOPMNWI");
}

