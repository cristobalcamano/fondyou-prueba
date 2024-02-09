package dominio.estudiante.ports.in;

import dominio.estudiante.model.Respuestas;
import dominio.exepcion.FondYouException;

public interface RealizarExamenUseCase {

    public Boolean realizarExamen(Respuestas respuestas) throws FondYouException;

}
