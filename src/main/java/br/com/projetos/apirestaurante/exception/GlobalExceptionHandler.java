package br.com.projetos.apirestaurante.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiExceptions.class)
    public ResponseEntity<?> handlerApiException(ApiExceptions apiExceptions){
        return ResponseEntity.status(HttpStatusCode.valueOf(apiExceptions.getStatusCode())).body(Map.of(
                "error", apiExceptions.getErrorCode(),
                "status", apiExceptions.getStatusCode(),
                "message", apiExceptions.getMessage()
        ));
    }
}
