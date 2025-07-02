package br.com.projetos.apirestaurante.useCases;

import br.com.projetos.apirestaurante.DTOs.LoginDto;
import br.com.projetos.apirestaurante.service.JwtService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Data
@Slf4j
public class LoginUser {

    private final JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String authenticate(LoginDto dto){
        log.warn("1");
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        log.warn("2");
        Authentication authentication = authenticationManager.authenticate(authToken);

        return jwtService.generationToken(authentication);
    }

}
