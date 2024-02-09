package infraestructura.estudiante.repository;

import infraestructura.estudiante.model.entity.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestasRepository extends JpaRepository<RespuestaEntity, Long> {
}
