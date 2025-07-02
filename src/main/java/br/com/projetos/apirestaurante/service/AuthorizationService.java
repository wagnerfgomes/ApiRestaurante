package br.com.projetos.apirestaurante.service;

import br.com.projetos.apirestaurante.domain.models.user.User;
import br.com.projetos.apirestaurante.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return typeLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }

    public Optional<User> typeLogin(String login){
        if (login.contains("@")){
            return userRepository.findUserByEmail(login);
        }

        return userRepository.findUserByUsername(login);
    }
}
