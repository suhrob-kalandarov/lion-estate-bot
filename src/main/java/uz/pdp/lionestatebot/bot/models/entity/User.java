package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.entity.ext.Favorite;
import uz.pdp.lionestatebot.bot.models.entity.ext.Rating;
import uz.pdp.lionestatebot.bot.models.entity.ext.RequestProperty;
import uz.pdp.lionestatebot.bot.models.enums.Citizenship;
import uz.pdp.lionestatebot.bot.models.enums.Language;
import uz.pdp.lionestatebot.bot.models.enums.ProfileType;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bot_users")
public class User extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Enumerated(EnumType.STRING)
    private Citizenship citizenship; // "uzbek", "foreigner"

    @Enumerated(EnumType.STRING)
    private ProfileType profileType; // "family", "student", "single"

    @OneToMany(mappedBy = "user")
    private List<RequestProperty> requests;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;
}
