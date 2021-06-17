package com.example.whattime.repositories;

import com.example.whattime.entities.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long>
{
    Optional<Calendario> findById(Long id);
<<<<<<< HEAD
    //@Query("select  Calendar FROM  Calendario  calendar where  calendar.usuario.")
=======
    /*@Query("SELECT Calendar from Calendario Calendar where Calendar.usuario.notes")/*
     */

    
>>>>>>> 7be38cd6b3cc969c3cf106695215ab6cb4d7c352
}
