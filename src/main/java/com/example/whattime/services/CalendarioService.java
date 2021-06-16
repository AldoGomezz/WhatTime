package com.example.whattime.services;

import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.entities.Usuario;
import com.example.whattime.exceptions.WhatTimeExceptions;

import java.util.List;

public interface CalendarioService {
    CalendarioDto createCalendario(CreateCalendarioDto createCalendarioDto, String nombre) throws WhatTimeExceptions;
    List<NotaDto> getNotesFromUser(Long UserID) throws WhatTimeExceptions;
    void deleteNota(Long NotaID) throws WhatTimeExceptions;
}