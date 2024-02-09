package infraestructura.examen.adapter;

import dominio.examen.model.Opcion;
import dominio.examen.model.Pregunta;
import dominio.examen.ports.out.PreguntaRepositoryPort;
import dominio.exepcion.FondYouException;
import infraestructura.examen.model.entity.ExamenEntity;
import infraestructura.examen.model.entity.PreguntaEntity;
import infraestructura.examen.repository.ExamenRepository;
import infraestructura.examen.repository.PreguntaRepository;

public class PreguntaAdapter implements PreguntaRepositoryPort {

    private final PreguntaRepository preguntaRepository;
    private final ExamenRepository examenRepository;

    public PreguntaAdapter(PreguntaRepository preguntaRepository,ExamenRepository examenRepository){
        this.preguntaRepository=preguntaRepository;
        this.examenRepository=examenRepository;
    }

    @Override
    public boolean crear(Pregunta e, Long examenId) throws FondYouException {
        ExamenEntity examenEntity = examenRepository.findById(examenId).orElse(null);
        if(examenEntity == null){
            throw new FondYouException("No existe el examen referenciado");
        }
        PreguntaEntity preguntaEntity = PreguntaEntity.dtoToEntity(e,examenId);
        preguntaRepository.save(preguntaEntity);
        return true;

    }

    @Override
    public boolean editar(Pregunta e, Long examenId) throws FondYouException {
        ExamenEntity examenEntity = examenRepository.findById(examenId).orElse(null);
        if(examenEntity == null){
            throw new FondYouException("No existe el examen referenciado");
        }
        PreguntaEntity preguntaEntity = preguntaRepository.findById(e.getId()).orElse(null);
        if(examenEntity == null){
            throw new FondYouException("No existe la pregunta referenciada");
        }
        PreguntaEntity preguntaEntitysave = PreguntaEntity.dtoToEntity(e,examenId);
        preguntaRepository.save(preguntaEntitysave);
        return true;
    }
}
