package com.example.whattime.repositories;

import com.example.whattime.entities.Alarma;
import com.example.whattime.util.AlarmaStatus;
import com.example.whattime.util.NotaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlarmaRepository extends JpaRepository<Alarma,Long> {
    Optional<Alarma> findById(Long id);

    @Override
    boolean existsById(Long idAlarma);

    @Query("SELECT Alarm FROM Alarma Alarm where Alarm.calendario.id=?1")
    List<Alarma>findAlarm(Long calendarioID);

    @Query("SELECT Alarm FROM Alarma Alarm where Alarm.fecha_alarma=?1")
    List<Alarma>findFechaAlarma(Date fecha_alarma);

    @Transactional
    @Modifying
    @Query("update Alarma alarm set alarm.name_alarma= ?1 where alarm.id= ?2")
    int setUpdateNameAlarm(String name_alarm,Long alarmid);

    @Transactional
    @Modifying
    @Query("update Alarma alarm set alarm.contenido_alarma= ?1 where alarm.id= ?2")
    int setUpdateDescriptionAlarm(String contenido_alarma,Long alarmid);

    @Transactional
    @Modifying
    @Query("update Alarma alarm set alarm.status= ?1 where alarm.id= ?2")
    int setUpdateStatusAlarm(AlarmaStatus status, Long alarm_id);

    @Transactional
    @Modifying
    @Query("delete from Alarma alarm where alarm.id = ?1")
    void deleteAlarm(Long alarm_id);
}
