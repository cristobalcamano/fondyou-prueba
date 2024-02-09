package aplicacion.examen.casodeuso.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;
import dominio.examen.ports.in.examen.ConsultarExamenUseCase;
import dominio.examen.ports.out.ExamenRepositoryPort;

public class ConsultarExamenUseCaseImpl implements ConsultarExamenUseCase {

    private final ExamenRepositoryPort examenRepositoryPort;

    public ConsultarExamenUseCaseImpl(ExamenRepositoryPort examenRepositoryPort) {
        this.examenRepositoryPort = examenRepositoryPort;
    }

    @Override
    public Examen consultar(Long id) throws FondYouException {
        return examenRepositoryPort.consultarPorID(id);
    }
}
