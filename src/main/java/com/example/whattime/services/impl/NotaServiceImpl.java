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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        /*nota.setFecha_creacion(createNotaDto.getFecha_creacion());*/

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
    public NotaDto updateNota(NotaDto notaDto) throws WhatTimeExceptions {
        return null;
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

    /*@Override
    public NotaDto borrarNota(Long noteId) throws WhatTimeExceptions
    {
        notaRepository.deleteNote(noteId);
        return modelMapper.map(getNotaEntity(noteId),NotaDto.class);
    }*/




    public Nota getNotaEntity(Long notaId) throws WhatTimeExceptions {
        return notaRepository.findById(notaId).orElseThrow(() -> new NotFoundException("NotFound-4040", "Nota-NotFound-404"));
    }
}