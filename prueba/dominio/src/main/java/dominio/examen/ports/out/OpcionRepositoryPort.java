package dominio.examen.ports.out;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Opcion;

public interface OpcionRepositoryPort {

    public boolean crear(Opcion e, Long preguntaId) throws FondYouException;
    public boolean editar(Opcion e, Long preguntaId) throws FondYouException;

}
