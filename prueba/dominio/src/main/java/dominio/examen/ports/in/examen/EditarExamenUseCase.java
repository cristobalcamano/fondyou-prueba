package dominio.examen.ports.in.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;

public interface EditarExamenUseCase {

    public boolean editar(Examen e) throws FondYouException;

}
