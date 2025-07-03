package br.com.projetos.apirestaurante.service;

import br.com.projetos.apirestaurante.domain.models.user.User;
import br.com.projetos.apirestaurante.exception.ApiExceptions;
import br.com.projetos.apirestaurante.exception.ErrorDetail;
import br.com.projetos.apirestaurante.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ValidateLogin validateLogin;

    @Override
    public UserDetails loadUserByUsername(String login) throws ApiExceptions {
        Optional<User> userOptional = validateLogin.validate(login);

        if (userOptional.isEmpty()){
            throw new ApiExceptions(ErrorDetail.USER_NOT_FOUND);
        }

        return userOptional.get();
    }
}
