package infraestructura.examen.model.entity;

import aplicacion.util.Utilidades;
import dominio.examen.model.Examen;
import dominio.exepcion.FondYouException;
import infraestructura.model.entity.EstadoEntity;
import infraestructura.model.entity.ZonaHorariaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "examen")
public class ExamenEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen")
    private Long idExamen;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column(name = "fecha_examen")
    private String fechaExamen;

    @ManyToOne
    @JoinColumn(name = "id_zona_horaria")
    private ZonaHorariaEntity idZonaHoraria;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEntity idEstado;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
    private List<PreguntaEntity> preguntas;

    public static Examen entityToDto(ExamenEntity examen) throws FondYouException{

        try {
            Utilidades.stringtoDate(examen.getFechaExamen());
        }catch (Exception exception){
            throw new FondYouException("Ocurrio un error en la fecha con el formato - " +
                    "yyyy-MM-dd HH:mm:ss");
        }
        return new Examen(examen.idExamen, examen.nombre, examen.descripcion,
                examen.getFechaExamen(), ZonaHorariaEntity.entityToDto(examen.idZonaHoraria),
                EstadoEntity.entityToDto(examen.idEstado),
                PreguntaEntity.entityListToDtoList(examen.getPreguntas()));


    }

    public static ExamenEntity dtoToEntity(Examen examen) throws FondYouException{

        try {
            Utilidades.stringtoDate(examen.getFechaExamen());
        }catch (Exception exception){
            throw new FondYouException("Asegurese por favor que el formato de la fecha sea correcto - " +
                    "yyyy-MM-dd HH:mm:ss");
        }
        return new ExamenEntity(examen.getId(), examen.getNombre(), examen.getDescripcion(),
                examen.getFechaExamen(),
                ZonaHorariaEntity.dtoToEntity(examen.getZonaHoraria())
                ,EstadoEntity.dtoToEntity(examen.getEstado()), null
        );
    }

    public static List<Examen> entityListToDtoList(List<ExamenEntity> entityList) throws FondYouException{
        List<Examen> respuesta = new ArrayList<Examen>();
        for (ExamenEntity examen : entityList) {
            respuesta.add(entityToDto(examen));
        }
        return respuesta;
    }

}
