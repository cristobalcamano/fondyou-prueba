package dominio.estudiante.ports.in;

import dominio.estudiante.model.Estudiante;
import dominio.exepcion.FondYouException;

public interface CrearEstudianteUseCase {

    public Boolean crear(Estudiante estudiante) throws FondYouException;

}
