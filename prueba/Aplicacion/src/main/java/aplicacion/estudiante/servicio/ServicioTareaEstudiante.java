package aplicacion.estudiante.servicio;

import aplicacion.util.Utilidades;
import dominio.estudiante.ports.in.*;
import dominio.estudiante.model.Estudiante;
import dominio.estudiante.model.Respuestas;
import dominio.exepcion.FondYouException;

import java.util.List;

public class ServicioTareaEstudiante implements CrearEstudianteUseCase, EditarEstudianteUseCase, ConsultarTodosEstudianteUseCase,
        ConsultarEstudianteUsecase, RealizarExamenUseCase, AsignarExamenEstudianteUseCase {

    private final CrearEstudianteUseCase crearEstudianteUseCase;
    private final EditarEstudianteUseCase editarEstudianteUseCase;
    private final ConsultarTodosEstudianteUseCase consultarTodosEstudianteUseCase;
    private final ConsultarEstudianteUsecase consultarEstudianteUsecase;
    private final RealizarExamenUseCase realizarExamenUseCase;

    private final AsignarExamenEstudianteUseCase asignarExamenEstudianteUseCase;

    public ServicioTareaEstudiante(CrearEstudianteUseCase crearEstudianteUseCase,
    EditarEstudianteUseCase editarEstudianteUseCase,
    ConsultarTodosEstudianteUseCase consultarTodosEstudianteUseCase,
    ConsultarEstudianteUsecase consultarEstudianteUsecase,
    RealizarExamenUseCase realizarExamenUseCase,
    AsignarExamenEstudianteUseCase asignarExamenEstudianteUseCase){
        this.crearEstudianteUseCase= crearEstudianteUseCase;
        this.editarEstudianteUseCase=editarEstudianteUseCase;
        this.consultarTodosEstudianteUseCase=consultarTodosEstudianteUseCase;
        this.consultarEstudianteUsecase=consultarEstudianteUsecase;
        this.realizarExamenUseCase=realizarExamenUseCase;
        this.asignarExamenEstudianteUseCase=asignarExamenEstudianteUseCase;
    }

    @Override
    public Estudiante consultar(Long id) throws FondYouException {
        return consultarEstudianteUsecase.consultar(id);
    }

    @Override
    public List<Estudiante> consultarTodos() throws FondYouException {
        return consultarTodosEstudianteUseCase.consultarTodos();
    }

    @Override
    public Boolean crear(Estudiante estudiante) throws FondYouException {
        if(Utilidades.vacio(estudiante.getNombre()) ||
                Utilidades.vacio(Utilidades.vacio(estudiante.getEstado() != null ? estudiante.getEstado().getId() : 0L))
                || Utilidades.vacio(estudiante.getIdentificacion())
                || Utilidades.vacio(estudiante.getZonaHoraria() != null ? estudiante.getZonaHoraria().getId() : 0L)){
            throw new FondYouException("Los valores Nombre, identificacion, ZonaHoraria y Estado " +
                    "son obligatorios");
        }
        return crearEstudianteUseCase.crear(estudiante);
    }

    @Override
    public Boolean editar(Estudiante estudiante) throws FondYouException {
        if(Utilidades.vacio(estudiante.getNombre()) ||
                Utilidades.vacio(estudiante.getId()) ||
                Utilidades.vacio(Utilidades.vacio(estudiante.getEstado() != null ? estudiante.getEstado().getId() : 0L))
                || Utilidades.vacio(estudiante.getIdentificacion())
            || Utilidades.vacio(estudiante.getZonaHoraria() != null ? estudiante.getZonaHoraria().getId() : 0L)){
            throw new FondYouException("Los valores id, Nombre, identificacion, ZonaHoraria y Estado " +
                    "son obligatorios");
        }
        return editarEstudianteUseCase.editar(estudiante);
    }

    @Override
    public Boolean realizarExamen(Respuestas respuestas) throws FondYouException {
        if(Utilidades.vacio(respuestas.getRespuesta()) || Utilidades.vacio(respuestas.getEstudiante())
                || Utilidades.vacio(respuestas.getPregunta())){
            throw new FondYouException("Los valores pregunta, estudiante, y respuesta " +
                    "son obligatorios");
        }
        return realizarExamenUseCase.realizarExamen(respuestas);
    }

    @Override
    public Boolean AsignarExamen(Long estudiante, Long Examen) throws FondYouException {
        return asignarExamenEstudianteUseCase.AsignarExamen(estudiante, Examen);
    }
}
