package com.example.whattime.services;

import com.example.whattime.DTO.CreateUsuarioDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

import java.util.List;

public interface UsuarioService
{
    UsuarioDto getUsuarioById(Long usuarioId) throws WhatTimeExceptions; // SI hay error recurre al whattimeExceptions
    List<UsuarioDto> getUsuarios() throws  WhatTimeExceptions;
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws  WhatTimeExceptions;
    int setupdateUserPassword(String contrasena,Long usuarioId) throws  WhatTimeExceptions;
    int setUpdateUserCorreo(String correo, Long usuarioId) throws WhatTimeExceptions;

    void deleteById(Long id);
    boolean existsById(Long userid)throws  WhatTimeExceptions;
    UsuarioDto findByNombreAndContrasena(String nombre,String pass)throws WhatTimeExceptions;
}