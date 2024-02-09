package aplicacion.calificacion.casodeuso;

import dominio.resultados.model.Calificacion;
import dominio.resultados.ports.in.ConsultarTodosCalificacionUseCase;
import dominio.resultados.ports.out.CalificacionRepositoryPort;

import java.util.List;

public class ConsultarTodosCalificacionUseCaseImpl  implements ConsultarTodosCalificacionUseCase {

    private final CalificacionRepositoryPort calificacionRepositoryPort;

    public ConsultarTodosCalificacionUseCaseImpl(CalificacionRepositoryPort calificacionRepositoryPort){
        this.calificacionRepositoryPort  = calificacionRepositoryPort;
    }

    @Override
    public List<Calificacion> consultarTodos() {
        return calificacionRepositoryPort.consultarTodos();
    }
}
