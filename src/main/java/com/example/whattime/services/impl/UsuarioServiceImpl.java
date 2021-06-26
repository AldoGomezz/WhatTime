package com.example.whattime.services.impl;

import com.example.whattime.DTO.CreateUsuarioDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.entities.Usuario;
import com.example.whattime.exceptions.InternalServerErrorException;
import com.example.whattime.exceptions.NotFoundException;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.repositories.UsuarioRepository;
import com.example.whattime.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired  //Inyeccion de Dependencias, con esto podemos usar los Repository
    private UsuarioRepository usuarioRepository;
    private static final ModelMapper modelMapper=new ModelMapper();


    @Override
    public UsuarioDto getUsuarioByName(String usuarioName) throws WhatTimeExceptions {
        return modelMapper.map(getUsuarioEntityName(usuarioName),UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> getUsuarios() {
        List<Usuario> usuariosEntity=usuarioRepository.findAll();
        return usuariosEntity.stream().map(usuario->modelMapper.map(usuario,UsuarioDto.class)).collect(Collectors.toList());
    }
    @Override
    public UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws WhatTimeExceptions {
        Usuario existcorreo=usuarioRepository.findByCorreo(createUsuarioDto.getCorreo()).orElseThrow(null);
        if(existcorreo!=null)
        {
            throw new InternalServerErrorException("CORREO YA EXISTENTE","CORREO YA EXISTENTE");
        }else
            {
                Usuario usuario=new Usuario();
                usuario.setNombre(createUsuarioDto.getName());

                usuario.setCorreo(createUsuarioDto.getCorreo());
                usuario.setContrasena(createUsuarioDto.getPassword());
                try{
                    usuario=usuarioRepository.save(usuario);
                }catch (Exception ex){
                    throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR",ex);
                }
                return  modelMapper.map(getUsuarioEntity(usuario.getId()),UsuarioDto.class);
        }
    }

    @Override
    public int setupdateUserPassword(String contrasena, String username) throws WhatTimeExceptions
    {
        return usuarioRepository.setUpdatePassword(contrasena,username);
    }

    @Override
    public int setUpdateUserCorreo(String correo, String username) throws WhatTimeExceptions {
        return usuarioRepository.setUpdateUserCorreo(correo,username);
    }

    @Override
    public void deleteById(Long id)
    {
        usuarioRepository.deleteById(id);
    }




    @Override
    public UsuarioDto findByNombreAndContrasena(String nombre, String pass) throws WhatTimeExceptions
    {
        return modelMapper.map(getUsuarioAcces(nombre, pass), UsuarioDto.class);
    }



    public Usuario getUsuarioEntity(Long usuarioId) throws WhatTimeExceptions
    {
        return usuarioRepository.findById(usuarioId).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
    public Usuario getUsuarioEntityName(String name) throws WhatTimeExceptions
    {
        return usuarioRepository.findByNombre(name).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
    public Usuario getUsuarioAcces(String name,String pass) throws WhatTimeExceptions
    {
        return usuarioRepository.findByNombreAndContrasena(name,pass).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
    public Usuario getUsuarioEntityCorreo(String correo) throws WhatTimeExceptions
    {
        return usuarioRepository.findByCorreo(correo).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }

}
