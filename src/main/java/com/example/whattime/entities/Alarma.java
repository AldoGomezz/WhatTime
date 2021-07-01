package com.example.whattime.entities;

import com.example.whattime.util.AlarmaStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "fecha_alarma", nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_alarma;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.STRING)
    private AlarmaStatus status;

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
