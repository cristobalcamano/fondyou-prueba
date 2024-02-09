package aplicacion.examen.casodeuso.opcion;

import dominio.examen.model.Opcion;
import dominio.examen.ports.in.opcion.CrearOpcionUseCase;
import dominio.examen.ports.out.OpcionRepositoryPort;
import dominio.exepcion.FondYouException;

public class CrearOpcionUseCaseImpl implements CrearOpcionUseCase {

    private final OpcionRepositoryPort opcionRepositoryPort;

    public CrearOpcionUseCaseImpl(OpcionRepositoryPort opcionRepositoryPort){
        this.opcionRepositoryPort=opcionRepositoryPort;
    }

    @Override
    public boolean crear(Opcion e, Long preguntaId) throws FondYouException {
        return opcionRepositoryPort.crear(e,preguntaId);
    }
}
