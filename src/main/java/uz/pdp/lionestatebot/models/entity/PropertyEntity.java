package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import uz.pdp.lionestatebot.models.enums.DealType;
import uz.pdp.lionestatebot.models.enums.PropertyType;

@Entity
@Table(name = "properties")
@Data
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String region;

    private String renovation;

    private boolean deposit;

    private boolean foreignerAllowed;

    private String targetAudience;

    private double price;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    @Enumerated(EnumType.STRING)
    private DealType dealType;
}