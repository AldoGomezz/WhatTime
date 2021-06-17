package com.example.whattime.repositories;

import com.example.whattime.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long>
{
    Optional<Nota> findById(Long id);

    //@Query(nativeQuery = true,value="SELECT * FROM Nota ORDER BY Fecha_creacion DESC ")
    //List<Nota> findNotasByFecha_creacion() ;

    @Query("SELECT Note FROM Nota Note where Note.usuario.id=?1")
    List<Nota> findNotas(Long usuarioID);

    @Query("SELECT Note FROM Nota Note where Note.importancia=?1 and Note.usuario.id=?2")
    List<Nota> findTodasNotasImportancia(Integer importancia,Long usuarioID);

    @Query("SELECT Note FROM Nota Note where Note.fecha_creacion=?1")
    List<Nota> findNotasFechaCreacion(Date fecha_creacion);

    @Query("SELECT Note FROM Nota Note where Note.fecha_creacion between ?1 and ?2")
    List<Nota> findNotasEntreFCYFCulmi(Date fecha_creacion,Date fecha_culminacion);

    @Query("SELECT Note FROM Nota Note where Note.name_nota like %?1%  and Note.usuario.id=?2")
    List<Nota> findNotaContainName(String name_nota,Long usuarioID);


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
