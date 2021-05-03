package com.example.whattime.services.impl;

import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

public interface NotaService {

    NotaDto createNota(CreateNotaDto createNotaDto,String nombre) throws WhatTimeExceptions;
    NotaDto updateNota(NotaDto notaDto) throws WhatTimeExceptions;
}
