package com.example.whattime.controllers;

import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;

import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.repositories.NotaRepository;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.NotaService;
import com.example.whattime.util.NotaStatus;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/WhatTimeNota")
public class NotaController {
    @Autowired
    private NotaService notaService;
    @Autowired
    private NotaRepository notaRepository;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Crea una nota usando el nombre de la nota, el contenido, su importancia, fecha de creación y el id del usuario que lo creó")
    @PostMapping("/nota/create")
    public WhatTimeResponse<NotaDto> createNota(@RequestBody CreateNotaDto createNotaDto, Long id) throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes to create Nota",String.valueOf(HttpStatus.OK),"Ok",
                notaService.createNota(createNotaDto,id));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Nos devuelve una lista que contiene todas las notas")
    @GetMapping("/nota/getnotes")
    public List<NotaDto> getNotes(){
        return notaService.getAllNotes();
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza el nombre de una nota ya existente, requiere el nuevo nombre de la nota y el id de la nota a cambiar")
    @PutMapping("/nota/updatename")
    public int updateNotaName(String name_nota, Long noteId) {
        try {
            if(notaRepository.existsById(noteId))
            {
                return notaService.setUpdateNameNota(name_nota, noteId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza la descripción de una nota ya existente, requiere el nuevo contenido de la nota y el ide de la nota a modificar")
    @PutMapping("/nota/updatedescription")
    public int updateNotaDescription(String contenido, Long noteId) {
        try {
            if(notaRepository.existsById(noteId)) {
                return notaService.setUpdateDescriptionNota(contenido, noteId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza el Status de una nota ya existente, requiere el nuevo Status de la nota y el ide de la nota a modificar")
    @PutMapping("/nota/updateStatus")
    public int updateStatus(NotaStatus status, Long noteId) {
        try {
            if(notaRepository.existsById(noteId)) {
                return notaService.setUpdateStatus(status, noteId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista que contiene todas las notas de un usuario, se requiere el id del usuario de quien se devolverán las notas")
    @GetMapping("/nota/getnotebyuser")
    public WhatTimeResponse<List<NotaDto>> getNotesByUserID(Long usuarioId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                notaService.getNotesUser(usuarioId));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Borramos una nota, se pide el id de la nota a borrar")
    @DeleteMapping("/nota/deletenote")
    public void deleteNote(Long noteId)
    {
        try {
            if(notaRepository.existsById(noteId)){
            notaService.DeleteNote(noteId);
            }
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Nos devuelve una lista de notas filtradas segun el nombre y nos devuelve las que contengan ese o esos caracteres")
    @GetMapping("/nota/gnotename")
    public WhatTimeResponse<List<NotaDto>> getNotaByNameandContaining(String nombre_nota,Long usuarioID)throws
            WhatTimeExceptions {
        return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotaByNombreNotaContaining(nombre_nota,usuarioID));
    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista de notas pertenecientes a un usuario filtradas por su importancia, se pide ingresar la importancia y el Id de usuario")
    @GetMapping("/nota/gnoteByImport")
    public WhatTimeResponse<List<NotaDto>> getNotaByImportancia(Integer importancia,Long usuarioID)throws
            WhatTimeExceptions {
        if(importancia>=1 &&importancia<=3)
        {
            return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByImportancia(importancia,usuarioID));
        }else
            {
                return  new WhatTimeResponse<>("Fallo Obtener Nota",String.valueOf(HttpStatus.BAD_REQUEST),"Ingrese importancia entre 1 -3 ");
            }

    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve una lista de notas filtradas por su fecha de creación, nos pide una fecha")
    @GetMapping("/nota/gnoteFC")

    public WhatTimeResponse<List<NotaDto>> getNotaByNamebyFechaCreate( Date fecha_Creacion)throws
            WhatTimeExceptions {
        return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByFechaCreacion(fecha_Creacion));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Nos devuelve una lista de notas filtradas segun su Fecha de Creacion y Fecha de Culminacion")
    @GetMapping("/nota/gnoteFCbtFC")
    public WhatTimeResponse<List<NotaDto>> getNotaByNamebyFechaCreateBetweenFCulmina(Date fecha_Creacion,
                                                                                     Date fecha_culminacion)throws
            WhatTimeExceptions {
        return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.getNotasByFechaBetween(fecha_Creacion,fecha_culminacion));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Nos devuelve una nota segun su Identificador")
    @GetMapping("/nota/getNota")
    public WhatTimeResponse<NotaDto> getNotaID(Long id)throws
            WhatTimeExceptions {
        if(notaRepository.existsById(id)){
            return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",notaService.findIDNota(id));

        }else
        {
            return  new WhatTimeResponse<>("Fallo al obtener Nota",String.valueOf(HttpStatus.NOT_FOUND),"Nota no existente");

        }
    }




}

