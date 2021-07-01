package com.example.whattime.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class CreateAlarmaDto
{
    private String name_alarma;
    private String contenido_alarma;
    private Date fecha_alarma;

}
