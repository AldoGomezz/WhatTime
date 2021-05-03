package com.example.whattime.services.impl;

import com.example.whattime.DTO.CalendarioDto;
import com.example.whattime.DTO.CreateCalendarioDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

public interface CalendarioService {
    CalendarioDto createCalendario(CreateCalendarioDto createCalendarioDto) throws WhatTimeExceptions;
    CalendarioDto updateCalendario(CalendarioDto calendarioDto) throws WhatTimeExceptions;
}