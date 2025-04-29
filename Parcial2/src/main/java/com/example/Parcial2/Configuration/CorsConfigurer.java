package com.example.Parcial2.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfigurer {

    @Bean(name = "customCorsConfigurer")
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/api/**")
                        .allowedOrigins("http://10.0.2.2:8080")
                        .allowedMethods("Get", "Post", "Put", "Delete", "Options")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
