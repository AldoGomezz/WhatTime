package com.example.whattime.controllers;

import com.example.whattime.DTO.CreateUsuarioDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.entities.Usuario;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.repositories.UsuarioRepository;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/WhatTimeUsuario")
public class UsuarioController
{
    @Autowired
    private UsuarioService usuarioService;;
    @Autowired
    private UsuarioRepository usuarioRepository;

    //1
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Recibe un CreateUsuario y retorno un successfull como verificador de que la cuenta fue creado con éxito")
    @PostMapping("/user/create")
    public WhatTimeResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws WhatTimeExceptions{
        if (usuarioRepository.existsUsuarioByCorreo(createUsuarioDto.getCorreo()))
        {
            return new WhatTimeResponse<>("Fallo al Crear Usuario",String.valueOf(HttpStatus.BAD_REQUEST),"El correo ya esta registrado");
        }
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }
/*
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value="/user/createUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public WhatTimeResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }
    */

    //2
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Verifica si el usuario ya existe en la base de datos y retorna un succesfull si es asi.")
    @GetMapping("/user/LoginUser")
    public WhatTimeResponse<UsuarioDto> LoginAcces(String nombre, String contrasena)
            throws WhatTimeExceptions{
        if (usuarioRepository.existsUsuarioByNombreAndContrasena(nombre, contrasena))
        {
            return new WhatTimeResponse<>("Succes Login",String.valueOf(HttpStatus.OK),"OK",
                    usuarioService.findByNombreAndContrasena(nombre,contrasena));
        }else
            {
            return new WhatTimeResponse<>("Fallo al Iniciar Sesión",String.valueOf(HttpStatus.BAD_REQUEST),"Usuario o Contraseña erroneos vuelva a intentar");
        }


    }
//3
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve la lista de todos los usuarios registrados.")
    @GetMapping("/user/getusers")
    public List<UsuarioDto> getUsuarios()
    {
        return usuarioService.getUsuarios();
    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza los valores de la contraseña de un Usuario.")
    @PutMapping("/user/updatepassword")
    public int updateUsuarioPassword(String contrasena, String username){
        try {
            if(usuarioRepository.existsUsuarioByNombre(username)){
            return usuarioService.setupdateUserPassword(contrasena, username);}
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza los valores del correo de un Usuario.")
    @PutMapping("/user/updateemail")
    public int updateUsuarioCorreo(String correo, String username){
        try {
            if(usuarioRepository.existsUsuarioByNombre(username)){
            return usuarioService.setUpdateUserCorreo(correo, username);}
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve la información de un Usuario, atraves de su identificador.")
    @GetMapping("/user/{usuarioName}")
    public WhatTimeResponse<UsuarioDto> getUsuarioByName(@PathVariable String usuarioName)
            throws WhatTimeExceptions {
        if(usuarioRepository.existsUsuarioByNombre(usuarioName))
        {
            return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                    usuarioService.getUsuarioByName(usuarioName));
        }else
            {
                return new WhatTimeResponse<>("No Encontrado ",String.valueOf(HttpStatus.NOT_FOUND),"El usuario no esta registrado");
            }

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
    @ApiOperation("Elimina a un Usuario de la base de datos.")
    @DeleteMapping("/user/deleteuser")
    public void deleteById(Long id)
    {
        usuarioService.deleteById(id);
    }


}
