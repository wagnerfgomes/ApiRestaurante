package br.com.projetos.apirestaurante.domain.models.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "USER_ROLES")
public class UserRole {

    @Id
    @Column(name = "role_id")
    private int Id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false, unique = true)
    private Roles roleName;

    private boolean IsActive = true;

    public enum Roles {
        COMMON,
        ADMIN,
        MANAGER,
        ATTENDANT,
        CHEF,
        WAITER;

        public String getAuthority() {
            return "ROLE_" + this.name();
        }
    }

}
