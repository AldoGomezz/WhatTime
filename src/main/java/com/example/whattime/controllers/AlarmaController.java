package com.example.whattime.controllers;

import com.example.whattime.DTO.AlarmaDto;
import com.example.whattime.DTO.CreateAlarmaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.AlarmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path ="/AquehoraAlarma")
public class AlarmaController {
    @Autowired
    private AlarmaService alarmaService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/alarmas")
    public WhatTimeResponse<AlarmaDto> createAlarma(@RequestBody CreateAlarmaDto createAlarmaDto, Long id_Calendar) throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Sucess to create Alarma", String.valueOf(HttpStatus.OK), "Ok",
                alarmaService.createAlarma(createAlarmaDto, id_Calendar));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public WhatTimeResponse<AlarmaDto> updateAlarma(@RequestBody CreateAlarmaDto createAlarmaDto) throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Sucess to update Alarma", String.valueOf(HttpStatus.OK), "Ok",
                alarmaService.updateAlarma(createAlarmaDto));
    }
}