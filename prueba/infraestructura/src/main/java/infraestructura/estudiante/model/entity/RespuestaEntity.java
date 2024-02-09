package infraestructura.estudiante.model.entity;

import dominio.estudiante.model.Respuestas;
import dominio.exepcion.FondYouException;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respuestas")
public class RespuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_respuestas")
    private Long id;

    @Column(name = "id_estudiante")
    private Long estudiante;

    @Column(name = "id_pregunta")
    private Long pregunta;

    @Column(name = "respuesta")
    private Long respuesta;

    public static RespuestaEntity dtoToEntity(Respuestas respuesta) throws FondYouException {

        return new RespuestaEntity(respuesta.getId(), respuesta.getEstudiante(),
                respuesta.getPregunta(), respuesta.getRespuesta());
    }

}
