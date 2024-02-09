package infraestructura.examen.model.entity;

import dominio.examen.model.Examen;
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
@Table(name = "pregunta")
public class PreguntaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long idPregunta;

    @Column
    private String titulo;

    @Column
    private String pregunta;

    @Column
    private String descripcion;

    @JoinColumn(name = "id_examen")
    @OneToOne(fetch = FetchType.LAZY)
    private ExamenEntity examen;

    @JoinColumn(name = "opcion_correcta")
    @OneToOne(fetch = FetchType.LAZY)
    private OpcionEntity opcionCorrecta;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private EstadoEntity idEstado;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
    private List<OpcionEntity> Opciones;

    public static Pregunta entityToDto(PreguntaEntity pregunta){

        return new Pregunta(pregunta.idPregunta,  pregunta.titulo, pregunta.pregunta,
                pregunta.descripcion, OpcionEntity.entityToDto(pregunta.getOpcionCorrecta()), EstadoEntity.entityToDto(pregunta.idEstado),
                OpcionEntity.entityListToDtoList(pregunta.getOpciones()));
    }

    public static PreguntaEntity dtoToEntity(Pregunta pregunta, Long examenId){

        ExamenEntity examenEntity = new ExamenEntity();
        examenEntity.setIdExamen(examenId);
        return new PreguntaEntity(pregunta.getId(), pregunta.getTitulo(), pregunta.getPregunta(),
                pregunta.getDescripcion(),
                //ExamenEntity.entityToDto(pregunta.getExamen())
                examenEntity,
                OpcionEntity.dtoToEntity(pregunta.getOpcionCorrecta(),pregunta.getId()), EstadoEntity.dtoToEntity(pregunta.getEstado()),
                null);
    }

    public static List<Pregunta> entityListToDtoList(List<PreguntaEntity> entityList){
        List<Pregunta> respuesta = new ArrayList<Pregunta>();
        if (entityList == null) {return respuesta;}
        for (PreguntaEntity pregunta : entityList) {
            respuesta.add(entityToDto(pregunta));
        }
        return respuesta;
    }

}
