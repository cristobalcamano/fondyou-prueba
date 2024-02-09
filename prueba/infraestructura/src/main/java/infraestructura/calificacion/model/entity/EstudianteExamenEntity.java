package infraestructura.calificacion.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante_examen")
public class EstudianteExamenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante_examen")
    private Long id;

    @Column(name = "id_estudiante")
    private Long estudiante;

    @Column(name = "id_examen")
    private Long examen;

    @Column(name = "horario_zona")
    private String horarioZona;

}
