package com.example.whattime.entities;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "calendarios",uniqueConstraints = {@UniqueConstraint(name = "calendario_name_unique",
        columnNames = "name_calendario")})

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Calendario {
    @Id
    @SequenceGenerator(name = "calendario_sequence", sequenceName = "calendario_sequence",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendario_sequence")

    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "name_calendario", nullable = false, columnDefinition = "TEXT")
    private String name_calendario;

    @OneToOne
    @JoinColumn(
            name = "usuario_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "usuario_calendario_fk"
            )
    )
    private Usuario usuario;
}
