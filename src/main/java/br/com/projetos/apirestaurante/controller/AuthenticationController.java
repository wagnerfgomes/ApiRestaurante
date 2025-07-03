package br.com.projetos.apirestaurante.controller;

import br.com.projetos.apirestaurante.DTOs.LoginDto;
import br.com.projetos.apirestaurante.DTOs.TokenResponseDto;
import br.com.projetos.apirestaurante.service.ValidateLogin;
import br.com.projetos.apirestaurante.useCases.LoginUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Autowired
    private ValidateLogin validateLogin;

    @Operation(description = "Endpoint for login of users")
    @ApiResponses(
            @ApiResponse(
                    description = "user is logged in and receives a token",
                    responseCode = "200"
            )
    )
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginDto dto){
        var token = loginUser.authenticate(dto);
        return ResponseEntity.ok().body(token);
    }

}
