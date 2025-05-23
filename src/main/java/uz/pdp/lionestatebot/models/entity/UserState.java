package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
