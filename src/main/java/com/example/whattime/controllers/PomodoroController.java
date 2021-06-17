package com.example.whattime.controllers;

import com.example.whattime.DTO.*;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost/4200")
@RequestMapping(path = "/AqueHoraPomodoro")

public class PomodoroController {
    @Autowired
    private PomodoroService pomodoroService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/pomodoros")
    public WhatTimeResponse<PomodoroDto> createPomodoro(@RequestBody CreatePomodoroDto createPomodoro, Long notaId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                pomodoroService.createPomodoro(createPomodoro,notaId));
    }
}
