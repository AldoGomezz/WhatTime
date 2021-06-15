package com.example.whattime.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto //Cosas que quiero obtener cuando pregunto por un usuario
{
    private Long id;
    private String nombre;
    private String correo;
//   private String contrasena;
}
