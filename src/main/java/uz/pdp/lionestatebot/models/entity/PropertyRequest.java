package uz.pdp.lionestatebot.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
@Data
public class PropertyRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String region;
    private double minPrice;
    private double maxPrice;
    private String renovation;
    private String targetAudience;
    private boolean foreigner;

    private LocalDateTime createdAt;
}
