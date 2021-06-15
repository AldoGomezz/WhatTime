package com.example.whattime.controllers;

import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/AqueHoraNota")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/nota/create")
    public WhatTimeResponse<NotaDto> createNota(@RequestBody CreateNotaDto createNotaDto, Long userId) throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.createNota(createNotaDto,userId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/getnotes")
    public WhatTimeResponse<List<NotaDto>> getNotes()
            throws WhatTimeExceptions{
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                notaService.getAllNotes());
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/nota/updatename")
    public int updateNotaName(@RequestBody String name_nota, Long noteId) {
        try {
            return notaService.setUpdateNameNota(name_nota, noteId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/nota/updatedescription")
    public int updateNotaDescription(@RequestBody String contenido, Long noteId) {
        try {
            return notaService.setUpdateDescriptionNota(contenido, noteId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/getnotebyuser")
    public WhatTimeResponse<List<NotaDto>> getNotesByUserID(Long usuarioId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                notaService.getNotesUser(usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/nota/deletenote")
    public void deleteNote(Long noteId)
    {
        try {
            notaService.DeleteNote(noteId);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }

    }

   @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/gnotename")
    public WhatTimeResponse<List<NotaDto>> getNotaByNameandContaining(String nombre_nota,Long usuarioID)throws
            WhatTimeExceptions {
        return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotaByNombreNotaContaining(nombre_nota,usuarioID));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/gnoteByImport")
    public WhatTimeResponse<List<NotaDto>> getNotaByImportancia(Integer importancia,Long usuarioID)throws
            WhatTimeExceptions {
        return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByImportancia(importancia,usuarioID));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/gnoteFC")
    public WhatTimeResponse<List<NotaDto>> getNotaByNamebyFechaCreate(Date fecha_Creacion)throws
            WhatTimeExceptions {
        return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByFechaCreacion(fecha_Creacion));
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/nota/gnoteFCbtFC")
    public WhatTimeResponse<List<NotaDto>> getNotaByNamebyFechaCreateBetweenFCulmina(Date fecha_Creacion,Date fecha_culminacion)throws
            WhatTimeExceptions {
        return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByFechaBetween(fecha_Creacion,fecha_culminacion));
    }

}

