package infraestructura.estudiante.repository;

import infraestructura.estudiante.model.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {

    @Query(value = "SELECT e.* FROM fondyouprueba.estudiante e inner join fondyouprueba.pregunta p " +
            "on e.id_estudiante = p.id_pregunta where p.id_pregunta = ?1 and e.id_estudiante = ?2",
            nativeQuery = true)
    public EstudianteEntity findByIdAndPregunta(Long pregunta, Long id_estudiante);

    @Query(value = "SELECT e.* FROM fondyouprueba.estudiante e inner join fondyouprueba.pregunta p " +
            "            on e.id_estudiante = p.id_pregunta inner join fondyouprueba.examen ex on p.id_examen = ex.id_examen " +
            "            inner join fondyouprueba.opcion op on op.id_pregunta = p.id_pregunta where (p.id_pregunta = ?1 " +
            "            and e.id_estudiante = ?2) and (p.id_estado = 1 and e.id_estado = 1 and ex.id_estado = 1 and op.id_estado = 1) limit 1 ",
            nativeQuery = true)
    public EstudianteEntity validateStatus(Long pregunta, Long id_estudiante);

}
