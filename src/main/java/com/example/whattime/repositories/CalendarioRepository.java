package com.example.whattime.repositories;

import com.example.whattime.entities.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long>
{
    Optional<Calendario> findById(Long id);
}
