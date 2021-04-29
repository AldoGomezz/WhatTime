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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService
{
    @Autowired  //Inyeccion de Dependencias, con esto podemos usar los Repository
    private UsuarioRepository usuarioRepository;
    private static final ModelMapper modelMapper=new ModelMapper();


    @Override
    public UsuarioDto getUsuarioById(Long usuarioId) throws WhatTimeExceptions {
        return modelMapper.map(getUsuarioById(usuarioId),UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> getUsuarios() throws WhatTimeExceptions {
        List<Usuario> usuariosEntity=usuarioRepository.findAll();
        return usuariosEntity.stream().map(usuario->modelMapper.map(usuario,UsuarioDto.class)).collect(Collectors.toList());
    }
    @Override
    public UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws WhatTimeExceptions {
        Usuario usuario=new Usuario();
        usuario.setNombre(createUsuarioDto.getName());
        usuario.setContrasena(createUsuarioDto.getPassword());
        usuario.setFecha_nacimiento(createUsuarioDto.getFecha_nacimiento());

        try{
            usuario=usuarioRepository.save(usuario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return  modelMapper.map(getUsuarioEntity(usuario.getId()),UsuarioDto.class);
    }

    private Usuario getUsuarioEntity(Long usuarioId) throws WhatTimeExceptions
    {
        return usuarioRepository.findById(usuarioId).orElseThrow(()->new NotFoundException("NOTFOUND-4040","USUARIO-NOTFOUND-404"));
    }
}
