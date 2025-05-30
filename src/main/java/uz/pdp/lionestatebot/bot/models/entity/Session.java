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
import uz.pdp.lionestatebot.bot.models.enums.entity.*;

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

    private Integer messageId;

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

    @Enumerated(EnumType.STRING)
    private PropertyCategory propertyCategory;

    @Enumerated(EnumType.STRING)
    private Renovation renovation;

    private String region;

    private Integer floor;

    private Integer room;

    private String cost;

    @OneToMany(mappedBy = "session")
    private List<RequestProperty> requests;

    @OneToMany(mappedBy = "session")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "session")
    private List<Rating> ratings;
}
