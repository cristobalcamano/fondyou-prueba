package dominio.examen.ports.in.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;

public interface CrearExamenUseCase {

    public boolean crear(Examen e) throws FondYouException;

}
