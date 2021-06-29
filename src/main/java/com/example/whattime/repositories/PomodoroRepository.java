package com.example.whattime.repositories;

import com.example.whattime.entities.Pomodoro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface PomodoroRepository extends JpaRepository<Pomodoro,Long>
{
    @Transactional
    @Modifying
    @Query("update Pomodoro pomo set pomo.duracion=?1 where pomo.id= ?2")
    int setUpdatePomodoroDuracion(Number duracion,Long id_pomodoro);

    @Override
    Optional<Pomodoro> findById(Long aLong);

}
