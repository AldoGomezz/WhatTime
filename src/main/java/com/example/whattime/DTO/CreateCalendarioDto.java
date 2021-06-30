package com.example.whattime.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos para crear un Calendario")
public class CreateCalendarioDto {
    private Long id;
    private String name_calendario;
}
