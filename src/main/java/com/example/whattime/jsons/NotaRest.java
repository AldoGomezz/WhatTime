package com.example.whattime.jsons;

import com.example.whattime.util.NotaStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotaRest
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name_nota")
    private String name_nota;

    @JsonProperty("importancia")
    private Number importancia;

    @JsonProperty("contenido")
    private String contenido;


    @JsonProperty("STATUS")
    private NotaStatus status;

    @JsonProperty("fecha_creacion")
    private Date fecha_creacion;

    @JsonProperty("fecha_culminacion")
    private Date fecha_culminacion;

}
