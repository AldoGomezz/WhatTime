package com.example.whattime.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

//Dirección para ver swagger
//http://localhost:8081/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.whattime.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Time and Task Managment API",
                "Aplicacion para manejar los tiempos y tareas de los estudiantes para mejorar su orden",
                "1.0",
                "https://www.google.com",
                new Contact("HandyWeb", "https://github.com/AldoGomezz/WhatTime", "u201820751@upc.edu.pe"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
//A