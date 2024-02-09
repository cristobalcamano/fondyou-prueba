package infraestructura.estudiante.model.entity;

import dominio.estudiante.model.Estudiante;
import infraestructura.model.entity.EstadoEntity;
import infraestructura.model.entity.ZonaHorariaEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiante")
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @Column
    private String nombre;

    @Column
    private String identificacion;

    @ManyToOne
    @JoinColumn(name = "id_zona_horaria")
    private ZonaHorariaEntity idZonaHoraria;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEntity idEstado;


    public static Estudiante entityToDto(EstudianteEntity estudiante){
        return new Estudiante(estudiante.getId(), estudiante.getNombre(),
                estudiante.getIdentificacion(), ZonaHorariaEntity.entityToDto(estudiante.getIdZonaHoraria())
                ,EstadoEntity.entityToDto(estudiante.getIdEstado()));


    }

    public static EstudianteEntity dtoToEntity(Estudiante estudiante){

        return new EstudianteEntity(estudiante.getId(), estudiante.getNombre(), estudiante.getIdentificacion(),
                ZonaHorariaEntity.dtoToEntity(estudiante.getZonaHoraria())
                ,EstadoEntity.dtoToEntity(estudiante.getEstado()));
    }

    public static List<Estudiante> entityListToDtoList(List<EstudianteEntity> entityList){
        List<Estudiante> respuesta = new ArrayList<Estudiante>();
        for (EstudianteEntity estudiante : entityList) {
            respuesta.add(entityToDto(estudiante));
        }
        return respuesta;
    }

}
