package br.com.projetos.apirestaurante.DTOs;

import java.time.Instant;

public record TokenResponseDto(String accessToken, String type, Instant expiryIn) {
}
