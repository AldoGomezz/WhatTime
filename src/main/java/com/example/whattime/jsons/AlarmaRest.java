package com.example.whattime.jsons;

import com.example.whattime.util.AlarmaStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlarmaRest {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name_alarma")
    private String name_alarma;

    @JsonProperty("contenido_alarma")
    private String contenido_alarma;

    @JsonProperty("fecha_alarma")
    private Date fecha_alarma;

    @JsonProperty("STATUS")
    private AlarmaStatus status;
}
