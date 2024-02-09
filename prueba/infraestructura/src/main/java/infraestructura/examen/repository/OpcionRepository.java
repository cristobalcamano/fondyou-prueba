package infraestructura.examen.repository;

import infraestructura.examen.model.entity.OpcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcionRepository extends JpaRepository<OpcionEntity, Long> {
}
