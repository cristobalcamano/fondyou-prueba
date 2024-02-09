package infraestructura.examen.repository;

import infraestructura.examen.model.entity.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long> {

}
