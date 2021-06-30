package com.example.whattime.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@ApiModel(description = "Esta clase representa los datos para solicitar un Usuario")
public class PomodoroDto {
    private Long id;
    private String name_pomodoro;
    private Integer duracion;
    //private LocalDateTime fecha_creacion;
}
