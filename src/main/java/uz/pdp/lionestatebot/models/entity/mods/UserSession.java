package uz.pdp.lionestatebot.models.entity.mods;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import uz.pdp.lionestatebot.models.enums.BotState;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
@Data
public class UserSession {
    private BotState state;
    private Map<String, String> data = new HashMap<>();
}