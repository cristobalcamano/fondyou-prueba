package dominio.examen.ports.in.opcion;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Opcion;

public interface CrearOpcionUseCase {

    public boolean crear(Opcion e,Long preguntaId) throws FondYouException;

}
