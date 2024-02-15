package infraestructura.examen.model.entity;

import dominio.examen.model.Examen;
import dominio.examen.model.Opcion;
import dominio.examen.model.Pregunta;
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
@Table(name = "opcion")
public class OpcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcion")
    private Long idOpcion;

    @Column(name = "opcion")
    private String opcion;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEntity estado;

    @ManyToOne
    @JoinColumn(name = "id_pregunta")
    private PreguntaEntity pregunta;


    public static Opcion entityToDto(OpcionEntity opcion){
        if(opcion == null){
            return null;
        }
        return new Opcion(opcion.idOpcion, opcion.opcion,
                EstadoEntity.entityToDto(opcion.estado));
    }

    public static OpcionEntity dtoToEntity(Opcion opcion, Long preguntaId){

        PreguntaEntity pregunta = new PreguntaEntity();
        pregunta.setIdPregunta(preguntaId);
        if(opcion == null){
            return null;
        }
        OpcionEntity opcionEntity = new OpcionEntity();
        opcionEntity.setIdOpcion(opcion.getId());
        opcionEntity.setOpcion(opcion.getOpcion());
        opcionEntity.setEstado(EstadoEntity.dtoToEntity(opcion.getEstado()));
        opcionEntity.setPregunta(pregunta);
        return opcionEntity;
    }

    public static List<Opcion> entityListToDtoList(List<OpcionEntity> entityList){
        List<Opcion> respuesta = new ArrayList<Opcion>();
        if(entityList == null){
            return respuesta;
        }
        for (OpcionEntity opcion : entityList) {
            respuesta.add(entityToDto(opcion));
        }
        return respuesta;
    }

}
