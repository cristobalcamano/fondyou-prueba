package aplicacion.estudiante.casodeuso;

import dominio.estudiante.ports.in.ConsultarTodosEstudianteUseCase;
import dominio.estudiante.model.Estudiante;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import dominio.exepcion.FondYouException;

import java.util.List;

public class ConsultarTodosEstidianteUseCaseImpl implements ConsultarTodosEstudianteUseCase {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    public ConsultarTodosEstidianteUseCaseImpl(EstudianteRepositoryPort estudianteRepositoryPort){
        this.estudianteRepositoryPort=estudianteRepositoryPort;
    }


    @Override
    public List<Estudiante> consultarTodos() throws FondYouException {
        return estudianteRepositoryPort.consultarTodos();
    }
}
