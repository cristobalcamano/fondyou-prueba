package dominio.examen.ports.in.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;

public interface ConsultarExamenUseCase {

    public Examen consultar(Long id) throws FondYouException;

}
