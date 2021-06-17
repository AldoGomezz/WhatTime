package com.example.whattime.services;

import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

import java.util.List;

public interface CalendarioService {
    CalendarioDto createCalendario(CreateCalendarioDto createCalendarioDto, String nombre) throws WhatTimeExceptions;
    CalendarioDto updateCalendario(CalendarioDto calendarioDto) throws WhatTimeExceptions;
    List<NotaDto> getNotasFromUsuario(Long userID) throws WhatTimeExceptions;
}