package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.Auditable;
import uz.pdp.lionestatebot.bot.models.entity.ext.Favorite;
import uz.pdp.lionestatebot.bot.models.entity.ext.Rating;
import uz.pdp.lionestatebot.bot.models.entity.ext.RequestProperty;
import uz.pdp.lionestatebot.bot.models.enums.SessionState;
import uz.pdp.lionestatebot.bot.models.enums.entity.Citizenship;
import uz.pdp.lionestatebot.bot.models.enums.entity.Language;
import uz.pdp.lionestatebot.bot.models.enums.entity.ProfileType;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class Session extends Auditable {
    @Id
    protected Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SessionState state;

    private Boolean _active;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Language language;

    @Enumerated(EnumType.STRING)
    private Citizenship citizenship;

    @Enumerated(EnumType.STRING)
    private ProfileType profileType;

    @OneToMany(mappedBy = "session")
    private List<RequestProperty> requests;

    @OneToMany(mappedBy = "session")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "session")
    private List<Rating> ratings;
}
