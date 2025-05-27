package uz.pdp.lionestatebot.bot.models.entity.ext;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.enums.PropertyCategory;
import uz.pdp.lionestatebot.bot.models.entity.User;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "request_properties")
public class RequestProperty extends BaseEntity {
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /*@ManyToOne
    private Admin createdBy;*/
}
