package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.Entity;
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
@Table(name = "sessions")
public class Session extends BaseEntity {


}
