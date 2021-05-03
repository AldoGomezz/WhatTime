/*package com.example.whattime.converters;

import com.example.whattime.DTO.NotaDto;
import com.example.whattime.entities.Nota;

public class NotaConverter extends AbstractConverter<Nota, NotaDto> {

    @Override
    public NotaDto fromEntity (Nota entity){
        if (entity == null) return null;

        return NotaDto.builder()
                .id(entity.getId())
                .name_nota(entity.getName_nota())
                .importancia(entity.getImportancia())
                .contenido(entity.getContenido())
                /*.fecha_creacion(entity.getFecha_creacion())*/
              /*.build();
    }

    @Override
    public Nota fromDTO(NotaDto dto) {
        if (dto == null) return null;
        return Nota.builder()
                .id(dto.getId())
                .name_nota(dto.getName_nota())
                .importancia(dto.getImportancia())
                .contenido(dto.getContenido())
                /*.fecha_creacion(dto.getFecha_creacion())*/
                /*.build();
    }
}*/