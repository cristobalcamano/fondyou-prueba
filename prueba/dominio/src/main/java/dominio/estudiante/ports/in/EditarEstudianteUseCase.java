package dominio.estudiante.ports.in;

import dominio.estudiante.model.Estudiante;
import dominio.exepcion.FondYouException;

public interface EditarEstudianteUseCase {

    public Boolean editar(Estudiante estudiante) throws FondYouException;

}
