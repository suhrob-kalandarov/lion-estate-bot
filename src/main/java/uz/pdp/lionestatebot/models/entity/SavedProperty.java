package uz.pdp.lionestatebot.models.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "saved_properties")
@Data
public class SavedProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;
}
