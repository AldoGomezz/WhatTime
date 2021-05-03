package com.example.whattime.repositories;

import com.example.whattime.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota,Long>
{


}