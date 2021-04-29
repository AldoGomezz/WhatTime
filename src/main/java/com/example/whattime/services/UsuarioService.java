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

}
