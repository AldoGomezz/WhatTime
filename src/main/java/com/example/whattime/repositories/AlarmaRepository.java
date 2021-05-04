package com.example.whattime.repositories;

import com.example.whattime.entities.Alarma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmaRepository extends JpaRepository<Alarma,Long> {
}
