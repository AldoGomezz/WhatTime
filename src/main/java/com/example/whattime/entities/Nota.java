package com.example.whattime.entities;

import com.example.whattime.util.NotaStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="notas",
        uniqueConstraints = {
                @UniqueConstraint(name="nota_name_unique",columnNames="name_nota")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nota
{
    @Id
    @SequenceGenerator(name="nota_sequence",sequenceName = "nota_sequence",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "nota_sequence")

    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="name_nota",nullable = false,columnDefinition = "TEXT")
    private String name_nota;

    @Column(name = "importancia", nullable = false, columnDefinition = "INTEGER")
    private Integer importancia;

    @Column(name = "contenido", nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private NotaStatus status;

    @Column(name = "fecha_creacion", nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_creacion;

    @Column(name = "fecha_culminacion", nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_culminacion;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="usuario_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name="usuario_note_fk"))
    private Usuario usuario;
}