package aplicacion.estudiante.casodeuso;

import dominio.estudiante.ports.in.AsignarExamenEstudianteUseCase;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import dominio.exepcion.FondYouException;

import java.text.ParseException;

public class AsignarExamenEstudianteUseCaseImpl implements AsignarExamenEstudianteUseCase {

    private final EstudianteRepositoryPort estudianteRepositoryPort;

    public AsignarExamenEstudianteUseCaseImpl(EstudianteRepositoryPort estudianteRepositoryPort){
        this.estudianteRepositoryPort=estudianteRepositoryPort;
    }

    @Override
    public Boolean AsignarExamen(Long estudiante, Long examen) throws FondYouException {
        return estudianteRepositoryPort.asignarExamen(estudiante,examen);
    }
}
