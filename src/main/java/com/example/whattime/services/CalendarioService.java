package com.example.whattime.services;

import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.DTO.NotaDto;
<<<<<<< HEAD
=======
import com.example.whattime.entities.Usuario;
>>>>>>> 7be38cd6b3cc969c3cf106695215ab6cb4d7c352
import com.example.whattime.exceptions.WhatTimeExceptions;

import java.util.List;

public interface CalendarioService {
    CalendarioDto createCalendario(CreateCalendarioDto createCalendarioDto, String nombre) throws WhatTimeExceptions;
<<<<<<< HEAD
    CalendarioDto updateCalendario(CalendarioDto calendarioDto) throws WhatTimeExceptions;
    List<NotaDto> getNotasFromUsuario(Long userID) throws WhatTimeExceptions;
=======
    List<NotaDto> getNotesFromUser(Long UserID) throws WhatTimeExceptions;
    void deleteNota(Long NotaID) throws WhatTimeExceptions;
>>>>>>> 7be38cd6b3cc969c3cf106695215ab6cb4d7c352
}