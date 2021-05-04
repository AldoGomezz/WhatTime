package com.example.whattime.services.impl;

import com.example.whattime.DTO.*;
import com.example.whattime.entities.Nota;
import com.example.whattime.entities.Pomodoro;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.exceptions.InternalServerErrorException;
import com.example.whattime.exceptions.NotFoundException;
import com.example.whattime.repositories.PomodoroRepository;
import com.example.whattime.services.PomodoroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PomodoroServiceImpl implements PomodoroService {
    @Autowired
    private UsuarioServiceImpl usuarioServiceIpml;

    @Autowired
    private NotaServiceImpl notaServiceImpl;


    @Autowired
    private PomodoroRepository pomodoroRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public PomodoroDto createPomodoro(CreatePomodoroDto createPomodoroDto, Long notaId) throws WhatTimeExceptions{
        Pomodoro pomodoro = new Pomodoro();
        pomodoro.setDuracion(createPomodoroDto.getDuracion());
        pomodoro.setName_pomodoro(createPomodoroDto.getName_pomodoro());
        //pomodoro.setFecha_creacion(createPomodoroDto.getFecha_creacion());

        //Por ahora usuario Fijo para testear
        Nota currentNota=new Nota();
        try{
            currentNota=notaServiceImpl.getNotaEntity(notaId);
        } catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Nota","INTERNAL_SERVER_ERROR Nota");
        }
        pomodoro.setNota(currentNota);

        try{
            pomodoro=pomodoroRepository.save(pomodoro);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return  modelMapper.map(getPomodoroEntity(pomodoro.getId()),PomodoroDto.class);
    }

    public Pomodoro getPomodoroEntity(Long pomodoroId)throws WhatTimeExceptions{
        return pomodoroRepository.findById(pomodoroId).orElseThrow(()->new NotFoundException("NotFound-4040", "Pomodoro-NotFound-404"));
    }
}

