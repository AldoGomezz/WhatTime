package com.example.whattime.services;

import com.example.whattime.DTO.CreatePomodoroDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.DTO.PomodoroDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

public interface PomodoroService {
    PomodoroDto createPomodoro(Integer duracion,String name, Long notaId) throws WhatTimeExceptions;
    int setUpdateDuracionPomodoro(Number duracion,Long pomo_id) throws  WhatTimeExceptions;
    PomodoroDto findPomobyID(Long pomo_id) throws  WhatTimeExceptions;

}
