package com.example.whattime.services.impl;

import com.example.whattime.DTO.AlarmaDto;
import com.example.whattime.DTO.CreateAlarmaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.entities.Alarma;
import com.example.whattime.entities.Calendario;
import com.example.whattime.entities.Nota;
import com.example.whattime.exceptions.InternalServerErrorException;
import com.example.whattime.exceptions.NotFoundException;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.repositories.AlarmaRepository;
import com.example.whattime.services.AlarmaService;
import com.example.whattime.util.AlarmaStatus;
import com.example.whattime.util.NotaStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;
@Service
public class AlarmaServiceImpl implements AlarmaService {

    @Autowired
    private CalendarioServiceImpl calendarioServiceImpl;

    @Autowired
    private AlarmaRepository alarmaRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public AlarmaDto createAlarm(CreateAlarmaDto createAlarmaDto, Long idCalendario) throws WhatTimeExceptions{
        Alarma alarma = new Alarma();
        alarma.setName_alarma(createAlarmaDto.getName_alarma());
        alarma.setContenido_alarma(createAlarmaDto.getContenido_alarma());
        alarma.setFecha_alarma(createAlarmaDto.getFecha_alarma());
        alarma.setStatus(AlarmaStatus.ACTIVE);

        //Por ahora usuario Fijo para testear
      Calendario currentcalendario = new Calendario();
        try{
           currentcalendario = calendarioServiceImpl.getCalendarioEntity(idCalendario);
        }
        catch (Exception ex){
            //Checkear si es error correcto
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Nota","INTERNAL_SERVER_ERROR Nota");
        }
        alarma.setCalendario(currentcalendario);

        try{
            alarma = alarmaRepository.save(alarma);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getAlarmaEntity(alarma.getId()), AlarmaDto.class);
    }

    @Override
    public AlarmaDto findIDAlarm(Long id) throws WhatTimeExceptions {
        return modelMapper.map(getAlarmaEntity(id),AlarmaDto.class);
    }

    @Override
    public int setUpdateNameAlarm(String name_alarma, Long alarmaId) throws WhatTimeExceptions {
        try{
            return alarmaRepository.setUpdateNameAlarm(name_alarma, alarmaId);
        }catch (Exception ex){throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");}
        //return notaRepository.setUpdateNoteName(name_nota,noteId);
    }
    @Override
    public int setUpdateDescriptionAlarm(String contenido_alarma, Long alarma_id) throws WhatTimeExceptions {
        return alarmaRepository.setUpdateDescriptionAlarm(contenido_alarma, alarma_id);
    }
    @Override
    public int setUpdateStatusAlarm(AlarmaStatus status, Long alarm_id) throws WhatTimeExceptions {
        return alarmaRepository.setUpdateStatusAlarm(status, alarm_id);
    }

    @Override
    public List<AlarmaDto> getAlarmCalendary(Long calendario_id) throws WhatTimeExceptions {
        List<Alarma> alarmEntity=alarmaRepository.findAlarm(calendario_id);
        return alarmEntity.stream().map(alarma->modelMapper.map(alarma, AlarmaDto.class)).collect(Collectors.toList());
    }

    @Override
    public void DeleteAlarm(Long alarm_id) throws WhatTimeExceptions
    {
       alarmaRepository.deleteAlarm(alarm_id);
    }
    @Override
    public List<AlarmaDto> getAllAlarms() {
        List<Alarma> alarmEntity=alarmaRepository.findAll();
        return alarmEntity.stream().map(alarma -> modelMapper.map(alarma,AlarmaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<AlarmaDto> getAlarmaByFechaAlarma(Date fecha_alarma) throws WhatTimeExceptions {
        List<Alarma> alarmEntity= alarmaRepository.findFechaAlarma(fecha_alarma);
        return alarmEntity.stream().map(alarma->modelMapper.map(alarma, AlarmaDto.class)).collect(Collectors.toList());
    }

    public Alarma getAlarmaEntity(Long alarmaId) throws WhatTimeExceptions {
        return alarmaRepository.findById(alarmaId).orElseThrow(() ->new NotFoundException("NotFound-4040", "Nota-NotFound-404"));
    }
}
