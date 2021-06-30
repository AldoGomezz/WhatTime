package com.example.whattime.DTO;

import com.example.whattime.util.CalendarioStatus;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos solicitados de un Calendario")
public class CalendarioDto //Cosas que quiero obtener cuando pregunto por un calendario
{
    private Long id;
    private String name_calendario;
    private CalendarioStatus status;
}