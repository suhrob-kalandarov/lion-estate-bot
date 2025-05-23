package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import uz.pdp.lionestatebot.models.enums.DealType;
import uz.pdp.lionestatebot.models.enums.PropertyType;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PropertyType type; // KVARTIRA, OFIS, NOTURAR

    @Enumerated(EnumType.STRING)
    private DealType dealType; // ARENDA, SOTUV

    private String district;

    private Double price;

    private String renovation; // Euro, Minimalizm, Haytek, Oddiy

    private Boolean isDepositRequired;

    private Boolean isForForeigners;

    private String residenceType; // Oila, Student, Yolg‘iz

    private String photoFileId;
}
