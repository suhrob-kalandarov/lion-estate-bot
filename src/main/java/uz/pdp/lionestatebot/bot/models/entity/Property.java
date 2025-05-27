package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.enums.PropertyCategory;

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
    private String type; // "arenda", "sale", "office", "commercial"
    private String location; // rayon nomi
    private String remont; // "evro", "minimalism", "haytek", "oddiy"
    private String houseType; // "novostroyka", "vtorychka"

    private BigDecimal price; // USD
    private Double area; // m2
    private Boolean depositRequired;
    private Boolean forForeigners;

    @Enumerated(EnumType.STRING)
    private PropertyCategory category;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Image> images;

   /* @ManyToOne
    private Admin createdBy;*/
}

