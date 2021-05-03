package com.example.whattime.services.impl;

import com.example.whattime.DTO.CreateUsuarioDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

import java.util.List;

public interface UsuarioService
{
    UsuarioDto getUsuarioById(Long usuarioId) throws WhatTimeExceptions; // SI hay error recurre al whattimeExceptions
    List<UsuarioDto> getUsuarios() throws  WhatTimeExceptions;
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws  WhatTimeExceptions;
    int setupdateUser(String contrasena,Long usuarioId) throws  WhatTimeExceptions;
    int setUpdateUserCorreo(String correo, Long usuarioId) throws WhatTimeExceptions;
    UsuarioDto LoginAcess(String usuario,String contrasena) throws  WhatTimeExceptions;
    //UsuarioDto returnID(String nombre) throws  WhatTimeExceptions;
}