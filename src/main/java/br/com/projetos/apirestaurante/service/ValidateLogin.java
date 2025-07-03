package br.com.projetos.apirestaurante.service;

import br.com.projetos.apirestaurante.domain.models.user.User;
import br.com.projetos.apirestaurante.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ValidateLogin {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> validate(String login){

        if (login.contains("@")){
            return userRepository.findUserByEmail(login);
        }

        return userRepository.findUserByUsername(login);
    }
}
