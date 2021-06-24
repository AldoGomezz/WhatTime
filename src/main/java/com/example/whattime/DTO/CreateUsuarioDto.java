package com.example.whattime.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//Me guie de la clase pero creo que esto es aparte adicional,se acloparia mejor Nota(Lista)
@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos para crear un Usuario")
public class CreateUsuarioDto
{
    @ApiModelProperty(notes="Nombre de Usuario",example ="Elvis",required = true,position = 0)
    private String name;
    @ApiModelProperty(notes="Correo",example ="usuario@gmail.com",required = true,position = 1)
    private String correo;
    @ApiModelProperty(notes="Contraseña",example ="contraseña",required = true,position = 2)
    private String password;

}
