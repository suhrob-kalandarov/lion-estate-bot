package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.entity.ext.Favorite;
import uz.pdp.lionestatebot.bot.models.entity.ext.Rating;
import uz.pdp.lionestatebot.bot.models.entity.ext.RequestProperty;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bot_users")
public class User extends BaseEntity {

    private String language; // "uz", "ru", "en", "cn"
    private String citizenship; // "uzbek", "foreigner"
    private String profileType; // "family", "student", "single"

    @OneToMany(mappedBy = "user")
    private List<RequestProperty> requests;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;
}
