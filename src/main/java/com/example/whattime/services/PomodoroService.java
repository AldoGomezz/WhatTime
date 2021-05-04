package com.example.whattime.services;

import com.example.whattime.DTO.CreatePomodoroDto;
import com.example.whattime.DTO.PomodoroDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

public interface PomodoroService {
    PomodoroDto createPomodoro(CreatePomodoroDto createPomodoroDto,Long notaId) throws WhatTimeExceptions;

}
