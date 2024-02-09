package dominio.resultados.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {

    private Long id;
    private String calificacionFinal;
    private Long estudiante;
    private Long examen;

}
