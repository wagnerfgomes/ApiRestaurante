package br.com.projetos.apirestaurante.config;

import br.com.projetos.apirestaurante.domain.models.user.User;
import br.com.projetos.apirestaurante.domain.models.user.UserRole;
import br.com.projetos.apirestaurante.repository.UserRepository;
import br.com.projetos.apirestaurante.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Slf4j
public class AdminConfg implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var roleAdmin = userRoleRepository.findUserRoleByRoleName(UserRole.Roles.ADMIN);
        var userAdmin = userRepository.findUserByUsername("admin");

        if (userAdmin.isPresent()) {
            log.warn("User already exist");
        }

        if(userAdmin.isEmpty()){
            var user = new User();
            user.setUsername("admin");
            user.setEmail("admin@local.com");
            user.setRole(roleAdmin);
            user.setPassword(passwordEncoder.encode("admin"));
            user.setActive(true);
            userRepository.save(user);
            log.info("User Admin has been created");
        }
    }
}
