package dominio.resultados.ports.in;

import dominio.resultados.model.Calificacion;

import java.util.List;

public interface ConsultarTodosCalificacionUseCase {

    public List<Calificacion> consultarTodos();

}
