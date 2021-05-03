package com.example.whattime.services.impl;

import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.DTO.UsuarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

import java.util.List;

public interface NotaService {

    NotaDto createNota(CreateNotaDto createNotaDto,Long userId) throws WhatTimeExceptions;
    NotaDto updateNota(NotaDto notaDto) throws WhatTimeExceptions;
    int setUpdateNameNota(String name_nota,Long note_id) throws  WhatTimeExceptions;
    int setUpdateDescriptionNota(String contenido,Long note_id) throws  WhatTimeExceptions;
    List<NotaDto> getNotesUser(Long username) throws  WhatTimeExceptions;

}
