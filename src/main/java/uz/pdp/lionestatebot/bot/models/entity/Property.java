package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.enums.entity.PropertyCategory;
import uz.pdp.lionestatebot.bot.models.enums.entity.Renovation;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "properties")
public class Property extends BaseEntity {
    private String title;
    private String type;
    private Renovation renovation;
    private String houseType;

    private BigDecimal price;
    private Double area;
    private Boolean depositRequired;
    private Boolean forForeigners;

    @Enumerated(EnumType.STRING)
    private PropertyCategory category;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
}

