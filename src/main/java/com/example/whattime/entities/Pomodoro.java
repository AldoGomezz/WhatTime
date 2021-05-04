package com.example.whattime.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="pomodoros",
        uniqueConstraints = {
                @UniqueConstraint(name="pomodoro_name_unique",columnNames="name_pomodoro")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pomodoro
{
    @Id
    @SequenceGenerator(name="pomodoro_sequence",sequenceName = "pomodoro_sequence",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pomodoro_sequence")

    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="name_pomodoro",nullable = false,columnDefinition = "TEXT")
    private String name_pomodoro;

    @Column(
            name = "duracion",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer duracion;

    /*@Column(
            name = "fecha_creacion",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime fecha_creacion;*/
    @ManyToOne
    @JoinColumn(
            name="pomodoro_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="pomodoro_note_fk"
            )
    )
    private Nota nota;
}
