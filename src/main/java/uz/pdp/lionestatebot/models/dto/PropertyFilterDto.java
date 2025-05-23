package uz.pdp.lionestatebot.models.dto;

import uz.pdp.lionestatebot.models.enums.DealType;
import uz.pdp.lionestatebot.models.enums.PropertyType;
import lombok.Data;

@Data
public class PropertyFilterDto {
    private DealType dealType;
    private PropertyType propertyType;
    private String region;
    private String renovation;
    private boolean deposit;
    private boolean foreignerAllowed;
    private String targetAudience;
    private double minPrice;
    private double maxPrice;
}