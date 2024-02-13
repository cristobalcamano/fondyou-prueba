package infraestructura.estudiante.repository;

import infraestructura.estudiante.model.entity.EstudianteExamenCEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EstudianteExamenRepository extends JpaRepository<EstudianteExamenCEntity, Long> {

    @Query(value = "SELECT count(*) FROM fondyouprueba.estudiante_examen ee " +
            "where ee.id_estudiante = ?1 and ee.id_examen = ?2",
            nativeQuery = true)
    public Integer findExamenEstudianteByEstudianteAndExamen(Long estudiante, Long examen);


}
