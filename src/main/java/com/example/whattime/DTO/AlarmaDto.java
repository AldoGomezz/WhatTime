package com.example.whattime.DTO;

import com.example.whattime.util.AlarmaStatus;
import com.example.whattime.util.NotaStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//@Builder
@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos para crear una Alarma")
public class AlarmaDto {
    @ApiModelProperty(notes="Id de la alarma",example ="1",required = true,position = 0)
    private Long id;
    @ApiModelProperty(notes="Nombre de la Alarma",example ="Examen final de Diseño Web",required = true,position = 1)
    private String name_alarma;
    @ApiModelProperty(notes="Contenido de la Alarma",example ="Recordar usar los aprendido",required = true,position = 3)
    private String contenido_alarma;
    @ApiModelProperty(notes="Fecha de Alarma",example ="2021-06-27T21:51:29.682Z",required = true,position = 4)
    private Date fecha_alarma;
    @ApiModelProperty(notes="STATUS",example ="ACTIVE / INACTIVE",required = true,position = 6)
    private AlarmaStatus status;
}
