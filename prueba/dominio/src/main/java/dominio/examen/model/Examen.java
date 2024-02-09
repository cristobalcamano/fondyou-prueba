package dominio.examen.model;

import dominio.model.Estado;
import dominio.model.ZonaHoraria;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Examen {

    private Long id;
    private String nombre;
    private String descripcion;
    private String fechaExamen;
    private ZonaHoraria zonaHoraria;
    private Estado estado;
    private List<Pregunta> listaPreguntas;

}
