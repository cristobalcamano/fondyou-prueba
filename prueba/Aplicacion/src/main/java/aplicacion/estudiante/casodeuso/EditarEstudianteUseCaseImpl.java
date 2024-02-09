package aplicacion.estudiante.casodeuso;

import dominio.estudiante.ports.in.EditarEstudianteUseCase;
import dominio.estudiante.model.Estudiante;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import dominio.exepcion.FondYouException;

public class EditarEstudianteUseCaseImpl implements EditarEstudianteUseCase {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    public EditarEstudianteUseCaseImpl(EstudianteRepositoryPort estudianteRepositoryPort){
        this.estudianteRepositoryPort=estudianteRepositoryPort;
    }

    @Override
    public Boolean editar(Estudiante estudiante) throws FondYouException {
        return estudianteRepositoryPort.editar(estudiante);
    }
}
