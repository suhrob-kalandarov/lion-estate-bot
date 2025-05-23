package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bot_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BotUser {

    @Id
    private Long chatId;

    @Column(nullable = false)
    private String language; // "uz", "ru", "en", "zh"

    @Column(nullable = false)
    private String role; // "USER" yoki "ADMIN"

    private LocalDateTime registeredAt;
}

