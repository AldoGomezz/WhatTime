package com.example.whattime.services;

import com.example.whattime.DTO.AlarmaDto;
import com.example.whattime.DTO.CreateAlarmaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;

public interface AlarmaService {

    AlarmaDto createAlarma(CreateAlarmaDto createAlarmaDto, Long nombre) throws  WhatTimeExceptions;
    AlarmaDto updateAlarma(CreateAlarmaDto createAlarmaDto) throws  WhatTimeExceptions;

}
