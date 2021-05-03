package com.example.whattime.controllers;

import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.impl.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/AqueHoraNota")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/notas")
    public WhatTimeResponse<NotaDto> createNota(@RequestBody CreateNotaDto createNotaDto, String nombre) throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.createNota(createNotaDto,nombre));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public WhatTimeResponse<NotaDto> updateNota(@RequestBody NotaDto notaDto) throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes to update Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.updateNota(notaDto));
    }

    /*
        @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios")
    public AqueHoraResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto)
            throws AqueHoraExceptions{
        return new AqueHoraResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                usuarioService.createUsuario(createUsuarioDto));
    }
     */
}
