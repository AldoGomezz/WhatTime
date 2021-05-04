package com.example.whattime.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PomodoroDto {
    private Long id;
    private String name_pomodoro;
    private Integer duracion;
    //private LocalDateTime fecha_creacion;
}
