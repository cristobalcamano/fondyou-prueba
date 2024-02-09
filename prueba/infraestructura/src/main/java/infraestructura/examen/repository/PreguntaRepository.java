package infraestructura.examen.repository;

import infraestructura.examen.model.entity.PreguntaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<PreguntaEntity, Long> {
}
