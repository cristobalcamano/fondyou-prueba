package aplicacion.estudiante.casodeuso;

import dominio.estudiante.ports.in.CrearEstudianteUseCase;
import dominio.estudiante.model.Estudiante;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import dominio.exepcion.FondYouException;

public class CrearEstudianteUseCaseImpl implements CrearEstudianteUseCase {
    private final EstudianteRepositoryPort estudianteRepositoryPort;

    public CrearEstudianteUseCaseImpl(EstudianteRepositoryPort estudianteRepositoryPort){
        this.estudianteRepositoryPort=estudianteRepositoryPort;
    }

    @Override
    public Boolean crear(Estudiante estudiante) throws FondYouException {
        return estudianteRepositoryPort.crear(estudiante);
    }
}
