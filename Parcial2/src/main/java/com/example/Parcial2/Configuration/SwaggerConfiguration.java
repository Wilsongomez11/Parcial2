package com.example.Parcial2.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API de Parcial")
                        .version("1.0")
                        .description("Documentacion de la API para gestionar estudiantes")
                        .contact(new Contact()
                                .name("Soporte API")
                                .email("wilson.gomez-s@uniminuto.edu.co")));

    }
}
