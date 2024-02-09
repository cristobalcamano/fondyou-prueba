package aplicacion.calificacion.servicio;

import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;
import dominio.resultados.ports.in.ConsultarCalificacionUseCase;
import dominio.resultados.ports.in.ConsultarTodosCalificacionUseCase;
import dominio.resultados.ports.in.CrearCalificacionUseCase;

import java.util.List;

public class ServicioTareaCalificacion implements CrearCalificacionUseCase, ConsultarTodosCalificacionUseCase,
        ConsultarCalificacionUseCase {

    private final CrearCalificacionUseCase crearCalificacionUseCase;
    private final ConsultarTodosCalificacionUseCase consultarTodosCalificacionUseCase;
    private final ConsultarCalificacionUseCase consultarCalificacionUseCase;

    public ServicioTareaCalificacion(CrearCalificacionUseCase crearCalificacionUseCase,
                                     ConsultarTodosCalificacionUseCase consultarTodosCalificacionUseCase,
                                     ConsultarCalificacionUseCase consultarCalificacionUseCase){
        this.crearCalificacionUseCase=crearCalificacionUseCase;
        this.consultarTodosCalificacionUseCase=consultarTodosCalificacionUseCase;
        this.consultarCalificacionUseCase = consultarCalificacionUseCase;
    }

    @Override
    public Calificacion consultar(Long id) throws FondYouException {
        return consultarCalificacionUseCase.consultar(id);
    }

    @Override
    public List<Calificacion> consultarTodos() {
        return consultarTodosCalificacionUseCase.consultarTodos();
    }

    @Override
    public Boolean calificar(Long idExamen) throws FondYouException {
        return crearCalificacionUseCase.calificar(idExamen);
    }
}
