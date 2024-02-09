package dominio.examen.ports.in.opcion;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Opcion;

public interface EditarOpcionUseCase {

    public boolean editar(Opcion e,Long preguntaId) throws FondYouException;

}
