package infraestructura.estudiante.repository;

import infraestructura.estudiante.model.entity.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RespuestasRepository extends JpaRepository<RespuestaEntity, Long> {

    @Query(value = "SELECT count(*) FROM fondyouprueba.respuestas r " +
            " where r.id_estudiante = ?1 and r.id_pregunta = ?2 ",
            nativeQuery = true)
    public Integer findRespuestaByEstudiante(Long estudiante, Long pregunta);

}
