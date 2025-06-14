package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.admin.entity.Admin;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.entity.exm.PropertyMedia;
import uz.pdp.lionestatebot.bot.models.enums.entity.PropertyCategory;
import uz.pdp.lionestatebot.bot.models.enums.entity.Renovation;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "properties")
public class Property extends BaseEntity {
    private String type; // "arenda", "sale", "office", "commercial"
    private Renovation renovation; // "evro", "minimalism", "haytek", "oddiy"
    private String houseType; // "novostroyka", "vtorychka"
    private Boolean forForeigners;

    private String title;
    private String region;
    private String address;
    private String orienter;

    private Integer room;
    private Integer floor;
    private Integer floors;

    private Double area; // m2
    private String prepayment;
    private String deposit;
    private Double price; // USD

    @Enumerated(EnumType.STRING)
    private PropertyCategory category;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyMedia> media;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    private Session session;

    /*@ManyToOne
    private Admin createdBy;*/
}

