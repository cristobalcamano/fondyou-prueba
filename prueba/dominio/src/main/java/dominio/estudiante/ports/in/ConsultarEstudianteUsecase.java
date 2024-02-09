package dominio.estudiante.ports.in;

import dominio.estudiante.model.Estudiante;
import dominio.exepcion.FondYouException;

public interface ConsultarEstudianteUsecase {

    public Estudiante consultar(Long id) throws FondYouException;

}
