package br.com.projetos.apirestaurante.service;

import br.com.projetos.apirestaurante.DTOs.TokenResponseDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@Data
@Slf4j
public class JwtService {

    @Autowired
    private final JwtEncoder jwtEncoder;

    public TokenResponseDto generationToken(Authentication authentication){
        Instant now = Instant.now();
        long expiry = 3600L;

        String scopes =  authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("restaurante-api")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scopes)
                .build();
        var token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        var tokenResponse = new TokenResponseDto(token, "Bearer", now.plusSeconds(expiry));

        return tokenResponse;
    }



}
