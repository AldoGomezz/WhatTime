package com.example.whattime.controllers;

import com.example.whattime.DTO.CreateUsuarioDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/WhatTimeUsuario")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/{usuarioId}")
    public WhatTimeResponse<UsuarioDto> getUsuarioById(@PathVariable Long usuarioId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarioById(usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/allusuarios")
    public WhatTimeResponse<List<UsuarioDto>> getUsuarios()
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarios());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios")
    public WhatTimeResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/upduser")
    public int updateUsuarioPassword(@RequestBody String contrasena, Long usuarioId){
        try {
            return usuarioService.setupdateUserPassword(contrasena, usuarioId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updusercorreo")
    public int updateUsuarioCorreo(@RequestBody String correo, Long usuarioId){
        try {
            return usuarioService.setUpdateUserCorreo(correo, usuarioId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/LoginUser")
    public WhatTimeResponse<UsuarioDto> LoginAcces(String nombre, String contrasena)
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes Login",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.LoginAcess(nombre,contrasena));
    }

}
