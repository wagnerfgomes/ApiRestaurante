package br.com.projetos.apirestaurante;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Gestão de Restaurante", version="1", description="Api para gerenciamento de restaurante"))
public class ApiRestauranteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestauranteApplication.class, args);
    }
}
