package com.example.whattime.services.impl;

import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.entities.Calendario;
import com.example.whattime.entities.Usuario;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.exceptions.NotFoundException;
import com.example.whattime.exceptions.InternalServerErrorException;
import com.example.whattime.services.impl.CalendarioService;
import com.example.whattime.repositories.CalendarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarioServiceImpl implements CalendarioService {
    @Autowired
    private UsuarioServiceImpl usuarioServiceIpml;

    @Autowired
    private CalendarioRepository calendarioRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public CalendarioDto createCalendario(CreateCalendarioDto createCalendarioDto) throws WhatTimeExceptions{
        Calendario calendario = new Calendario();
        calendario.setName_calendario(createCalendarioDto.getName_calendario());

        //Por ahora usuario Fijo para testear
        Usuario currentUsuario = new Usuario();
        try{
            currentUsuario = usuarioServiceIpml.getUsuarioEntityName((long)9);
        }
        catch (Exception ex){
            //Checkear si es error correcto
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Usuario","INTERNAL_SERVER_ERROR Usuario");
        }
        calendario.setUsuario(currentUsuario);

        try{
            calendario = calendarioRepository.save(calendario);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getCalendarioEntity(calendario.getId()), CalendarioDto.class);
    }
    @Override
    public CalendarioDto updateCalendario(CalendarioDto calendarioDto) throws WhatTimeExceptions {
        return null;
    }
    public Calendario getCalendarioEntity(Long CalendarioId) throws WhatTimeExceptions{
        return calendarioRepository.findById(CalendarioId).orElseThrow(()->new NotFoundException("NotFound-4040", "Calendario-NotFound-404"));
    }

}
