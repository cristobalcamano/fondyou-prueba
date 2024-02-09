package dominio.estudiante.ports.in;

import dominio.estudiante.model.Estudiante;
import dominio.exepcion.FondYouException;

import java.util.List;

public interface ConsultarTodosEstudianteUseCase {

    public List<Estudiante> consultarTodos() throws FondYouException;

}
