package com.example.whattime.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos solcitados de un Pomodoro")
public class CreatePomodoroDto //Cosas que quiero obtener cuando pregunto por un Pomodoro
{
    private String name_pomodoro;
    private Integer duracion;
    //private LocalDateTime fecha_creacion;
}
