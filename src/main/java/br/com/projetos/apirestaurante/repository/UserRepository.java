package br.com.projetos.apirestaurante.repository;

import br.com.projetos.apirestaurante.domain.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String userName);
}
