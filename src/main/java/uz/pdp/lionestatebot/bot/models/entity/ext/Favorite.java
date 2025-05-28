package uz.pdp.lionestatebot.bot.models.entity.ext;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.entity.Property;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.entity.User;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorite extends BaseEntity {

    @ManyToOne
    private Session session;

    @ManyToOne
    private Property property;
}
