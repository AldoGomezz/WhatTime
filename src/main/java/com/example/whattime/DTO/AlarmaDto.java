package com.example.whattime.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class AlarmaDto {
    private Long id;
    private String name_alarma;
    private String contenido_alarma;

}
