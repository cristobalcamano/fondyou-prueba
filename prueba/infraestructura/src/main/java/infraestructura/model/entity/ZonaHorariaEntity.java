package infraestructura.model.entity;

import dominio.model.ZonaHoraria;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zona_horaria")
public class ZonaHorariaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona_horaria")
    private Long idZonaHoraria;

    @Column(name = "zona_horaria")
    private String zonaHoraria;

    public static ZonaHoraria entityToDto(ZonaHorariaEntity zonaHorariaEntity){
        return new ZonaHoraria(zonaHorariaEntity.getIdZonaHoraria(),zonaHorariaEntity.getZonaHoraria());
    }

    public static ZonaHorariaEntity dtoToEntity(ZonaHoraria zonaHoraria){
        return new ZonaHorariaEntity(zonaHoraria.getId(), zonaHoraria.getZonaHoraria());
    }

}
