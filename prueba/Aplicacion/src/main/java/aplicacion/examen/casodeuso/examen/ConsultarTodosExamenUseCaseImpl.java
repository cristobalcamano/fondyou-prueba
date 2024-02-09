package aplicacion.examen.casodeuso.examen;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;
import dominio.examen.ports.in.examen.ConsultarTodosExamenUseCase;
import dominio.examen.ports.out.ExamenRepositoryPort;

import java.util.List;

public class ConsultarTodosExamenUseCaseImpl implements ConsultarTodosExamenUseCase {

    private final ExamenRepositoryPort examenRepositoryPort;

    public ConsultarTodosExamenUseCaseImpl(ExamenRepositoryPort examenRepositoryPort) {
        this.examenRepositoryPort = examenRepositoryPort;
    }

    @Override
    public List<Examen> consultarTodos() throws FondYouException {
        return examenRepositoryPort.consultarTodos();
    }
}
