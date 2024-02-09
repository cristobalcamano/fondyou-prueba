package infraestructura.estudiante.adapter;

import aplicacion.util.Utilidades;
import dominio.estudiante.model.Estudiante;
import dominio.estudiante.model.Respuestas;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import dominio.exepcion.FondYouException;
import infraestructura.estudiante.model.entity.EstudianteEntity;
import infraestructura.estudiante.model.entity.EstudianteExamenCEntity;
import infraestructura.estudiante.model.entity.RespuestaEntity;
import infraestructura.estudiante.repository.EstudianteExamenRepository;
import infraestructura.estudiante.repository.EstudianteRepository;
import infraestructura.estudiante.repository.RespuestasRepository;
import infraestructura.examen.model.entity.ExamenEntity;
import infraestructura.examen.repository.ExamenRepository;

import java.text.ParseException;
import java.util.List;

public class EstudianteAdapter implements EstudianteRepositoryPort {

    private final EstudianteRepository estudianteRepository;

    private final EstudianteExamenRepository estudianteExamenRepository;

    private final ExamenRepository examenRepository;

    private final RespuestasRepository respuestasRepository;

    public EstudianteAdapter(EstudianteRepository estudianteRepository,
                             EstudianteExamenRepository estudianteExamenRepository,
                             ExamenRepository examenRepository,
                             RespuestasRepository respuestasRepository){
        this.estudianteRepository=estudianteRepository;
        this.estudianteExamenRepository=estudianteExamenRepository;
        this.examenRepository= examenRepository;
        this.respuestasRepository=respuestasRepository;
    }

    @Override
    public Boolean crear(Estudiante e) throws FondYouException {

        estudianteRepository.save(EstudianteEntity.dtoToEntity(e));
        return true;
    }

    @Override
    public Boolean editar(Estudiante e) throws FondYouException {
        EstudianteEntity estudianteEntity = estudianteRepository.findById(e.getId()).orElse(null);
        if(estudianteEntity == null){
            throw new FondYouException("Estudiante no existe");
        }
        estudianteRepository.save(EstudianteEntity.dtoToEntity(e));
        return true;
    }

    @Override
    public Estudiante consultarPorID(Long id) throws FondYouException {
        EstudianteEntity estudianteEntity = estudianteRepository.findById(id).orElse(null);
        if(estudianteEntity == null){
            throw new FondYouException("Estudiante no existe");
        }
        return EstudianteEntity.entityToDto(estudianteEntity);
    }

    @Override
    public List<Estudiante> consultarTodos() throws FondYouException {
        return EstudianteEntity.entityListToDtoList(estudianteRepository.findAll());

    }

    @Override
    public Boolean asignarExamen(Long estudiante, Long examen) throws FondYouException {
        ExamenEntity examenEntit = examenRepository.findById(examen).orElse(null);
        if(examenEntit == null){
            throw new FondYouException("Examen no existe");
        }
        EstudianteEntity estudianteEntity = estudianteRepository.findById(estudiante).orElse(null);
        if(estudianteEntity == null){
            throw new FondYouException("Estudiante no existe");
        }

        EstudianteExamenCEntity estudianteExamenCEntity = new EstudianteExamenCEntity();
        estudianteExamenCEntity.setEstudiante(estudiante);
        estudianteExamenCEntity.setExamen(examen);

        String fechaValidada = null;
        try {
            fechaValidada = Utilidades.validarHorarioExamen(examenEntit.getFechaExamen(),
                    estudianteEntity.getIdZonaHoraria().getZonaHoraria());
        } catch (ParseException e) {
            throw new FondYouException("Error con la fecha del examen");
        }

        estudianteExamenCEntity.setHorarioZona(fechaValidada);
        estudianteExamenRepository.save(estudianteExamenCEntity);
        return true;
    }

    @Override
    public Boolean realizarExamen(Respuestas respuestas) throws FondYouException {

        EstudianteEntity estudianteEntity =
                estudianteRepository.findByIdAndPregunta(respuestas.getPregunta(), respuestas.getEstudiante());

        if(estudianteEntity == null){
            throw new FondYouException("Usuario no existe o la pregunta no esta asociada al " +
                    "estudiante por lo cual no es posible responderla");
        }
        EstudianteEntity estudianteEntityStatus =
                estudianteRepository.validateStatus(respuestas.getPregunta(), respuestas.getEstudiante());

        if(estudianteEntityStatus == null){
            throw new FondYouException("El estudiante, examen, pregunta o opcion a responder se encuentren " +
                    "inactivas(Estado 1) por lo cual no es posible responderla");
        }

        RespuestaEntity respuestaEntity = RespuestaEntity.dtoToEntity(respuestas);
        respuestasRepository.save(respuestaEntity);

        return true;
    }
}
