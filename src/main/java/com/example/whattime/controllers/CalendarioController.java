package com.example.whattime.controllers;

import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/AqueHoraCalendario")
public class CalendarioController {
    @Autowired
    private CalendarioService calendarioService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/calendarios")
    public WhatTimeResponse<CalendarioDto> createCalendario(@RequestBody CreateCalendarioDto createCalendarioDto, String name)
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Success to create Calendario",String.valueOf(HttpStatus.OK),"Ok",
                calendarioService.createCalendario(createCalendarioDto,name));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/getnotebyuser")
    public WhatTimeResponse<List<NotaDto>> getNotesByUserID(Long usuarioId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                calendarioService.getNotesFromUser(usuarioId));
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/nota/deletenote")
    public void deleteNote(Long noteId)
    {
        try {
            calendarioService.deleteNota(noteId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/getnotebyuser")
    public WhatTimeResponse<List<NotaDto>> getNotesByUserID(Long usuarioId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                calendarioService.getNotasFromUsuario(usuarioId));
    }
}
