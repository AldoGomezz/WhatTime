package com.example.whattime.services.impl;


import com.example.whattime.DTO.CreateNotaDto;
import com.example.whattime.DTO.NotaDto;
import com.example.whattime.entities.Nota;
import com.example.whattime.entities.Usuario;
import com.example.whattime.exceptions.InternalServerErrorException;
import com.example.whattime.exceptions.NotFoundException;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.repositories.NotaRepository;
import com.example.whattime.services.NotaService;
import com.example.whattime.util.NotaStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaServiceImpl implements NotaService
{

    @Autowired
    private UsuarioServiceImpl usuarioServiceIpml;


    @Autowired
    private NotaRepository notaRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public NotaDto createNota(CreateNotaDto createNotaDto, Long userId) throws WhatTimeExceptions{
        Nota nota = new Nota();
        nota.setName_nota(createNotaDto.getName_nota());
        nota.setImportancia(createNotaDto.getImportancia());
        nota.setContenido(createNotaDto.getContenido());
        nota.setFecha_creacion(createNotaDto.getFecha_creacion());
        nota.setFecha_culminacion(createNotaDto.getFecha_culminacion());
        nota.setStatus(NotaStatus.ACTIVE);

        Usuario currentoUsuario=new Usuario();
        try{
            currentoUsuario = usuarioServiceIpml.getUsuarioEntity(userId);
        }
        catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR Usuario","INTERNAL_SERVER_ERROR Usuario");
        }

        nota.setUsuario(currentoUsuario);

        try{
            nota = notaRepository.save(nota);
        } catch (Exception ex) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getNotaEntity(nota.getId()), NotaDto.class);
    }


    @Override
    public int setUpdateNameNota(String name_nota, Long noteId) throws WhatTimeExceptions {
        return notaRepository.setUpdateNoteName(name_nota,noteId);
    }

    @Override
    public int setUpdateDescriptionNota(String contenido, Long note_id) throws WhatTimeExceptions {
        return notaRepository.updateDescriptionNota(contenido,note_id);
    }

    @Override
    public List<NotaDto> getNotesUser(Long username) throws WhatTimeExceptions {
        List<Nota> noteEntity=notaRepository.findNotas(username);
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }

    @Override
    public void DeleteNote(Long noteId) throws WhatTimeExceptions
    {
        notaRepository.deleteNote(noteId);
    }

    @Override
    public List<NotaDto> getAllNotes() {
        List<Nota> notaEntity=notaRepository.findAll();
        return notaEntity.stream().map(nota -> modelMapper.map(nota,NotaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<NotaDto> getNotaByNombreNotaContaining(String nombre_nota,Long usuarioID) throws WhatTimeExceptions {
        List<Nota> noteEntity= notaRepository.findNotaContainName(nombre_nota,usuarioID);
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<NotaDto> getNotasByImportancia(Integer importancia,Long usuarioID) throws WhatTimeExceptions
    {
        List<Nota> noteEntity= notaRepository.findTodasNotasImportancia(importancia,usuarioID);
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }

    /*@Override
    public List<NotaDto> getNotasFechasCreacion() throws WhatTimeExceptions
    {
        List<Nota> noteEntity= notaRepository.findNotasByFecha_creacion();
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }*/

    @Override
    public List<NotaDto> getNotasByFechaCreacion(Date fecha_Creacion) throws WhatTimeExceptions {
        List<Nota> noteEntity= notaRepository.findNotasFechaCreacion(fecha_Creacion);
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<NotaDto> getNotasByFechaBetween(Date fecha_Creacion,Date fecha_culminacion) throws WhatTimeExceptions {
        List<Nota> noteEntity= notaRepository.findNotasEntreFCYFCulmi(fecha_Creacion,fecha_culminacion);
        return noteEntity.stream().map(nota->modelMapper.map(nota, NotaDto.class)).collect(Collectors.toList());
    }



    public Nota getNotaEntity(Long notaId) throws WhatTimeExceptions
    {
        return notaRepository.findById(notaId).orElseThrow(() -> new NotFoundException("NotFound-4040", "Nota-NotFound-404"));
    }



}