package infraestructura.calificacion.model.entity;

import dominio.estudiante.model.Respuestas;
import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;
import infraestructura.estudiante.model.entity.RespuestaEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calificacion")
public class CalificacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion")
    private Long idCalificacion;

    @Column(name = "calificacion_final")
    private String calificacionFinal;

    @Column(name = "id_estudiante_examen")
    private Long idEstudianteExamen;

    public static CalificacionEntity dtoToEntity(String calificaionFinal, Long idEstudianteExamen)
            throws FondYouException {

        return new CalificacionEntity(null,calificaionFinal, idEstudianteExamen);
    }

    public static Calificacion entityToDto(CalificacionEntity calificacionEntity, Long estudiante, Long examen)
            throws FondYouException {

        return new Calificacion(calificacionEntity.idCalificacion, calificacionEntity.calificacionFinal,
                estudiante,examen);
    }

}
