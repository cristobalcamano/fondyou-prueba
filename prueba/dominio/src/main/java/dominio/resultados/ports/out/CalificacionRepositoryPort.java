package dominio.resultados.ports.out;

import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;

import java.util.List;

public interface CalificacionRepositoryPort {

    public Boolean calificar(Long idExamen) throws FondYouException;
    public Calificacion consultar(Long id) throws FondYouException;
    public List<Calificacion> consultarTodos();

}
