package com.example.whattime.controllers;

import com.example.whattime.DTO.AlarmaDto;
import com.example.whattime.DTO.CreateAlarmaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.repositories.AlarmaRepository;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.AlarmaService;
import com.example.whattime.util.AlarmaStatus;
import com.example.whattime.util.NotaStatus;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path ="/AquehoraAlarma")
public class AlarmaController {
    @Autowired
    private AlarmaService alarmaService;
    @Autowired
    private AlarmaRepository alarmaRepository;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/alarmas")
    public WhatTimeResponse<AlarmaDto> createAlarm(@RequestBody CreateAlarmaDto createAlarmaDto, Long id_Calendar) throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Sucess to create Alarma", String.valueOf(HttpStatus.OK), "Ok",
                alarmaService.createAlarm(createAlarmaDto, id_Calendar));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Nos devuelve una lista que contiene todas las alarmas")
    @GetMapping("/alarma/getalarms")
    public List<AlarmaDto> getAlarms() {
        return alarmaService.getAllAlarms();
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza el nombre de una alarma ya existente, requiere el nuevo nombre y el id de la alarma a cambiar")
    @PutMapping("/alrma/updsatealarms")
    public int updateAlarmaName(String name_alarma, Long alarmId) {
        try {
            if (alarmaRepository.existsById(alarmId)) {
                return alarmaService.setUpdateNameAlarm(name_alarma, alarmId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza la descripción de una alarma ya existente")
    @PutMapping("/alarma/updatedescription")
    public int updateAlarmaDescription(String contenido_alarma, Long alarmId) {
        try {
            if (alarmaRepository.existsById(alarmId)) {
                return alarmaService.setUpdateDescriptionAlarm(contenido_alarma, alarmId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza el Status de una alarma ya existente")
    @PutMapping("/alarma/updateStatus")
    public int updateStatus(AlarmaStatus status, Long alarmId) {
        try {
            if (alarmaRepository.existsById(alarmId)) {
                return alarmaService.setUpdateStatusAlarm(status, alarmId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Borramos una alarma, se pide el id de la alarma a borrar")
    @DeleteMapping("/alarma/deletealarm")
    public void deleteAlarm(Long alarmId) {
        try {
            if (alarmaRepository.existsById(alarmId)) {
                alarmaService.DeleteAlarm(alarmId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista que contiene todas las alarmas de un calendario, se requiere el id del calendario de quien se devolverán las alarmas")
    @GetMapping("/alarma/getalarmbycalendary")
    public WhatTimeResponse<List<AlarmaDto>> getAlarmCalendary(Long calendarioID)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
                alarmaService.getAlarmCalendary(calendarioID));
    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista de alarma filtradas por su fecha")
    @GetMapping("/alarma/galarmaFech")

    public WhatTimeResponse<List<AlarmaDto>> getAlarmaByFechaAlarma(Date fecha_alarma) throws
            WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", alarmaService.getAlarmaByFechaAlarma(fecha_alarma));
    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Nos devuelve una alarma segun su Identificador")
    @GetMapping("/alrma/getAlarma")
    public WhatTimeResponse<AlarmaDto> getAlarmaID(Long id) throws
            WhatTimeExceptions {
        if (alarmaRepository.existsById(id)) {
            return new WhatTimeResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", alarmaService.findIDAlarm(id));

        } else {
            return new WhatTimeResponse<>("Fallo al obtener Alarma", String.valueOf(HttpStatus.NOT_FOUND), "Alarma no existente");

        }
    }
}