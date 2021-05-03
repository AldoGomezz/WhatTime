package com.example.whattime.repositories;


import com.example.whattime.entities.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//Solo metodo que hagan un insert select, drop to do contra la base de datos
//Consultas cuando utilizas un atributo de la entidad
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario>  findByNombreEqualsAndContrasenaEquals(String nombre, String contrasena);

    @Query("SELECT User FROM Usuario User")
    List<Usuario> findUsuarios();

    //@Query("SELECT Usuario.id from Usuario where Usuario.nombre=?1 ")
    //Optional<Usuario> returnID(String nombre);

    @Transactional
    @Modifying
    @Query("update Usuario user set user.contrasena= ?1 where user.id= ?2")
    int setUpdateUser(String contrasena,Long userId);

    @Transactional
    @Modifying
    @Query("update Usuario user set user.correo= ?1 where user.id= ?2")
    int setUpdateUserCorreo(String correo,Long userId);


}