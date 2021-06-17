package com.example.whattime.DTO;

import com.example.whattime.util.CalendarioStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CalendarioDto {
    private Long id;
    private String name_calendario;
    private CalendarioStatus status;
}