package com.example.whattime.controllers;

import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.impl.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/AqueHoraCalendario")
public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/calendarios")
    public WhatTimeResponse<CalendarioDto> createCalendario(@RequestBody CreateCalendarioDto createCalendarioDto)
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Success to create Calendario",String.valueOf(HttpStatus.OK),"Ok",
                calendarioService.createCalendario(createCalendarioDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public WhatTimeResponse<CalendarioDto> updateCalendario(@RequestBody CalendarioDto calendarioDto)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Success to update Calendario",String.valueOf(HttpStatus.OK),"Ok",
                calendarioService.updateCalendario(calendarioDto));
    }
}
