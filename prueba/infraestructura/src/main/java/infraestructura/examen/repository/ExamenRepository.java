package infraestructura.examen.repository;

import infraestructura.examen.model.entity.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long> {

    @Query(value = "SELECT count(*) FROM fondyouprueba.pregunta p " +
            "inner join fondyouprueba.opcion o " +
            "on p.id_pregunta = o.id_pregunta " +
            "where p.id_pregunta = ?1 and o.id_opcion = ?2 ",
            nativeQuery = true)
    public Integer findExamenEstudianteByEstudianteAndExamen(Long pregunta, Long opcion);

}
