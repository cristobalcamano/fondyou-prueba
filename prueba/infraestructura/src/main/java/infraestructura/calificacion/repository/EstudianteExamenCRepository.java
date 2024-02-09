package infraestructura.calificacion.repository;

import infraestructura.calificacion.model.entity.EstudianteExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EstudianteExamenCRepository extends JpaRepository<EstudianteExamenEntity, Long> {


    @Query(value = "SELECT e.* FROM fondyouprueba.estudiante_examen e where e.id_examen = ?1",
            nativeQuery = true)
    List<EstudianteExamenEntity> findAllEstudiantesByExamen(Long examen);

    @Query(value = "SELECT count(*) FROM fondyouprueba.pregunta p where p.id_examen = ?1",
            nativeQuery = true)
    Integer findAllPreguntasByExamen(Long examen);

    @Query(value = "SELECT count(*) FROM fondyouprueba.respuestas r " +
            "inner join  fondyouprueba.pregunta p " +
            "on p.id_pregunta = r.id_pregunta " +
            "where p.id_examen = ?1 and r.respuesta = p.opcion_correcta and r.id_estudiante = ?2",
            nativeQuery = true)
    Integer findAllrespuestasByEsrudiante(Long examen, Long estudiante);

}
