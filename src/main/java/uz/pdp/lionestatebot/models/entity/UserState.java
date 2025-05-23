package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import uz.pdp.lionestatebot.models.enums.BotState;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_states")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserState {

    @Id
    private Long chatId;

    @Enumerated(EnumType.STRING)
    private BotState currentState;

    private LocalDateTime updatedAt;
}
