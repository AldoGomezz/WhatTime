package com.example.whattime.services;

import com.example.whattime.DTO.CreateUsuarioDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.util.NotaStatus;

import java.util.List;

public interface UsuarioService
{
    UsuarioDto getUsuarioByName(String usuarioName) throws WhatTimeExceptions; // SI hay error recurre al whattimeExceptions
    List<UsuarioDto> getUsuarios();
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws  WhatTimeExceptions;
    int setupdateUserPassword(String contrasena,String username) throws  WhatTimeExceptions;
    int setUpdateUserCorreo(String correo, String username) throws WhatTimeExceptions;
    void deleteById(Long id);

    UsuarioDto findByNombreAndContrasena(String nombre,String pass)throws WhatTimeExceptions;


}