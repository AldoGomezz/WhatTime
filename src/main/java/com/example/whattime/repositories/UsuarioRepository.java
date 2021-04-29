/*package com.example.whattime.repositories;

import com.example.whattime.entities.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Solo metodo que hagan un insert select, drop to do contra la base de datos
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findByNombre(String nombre);
    List<Usuario> findAllByNombre(Iterable<String> iterable);
}*/
