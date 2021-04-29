package com.example.whattime.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//Me guie de la clase pero creo que esto es aparte adicional,se acloparia mejor Nota(Lista)
@Getter
@Setter
public class CreateUsuarioDto
{
    private String name;
    private String correo;
    private String password;
    private LocalDateTime fecha_nacimiento;


}
