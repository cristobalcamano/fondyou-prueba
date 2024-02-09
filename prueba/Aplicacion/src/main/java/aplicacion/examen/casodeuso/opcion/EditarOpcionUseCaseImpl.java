package aplicacion.examen.casodeuso.opcion;

import dominio.examen.model.Opcion;
import dominio.examen.ports.in.opcion.EditarOpcionUseCase;
import dominio.examen.ports.out.OpcionRepositoryPort;
import dominio.exepcion.FondYouException;

public class EditarOpcionUseCaseImpl implements EditarOpcionUseCase {

    private final OpcionRepositoryPort opcionRepositoryPort;

    public EditarOpcionUseCaseImpl(OpcionRepositoryPort opcionRepositoryPort){
        this.opcionRepositoryPort=opcionRepositoryPort;
    }

    @Override
    public boolean editar(Opcion e,Long preguntaId ) throws FondYouException {
        return opcionRepositoryPort.editar(e, preguntaId);
    }
}
