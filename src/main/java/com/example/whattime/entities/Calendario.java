package com.example.whattime.entities;
import com.example.whattime.util.CalendarioStatus;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calendarios",uniqueConstraints = {@UniqueConstraint(name = "usuario_id_unique", columnNames = "usuario_id")})

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

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private CalendarioStatus status;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "usuario_id",nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey( name = "usuario_calendario_fk"))
    private Usuario usuario;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "nota_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "nota_calendario_fk"))
    private Nota nota;*/
    
}
