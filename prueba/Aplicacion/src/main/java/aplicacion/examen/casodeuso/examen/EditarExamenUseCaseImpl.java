package aplicacion.examen.casodeuso.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;
import dominio.examen.ports.in.examen.EditarExamenUseCase;
import dominio.examen.ports.out.ExamenRepositoryPort;

public class EditarExamenUseCaseImpl implements EditarExamenUseCase {

    private final ExamenRepositoryPort examenRepositoryPort;

    public EditarExamenUseCaseImpl(ExamenRepositoryPort examenRepositoryPort) {
        this.examenRepositoryPort = examenRepositoryPort;
    }

    @Override
    public boolean editar(Examen e) throws FondYouException {
        return examenRepositoryPort.editar(e);
    }
}
