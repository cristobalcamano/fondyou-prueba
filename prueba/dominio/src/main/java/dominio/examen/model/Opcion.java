package dominio.examen.model;

import dominio.model.Estado;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Opcion {

    private Long id;
    private String opcion;
    private Estado estado;

}
