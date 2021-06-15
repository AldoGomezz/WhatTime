package com.example.whattime.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class CreateNotaDto
{
    private String name_nota;
    private Integer importancia;
    private String contenido;
    private Date fecha_creacion;
    private Date fecha_culminacion;
}