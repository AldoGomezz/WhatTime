package com.example.whattime.repositories;

import com.example.whattime.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long>
{
    Optional<Nota> findById(Long id);
    @Query("SELECT Note FROM Nota Note where Note.usuario.id=?1")
    List<Nota> findNotas(Long user_name);

    @Transactional
    @Modifying
    @Query("update Nota note set note.name_nota= ?1 where note.id= ?2")
    int setUpdateNoteName(String name_nota,Long noteid);

    @Transactional
    @Modifying
    @Query("update Nota note set note.contenido= ?1 where note.id= ?2")
    int updateDescriptionNota(String contenido,Long noteid);

    @Transactional
    @Modifying
    @Query("delete from Nota note where note.id = ?1")
    void deleteNote(Long note_id);

    /*@Transactional
    @Modifying
    @Query("delete from Nota note where note.id = ?1")
    Optional<Nota> borrarNote(Long note_id);*/

}
