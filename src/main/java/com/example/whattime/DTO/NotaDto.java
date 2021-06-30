package com.example.whattime.DTO;

import com.example.whattime.util.NotaStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

//@Builder
@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos para crear una Nota")
public class NotaDto
{
    @ApiModelProperty(notes="Id de la nota",example ="1",required = true,position = 0)
    private Long id;
    @ApiModelProperty(notes="Nombre de la nota",example ="Cosas para hacer antes del examen final",required = true,position = 1)
    private String name_nota;
    @ApiModelProperty(notes="Importancia de la nota",example ="3",required = true,position = 2)
    private Integer importancia;
    @ApiModelProperty(notes="Contenido de la nota",example ="Estudiar un montón toda la semana",required = true,position = 3)
    private String contenido;
    @ApiModelProperty(notes="Fecha de creación",example ="2021-06-27T21:51:29.682Z",required = true,position = 4)
    private Date fecha_creacion;
    @ApiModelProperty(notes="Fecha de culminación",example ="2021-06-27T21:51:29.682Z",required = true,position = 5)
    private Date fecha_culminacion;
    @ApiModelProperty(notes="STATUS",example ="ACTIVE / INACTIVE",required = true,position = 6)
    private NotaStatus status;
}

