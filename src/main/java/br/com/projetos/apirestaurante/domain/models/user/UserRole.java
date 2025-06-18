package br.com.projetos.apirestaurante.domain.models.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "USER_ROLES")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "role_id")
    private UUID Id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, unique = true)
    private Roles role;

    private boolean IsActive = true;

    enum Roles {
        Common,
        Admin,
        Manager,
        Attendant,
        Chef,
        Waiter;

        public String getAuthority() {
            return "ROLE_" + this.name();
        }
    }

}
