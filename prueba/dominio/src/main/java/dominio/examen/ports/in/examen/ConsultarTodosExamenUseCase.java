package dominio.examen.ports.in.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;

import java.util.List;

public interface ConsultarTodosExamenUseCase {

    public List<Examen> consultarTodos() throws FondYouException;

}
