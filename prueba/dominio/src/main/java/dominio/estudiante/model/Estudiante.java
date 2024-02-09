package dominio.estudiante.model;

import dominio.model.Estado;
import dominio.model.ZonaHoraria;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    private Long id;
    private String nombre;
    private String identificacion;
    private ZonaHoraria zonaHoraria;
    private Estado estado;

}
