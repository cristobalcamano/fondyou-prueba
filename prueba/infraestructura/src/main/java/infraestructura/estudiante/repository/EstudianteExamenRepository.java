package infraestructura.estudiante.repository;

import infraestructura.estudiante.model.entity.EstudianteExamenCEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EstudianteExamenRepository extends JpaRepository<EstudianteExamenCEntity, Long> {



}
