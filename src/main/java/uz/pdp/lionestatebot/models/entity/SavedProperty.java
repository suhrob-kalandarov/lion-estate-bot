package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "saved_properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavedProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private BotUser user;

    @ManyToOne
    private Property property;

    private LocalDateTime savedAt;
}
