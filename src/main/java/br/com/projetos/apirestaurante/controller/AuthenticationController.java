package br.com.projetos.apirestaurante.controller;

import br.com.projetos.apirestaurante.DTOs.LoginDto;
import br.com.projetos.apirestaurante.DTOs.TokenResponseDto;
import br.com.projetos.apirestaurante.useCases.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private LoginUser loginUser;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginDto dto){
        var token = loginUser.authenticate(dto);
        return ResponseEntity.ok().body(token);
    }

}
