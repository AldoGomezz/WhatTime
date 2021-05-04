package com.example.whattime.repositories;

import com.example.whattime.entities.Alarma;
import com.example.whattime.entities.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlarmaRepository extends JpaRepository<Alarma,Long> {
    Optional<Alarma> findById(Long id);
}
