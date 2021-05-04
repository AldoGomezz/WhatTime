package com.example.whattime.services.impl;

import com.example.whattime.DTO.AlarmaDto;
import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.DTO.CreateAlarmaDto;
import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.entities.Alarma;
import com.example.whattime.entities.Calendario;
import com.example.whattime.entities.Usuario;
import com.example.whattime.exceptions.InternalServerErrorException;
import com.example.whattime.exceptions.NotFoundException;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.repositories.AlarmaRepository;
import com.example.whattime.services.AlarmaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmaServiceImpl implements AlarmaService {

    @Autowired
    private CalendarioServiceImpl calendarioServiceImpl;

    @Autowired
    private AlarmaRepository alarmaRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    /*@Override
    public AlarmaDto createAlarma(CreateAlarmaDto createAlarmaDto, Long name)  throws WhatTimeExceptions
    {
        Alarma alarma = new Alarma();
        alarma.setName_alarma(createAlarmaDto.getName_alarma());
        alarma.setContenido_alarma(createAlarmaDto.getContenido_alarma());

        Calendario currentCalendario = new Calendario();
        try {
            currentCalendario = calendarioServiceImpl.getCalendarioEntity(name);
        }catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Calendario", "INTERNAL_SERVER_ERROR Calendario");
        }

        try{
            alarma = alarmaRepository.save(alarma);
        }catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
            return modelMapper.map(getAlarmaEntity(alarma.getId()),AlarmaDto.class);

    }*/
    @Override
    public AlarmaDto createAlarma(CreateAlarmaDto createAlarmaDto, Long id_Calendar) throws WhatTimeExceptions{
        Alarma alarma = new Alarma();
        alarma.setName_alarma(createAlarmaDto.getName_alarma());
        alarma.setContenido_alarma(createAlarmaDto.getContenido_alarma());

        //Por ahora usuario Fijo para testear
        Calendario calendario = new Calendario();
        try{
            calendario = calendarioServiceImpl.getCalendarioEntity(id_Calendar);
        }
        catch (Exception ex){
            //Checkear si es error correcto
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Usuario","INTERNAL_SERVER_ERROR Usuario");
        }
        alarma.setCalendario(calendario);
        try{
            alarma = alarmaRepository.save(alarma);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getAlarmaEntity(alarma.getId()), AlarmaDto.class);
    }
    @Override
    public AlarmaDto updateAlarma(CreateAlarmaDto createAlarmaDto) throws WhatTimeExceptions{
        return null;
    }

    public Alarma getAlarmaEntity(Long alarmaId) throws WhatTimeExceptions {
        return alarmaRepository.findById(alarmaId).orElseThrow(() ->new NotFoundException("NotFound-4040", "Nota-NotFound-404"));
    }
}
