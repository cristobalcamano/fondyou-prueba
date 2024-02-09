package infraestructura.examen.adapter;

import dominio.examen.model.Opcion;
import dominio.examen.ports.out.OpcionRepositoryPort;
import dominio.exepcion.FondYouException;
import infraestructura.examen.model.entity.OpcionEntity;
import infraestructura.examen.model.entity.PreguntaEntity;
import infraestructura.examen.repository.OpcionRepository;
import infraestructura.examen.repository.PreguntaRepository;

public class OpcionAdapter implements OpcionRepositoryPort {

    private final OpcionRepository opcionRepository;
    private final PreguntaRepository preguntaRepository;

    public OpcionAdapter(OpcionRepository opcionRepository,
                         PreguntaRepository preguntaRepository){
        this.opcionRepository=opcionRepository;
        this.preguntaRepository=preguntaRepository;
    }

    @Override
    public boolean crear(Opcion o, Long preguntaId) throws FondYouException {
        PreguntaEntity preguntaEntity = preguntaRepository.findById(preguntaId).orElse(null);
        if(preguntaEntity == null){
            throw new FondYouException("Pregunta no existe");
        }
        OpcionEntity opcionEntity = OpcionEntity.dtoToEntity(o,preguntaId);
        opcionEntity.setPregunta(preguntaEntity);
        opcionRepository.save(opcionEntity);
        return true;
    }

    @Override
    public boolean editar(Opcion o, Long preguntaId) throws FondYouException {
        PreguntaEntity preguntaEntity = preguntaRepository.findById(preguntaId).orElse(null);
        if(preguntaEntity == null){
            throw new FondYouException("Pregunta no existe");
        }
        OpcionEntity opcionEntity = opcionRepository.findById(o.getId()).orElse(null);
        if(opcionEntity == null){
            throw new FondYouException("Opcion no existe");
        }

        opcionRepository.save(OpcionEntity.dtoToEntity(o,preguntaId));
        return true;
    }
}
