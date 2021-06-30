package com.example.whattime.controllers;

import com.example.whattime.DTO.*;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.responses.WhatTimeResponse;
import com.example.whattime.services.PomodoroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/AqueHoraPomodoro")

public class PomodoroController {
    @Autowired
    private PomodoroService pomodoroService;

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Crea un Pomodoro")
    @PostMapping("/pomo/pomodoros")
    public WhatTimeResponse<PomodoroDto> createPomodoro(Long duracion,String nombre, Long notaId)
            throws WhatTimeExceptions {
        return new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                pomodoroService.createPomodoro(duracion.intValue(),nombre,notaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualiza los valores del correo de un Usuario.")
    @PutMapping("/pomo/updateDuracion")
    public int updateDuracion(Long duracion, Long pomo_id){
        try {
            return pomodoroService.setUpdateDuracionPomodoro(duracion.intValue(), pomo_id);
        } catch (WhatTimeExceptions whatTimeExceptions) {
            whatTimeExceptions.printStackTrace();
        }
        return 0;
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Obtiene un Pomodoro por ID")
    @GetMapping("/pomo/getPomodoro")
    public WhatTimeResponse<PomodoroDto> getPomoID(Long id)throws
            WhatTimeExceptions {
            return  new WhatTimeResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",pomodoroService.findPomobyID(id));
        }


}
