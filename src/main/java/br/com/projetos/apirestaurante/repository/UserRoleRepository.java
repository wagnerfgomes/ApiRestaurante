package br.com.projetos.apirestaurante.repository;

import br.com.projetos.apirestaurante.domain.models.user.User;
import br.com.projetos.apirestaurante.domain.models.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {

    UserRole findUserRoleByRoleName(UserRole.Roles role);

}
