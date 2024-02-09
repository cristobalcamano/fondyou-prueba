package dominio.estudiante.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Respuestas {

    private Long id;
    private Long estudiante;
    private Long pregunta;
    private Long respuesta;

}
