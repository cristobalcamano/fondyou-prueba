package infraestructura.calificacion.repository;

import infraestructura.calificacion.model.entity.CalificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<CalificacionEntity, Long> {
}
