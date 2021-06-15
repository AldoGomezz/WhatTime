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
    private UsuarioService usuarioService;;
    private Object WhatTimeResponse;

    //1
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/user/create")
    public WhatTimeResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }
    //2
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/LoginUser")
    public WhatTimeResponse<UsuarioDto> LoginAcces(String nombre, String contrasena)
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes Login",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.findByNombreAndContrasena(nombre,contrasena));
    }
//3
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/getusers")
    public WhatTimeResponse<List<UsuarioDto>> getUsuarios()
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarios());
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/updatepassword")
    public int updateUsuarioPassword(String contrasena, Long usuarioId){
        try {
            return usuarioService.setupdateUserPassword(contrasena, usuarioId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/user/updateemail")
    public int updateUsuarioCorreo(String correo, Long usuarioId){
        try {
            return usuarioService.setUpdateUserCorreo(correo, usuarioId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{usuarioId}")
    public WhatTimeResponse<UsuarioDto> getUsuarioById(@PathVariable Long usuarioId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarioById(usuarioId));
    }

   /* @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteuser")
    public void deleteUser(Long userId) throws WhatTimeExceptions {
        try {

            usuarioService.existsById(userId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
    }*/
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/user/deleteuser")
    public void deleteById(Long id)
    {
        usuarioService.deleteById(id);
    }

}
