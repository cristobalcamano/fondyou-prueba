package infraestructura.examen.adapter;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;
import dominio.examen.ports.out.ExamenRepositoryPort;
import infraestructura.examen.model.entity.ExamenEntity;
import infraestructura.examen.repository.ExamenRepository;

import java.util.List;

public class ExamenAdapter implements ExamenRepositoryPort {

    private final ExamenRepository examenRepository;

    public ExamenAdapter(ExamenRepository examenRepository){
        this.examenRepository = examenRepository;
    }

    @Override
    public boolean crear(Examen e) throws FondYouException {
        ExamenEntity examenEntity = ExamenEntity.dtoToEntity(e);

            examenRepository.save(examenEntity);
            return true;
    }

    @Override
    public boolean editar(Examen e) throws FondYouException {
        ExamenEntity examenEntity = examenRepository.findById(e.getId()).orElse(null);
        if(examenEntity == null){
            throw new FondYouException("Examen no existe");
        }
        examenRepository.save(ExamenEntity.dtoToEntity(e));
        return true;
    }

    @Override
    public Examen consultarPorID(Long id) throws FondYouException {
        ExamenEntity examenEntity = examenRepository.findById(id).orElse(null);
        if(examenEntity == null){
            throw new FondYouException("Examen no existe");
        }

        return ExamenEntity.entityToDto(examenEntity);

    }

    @Override
    public List<Examen> consultarTodos() throws FondYouException {

        return ExamenEntity.entityListToDtoList(examenRepository.findAll());

    }

}
