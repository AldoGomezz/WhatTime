package com.example.whattime.services;

import com.example.whattime.DTO.AlarmaDto;
import com.example.whattime.DTO.CreateAlarmaDto;
import com.example.whattime.exceptions.WhatTimeExceptions;
import com.example.whattime.util.AlarmaStatus;


import java.util.Date;
import java.util.List;

public interface AlarmaService {
    AlarmaDto createAlarm(CreateAlarmaDto createAlarmaDto, Long name_alarma) throws  WhatTimeExceptions;
    AlarmaDto findIDAlarm(Long id) throws  WhatTimeExceptions;
    int setUpdateNameAlarm(String name_alarma, Long alarm_id) throws  WhatTimeExceptions;
    int setUpdateDescriptionAlarm(String contenido_alarma,Long alarm_id) throws  WhatTimeExceptions;
    int setUpdateStatusAlarm(AlarmaStatus status, Long alarm_Id) throws WhatTimeExceptions;
    List<AlarmaDto> getAlarmCalendary(Long calendario_id) throws  WhatTimeExceptions;
    void DeleteAlarm(Long alarmId) throws WhatTimeExceptions;
    List<AlarmaDto> getAllAlarms();

    List<AlarmaDto> getAlarmaByFechaAlarma(Date fecha_alarma) throws  WhatTimeExceptions;
}
