package aplicacion.examen.casodeuso.pregunta;

import dominio.examen.model.Pregunta;
import dominio.examen.ports.in.pregunta.CrearPreguntaUseCase;
import dominio.examen.ports.out.PreguntaRepositoryPort;
import dominio.exepcion.FondYouException;

public class CrearPreguntaUseCaseImpl implements CrearPreguntaUseCase {

    private final PreguntaRepositoryPort preguntaRepositoryPort;

    public CrearPreguntaUseCaseImpl(PreguntaRepositoryPort preguntaRepositoryPort){
        this.preguntaRepositoryPort=preguntaRepositoryPort;
    }

    @Override
    public boolean crear(Pregunta e,Long examenId) throws FondYouException {
        return preguntaRepositoryPort.crear(e,examenId);
    }
}
