package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    private String address;

    @OneToOne(mappedBy = "location")
    private Property property;
}
