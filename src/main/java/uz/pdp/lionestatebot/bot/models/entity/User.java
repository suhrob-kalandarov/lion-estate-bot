package uz.pdp.lionestatebot.bot.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import uz.pdp.lionestatebot.bot.models.base.Auditable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bot_users")
public class User extends Auditable {
    @Id
    protected Long id;
    private Boolean _active;
    private Boolean isAdmin;

    @Column(name = "fullname")
    private String fullName;
    private String username;
    private String phone;

    public boolean isAdmin() {
        return Boolean.TRUE.equals(this.isAdmin);
    }
}


