package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.BaseEntity;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "images")
public class Image extends BaseEntity {

    private String url;

    @ManyToOne
    @JoinColumn(name = "property_id") // optional: specify FK column name
    private Property property;
}
