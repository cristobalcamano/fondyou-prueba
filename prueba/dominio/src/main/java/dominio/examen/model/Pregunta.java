package dominio.examen.model;

import dominio.model.Estado;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {

    private Long id;
    private String titulo;
    private String pregunta;
    private String descripcion;
    private Opcion opcionCorrecta;
    private Estado estado;
    private List<Opcion> listaOpciones;

}
