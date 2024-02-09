package infraestructura.model.entity;

import dominio.examen.model.Examen;
import dominio.model.Estado;
import infraestructura.examen.model.entity.ExamenEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estado")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre")
    private String nombre;

    public static Estado entityToDto(EstadoEntity estadoE){
        if(estadoE == null){
            return null;
        }
        return new Estado(estadoE.getIdEstado(), estadoE.getNombre());
    }

    public static EstadoEntity dtoToEntity(Estado estado){
        if(estado == null){
            return null;
        }
        return new EstadoEntity(estado.getId(), estado.getNombre());
    }

}
