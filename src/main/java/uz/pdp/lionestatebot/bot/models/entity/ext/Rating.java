package uz.pdp.lionestatebot.bot.models.entity.ext;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.entity.User;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating extends BaseEntity {
    private int stars; // 1–5

    @ManyToOne
    private Session session;
}
