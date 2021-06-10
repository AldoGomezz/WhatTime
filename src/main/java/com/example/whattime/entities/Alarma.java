package com.example.whattime.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="alarmas",
        uniqueConstraints = {
                @UniqueConstraint(name="alarma_name_unique",columnNames="name_alarma")
        })
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Alarma {
    @Id
    @SequenceGenerator(name = "alarma_sequence", sequenceName = "alarma_sequence",
            allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alarma_sequence")

    @Column(name="id", updatable = false)
    private long id;

    @Column(name ="name_alarma", nullable = false, columnDefinition = "TEXT")
    private String name_alarma;

    @Column(name ="contenido_alarma", nullable = false, columnDefinition = "TEXT")
    private String contenido_alarma;

    @OneToOne
    @JoinColumn(
            name = "calendario_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "calendario_alarma_fk"
            )
    )

    private Calendario calendario;
}
