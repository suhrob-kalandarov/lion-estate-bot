/*
package uz.pdp.lionestatebot.bot.models.entity.exm;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.admin.entity.Admin;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;
import uz.pdp.lionestatebot.bot.models.entity.Location;
import uz.pdp.lionestatebot.bot.models.entity.Session;
import uz.pdp.lionestatebot.bot.models.enums.entity.PropertyCategory;
import uz.pdp.lionestatebot.bot.models.enums.entity.Renovation;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "properties")
public class Property extends BaseEntity {

    // Umumiy ma'lumotlar
    private String type; // masalan: "arenda", "sale", "office", "commercial"
    private Renovation renovation; // masalan: "evro", "minimalism", "oddiy"
    private String houseType; // "novostroyka", "vtorychka"
    private Boolean forForeigners;

    // Manzil va joylashuv
    private String title;     // optional: reklama nomi
    private String region;    // masalan: "Юнусабадский"
    private String address;   // aniq manzil: "Жк нур"
    private String orienter;  // mo‘ljal: "Метро Абдуллы Кадыри"

    // Uy parametrlari
    private Integer room;     // xonalar soni
    private Integer floor;    // qavat
    private Integer floors;   // jami qavatlar
    private Double area;      // maydon (kv.m)

    // To‘lov
    private String prepayment; // masalan: "нет"
    private String deposit;    // masalan: "да", "торг", "нет"
    private Double price;      // y.e.

    @Enumerated(EnumType.STRING)
    private PropertyCategory category; // umumiy toifalash (masalan: RESIDENTIAL, COMMERCIAL)

    // Media: rasm va video
    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PropertyMedia> media;

    // Location (map koordinata)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    // Telegram session
    @ManyToOne
    private Session session;

    // Kim yaratgan (admin)
   */
/* @ManyToOne
    private Admin createdBy;*//*


}
*/
