package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import uz.pdp.lionestatebot.models.enums.Language;
import uz.pdp.lionestatebot.models.enums.UserRole;
import uz.pdp.lionestatebot.models.enums.UserState;

import java.time.LocalDateTime;

@Entity
@Table(name = "bot_users")
@Data
public class UserEntity {
    @Id
    private Long chatId;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private boolean active;

    @Enumerated(EnumType.STRING)
    private UserState state;

    private LocalDateTime createdAt;
}
