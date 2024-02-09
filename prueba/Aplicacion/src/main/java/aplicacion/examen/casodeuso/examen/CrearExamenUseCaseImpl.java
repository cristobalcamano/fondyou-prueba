package aplicacion.examen.casodeuso.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;
import dominio.examen.ports.in.examen.CrearExamenUseCase;
import dominio.examen.ports.out.ExamenRepositoryPort;

public class CrearExamenUseCaseImpl implements CrearExamenUseCase {

    private final ExamenRepositoryPort examenRepositoryPort;

    public CrearExamenUseCaseImpl(ExamenRepositoryPort examenRepositoryPort) {
        this.examenRepositoryPort = examenRepositoryPort;
    }

    @Override
    public boolean crear(Examen e) throws FondYouException {
        return examenRepositoryPort.crear(e);
    }

}
