package com.example.whattime.DTO;

import com.example.whattime.util.NotaStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

//@Builder
@Getter
@Setter
public class NotaDto
{
    private Long id;
    private String name_nota;
    private Integer importancia;
    private String contenido;
    private Date fecha_creacion;
    private Date fecha_culminacion;
    private NotaStatus status;
}

