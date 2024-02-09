package aplicacion.estudiante.casodeuso;

import dominio.estudiante.ports.in.ConsultarEstudianteUsecase;
import dominio.estudiante.model.Estudiante;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import dominio.exepcion.FondYouException;

public class ConsultarEstudianteUseCaseImpl implements ConsultarEstudianteUsecase {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    public ConsultarEstudianteUseCaseImpl(EstudianteRepositoryPort estudianteRepositoryPort){
        this.estudianteRepositoryPort=estudianteRepositoryPort;
    }

    @Override
    public Estudiante consultar(Long id) throws FondYouException {
        return estudianteRepositoryPort.consultarPorID(id);
    }
}
