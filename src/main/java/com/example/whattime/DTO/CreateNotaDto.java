package com.example.whattime.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateNotaDto
{
    private String name_nota;
    private Integer importancia;
    private String contenido;
    /*private LocalDateTime fecha_creacion;*/
}
