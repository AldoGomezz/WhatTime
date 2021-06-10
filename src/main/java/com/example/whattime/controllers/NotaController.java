package com.example.whattime.controllers;

import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/AqueHoraNota")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/notas")
    public WhatTimeResponse<NotaDto> createNota(@RequestBody CreateNotaDto createNotaDto, Long userId) throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.createNota(createNotaDto,userId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public WhatTimeResponse<NotaDto> updateNota(@RequestBody NotaDto notaDto) throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes to update Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.updateNota(notaDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updNotaName")
    public int updateNotaName(@RequestBody String name_nota, Long noteId) {
        try {
            return notaService.setUpdateNameNota(name_nota, noteId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updNotaDescrip")
    public int updateNotaDescription(@RequestBody String contenido, Long noteId) {
        try {
            return notaService.setUpdateDescriptionNota(contenido, noteId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/notaUser")
    public WhatTimeResponse<List<NotaDto>> getNotesByUserID(Long usuarioId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                notaService.getNotesUser(usuarioId));
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deletenote")
    public void deleteNote(Long noteId)
    {
        try {
            notaService.DeleteNote(noteId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }

    }

    /*@ResponseStatus(HttpStatus.OK)
    @DeleteMapping("borrarnota")
    public WhatTimeResponse<NotaDto> borrarNota(Long nota_id)throws
            WhatTimeExceptions{
        return new WhatTimeResponse<>("Se elimno de forma correcta",String.valueOf(HttpStatus.OK),"OK",notaService.borrarNota(nota_id));
    }*/

}

