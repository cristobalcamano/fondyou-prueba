package aplicacion.estudiante.casodeuso;

import dominio.estudiante.ports.in.RealizarExamenUseCase;
import dominio.estudiante.model.Respuestas;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import dominio.exepcion.FondYouException;

public class RealizarExamenUseCaseImpl implements RealizarExamenUseCase {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    public RealizarExamenUseCaseImpl(EstudianteRepositoryPort estudianteRepositoryPort){
        this.estudianteRepositoryPort=estudianteRepositoryPort;
    }

    @Override
    public Boolean realizarExamen(Respuestas respuestas) throws FondYouException {
        return estudianteRepositoryPort.realizarExamen(respuestas);
    }
}
