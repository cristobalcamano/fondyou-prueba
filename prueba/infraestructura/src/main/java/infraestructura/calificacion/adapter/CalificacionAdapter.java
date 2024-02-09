package infraestructura.calificacion.adapter;

import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;
import dominio.resultados.ports.out.CalificacionRepositoryPort;
import infraestructura.calificacion.model.entity.CalificacionEntity;
import infraestructura.calificacion.model.entity.EstudianteExamenEntity;
import infraestructura.calificacion.repository.CalificacionRepository;
import infraestructura.calificacion.repository.EstudianteExamenCRepository;

import java.util.ArrayList;
import java.util.List;

public class CalificacionAdapter implements CalificacionRepositoryPort {

    private final CalificacionRepository calificacionRepository;
    private final EstudianteExamenCRepository estudianteExamenCRepository;

    public CalificacionAdapter(CalificacionRepository calificacionRepository,
                               EstudianteExamenCRepository estudianteExamenCRepository){
        this.calificacionRepository=calificacionRepository;
        this.estudianteExamenCRepository = estudianteExamenCRepository;
    }

    @Override
    public Boolean calificar(Long idExamen) throws FondYouException {

        String calificacionFinal = "De {preguntas} preguntas acerto {aciertos} por lo cual " +
                "la nota sobre 100 es de {total}";

        List<EstudianteExamenEntity> estudianteExamenLista =
                estudianteExamenCRepository.findAllEstudiantesByExamen(idExamen);

        Integer preguntas = estudianteExamenCRepository.findAllPreguntasByExamen(idExamen);

        for (EstudianteExamenEntity estudianteExamenEntity: estudianteExamenLista) {
            Integer respuestas = estudianteExamenCRepository.
                    findAllrespuestasByEsrudiante(idExamen, estudianteExamenEntity.getEstudiante());
            CalificacionEntity calificacionEntity = new CalificacionEntity();
            calificacionEntity.setIdEstudianteExamen(estudianteExamenEntity.getId());

            Double porcentaje = (respuestas.doubleValue() / preguntas) * 100;

            calificacionEntity.setCalificacionFinal(calificacionFinal
                    .replace("{preguntas}",preguntas.toString())
                    .replace("{aciertos}",respuestas.toString())
                    .replace("{total}",porcentaje.toString()));

            calificacionRepository.save(calificacionEntity);

        }

        return true;
    }

    @Override
    public Calificacion consultar(Long id) throws FondYouException {
        CalificacionEntity calificacionEntity= calificacionRepository.findById(id).orElse(null);
        EstudianteExamenEntity estudianteExamenEntity=
                estudianteExamenCRepository.findById(calificacionEntity.getIdEstudianteExamen()).orElse(null);

        if(calificacionEntity == null){
           throw new FondYouException("No existe este registro");
        }

        Calificacion calificacion = new Calificacion(calificacionEntity.getIdCalificacion(),calificacionEntity.getCalificacionFinal(),
                estudianteExamenEntity.getEstudiante(), estudianteExamenEntity.getExamen());
        return calificacion;
    }

    @Override
    public List<Calificacion> consultarTodos() {

        List<Calificacion> calificacionList = new ArrayList();
        List<CalificacionEntity> calificacionEntityList= calificacionRepository.findAll();
        for (CalificacionEntity calificacionEntity:calificacionEntityList) {


            EstudianteExamenEntity estudianteExamenEntity =
                    estudianteExamenCRepository.findById(calificacionEntity.getIdEstudianteExamen()).orElse(null);

            Calificacion calificacion = new Calificacion(calificacionEntity.getIdCalificacion(), calificacionEntity.getCalificacionFinal(),
                    estudianteExamenEntity.getEstudiante(), estudianteExamenEntity.getExamen());

            calificacionList.add(calificacion);
        }
        return calificacionList;
    }
}
