package com.example.whattime.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "calendario",
       uniqueConstraints = {
        @UniqueConstraint(name = "calendario_name_unique0", columnNames = "name")
       })
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Calendario {
    @Id
    @SequenceGenerator(name = "calendario-sequence",
            sequenceName = "calendario-sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "calendario-sequence")

    @Column(name="id", updatable = false)
    private Long id;

    @OneToOne
    @JoinColumn(
            name = "usuario-id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "usuario_calendar_fk"
            )
    )
    private Calendario calendario;
}
