package com.example.whattime.services;

import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.entities.Nota;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.util.NotaStatus;

import java.util.Date;
import java.util.List;

public interface NotaService {

    NotaDto createNota(CreateNotaDto createNotaDto, Long userID) throws WhatTimeExceptions;
    int setUpdateNameNota(String name_nota,Long note_id) throws  WhatTimeExceptions;
    int setUpdateDescriptionNota(String contenido,Long note_id) throws  WhatTimeExceptions;
    int setUpdateStatus(NotaStatus status, Long notaId) throws WhatTimeExceptions;
    List<NotaDto> getNotesUser(Long username) throws  WhatTimeExceptions;
    void DeleteNote(Long noteId) throws WhatTimeExceptions;
    List<NotaDto> getAllNotes();
    List<NotaDto> getNotaByNombreNotaContaining(String nombre_nota,Long usuarioID) throws  WhatTimeExceptions;
    List<NotaDto> getNotasByImportancia(Integer importancia,Long usuarioID) throws  WhatTimeExceptions;
    //List<NotaDto> getNotasFechasCreacion() throws  WhatTimeExceptions;

    List<NotaDto> getNotasByFechaCreacion(Date fecha_Creacion) throws  WhatTimeExceptions;
    List<NotaDto> getNotasByFechaBetween(Date fecha_Creacion,Date fecha_culminacion) throws  WhatTimeExceptions;



}
