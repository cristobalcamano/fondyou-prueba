package aplicacion.examen.casodeuso.pregunta;

import dominio.examen.model.Pregunta;
import dominio.examen.ports.in.pregunta.EditarPreguntaUseCase;
import dominio.examen.ports.out.PreguntaRepositoryPort;
import dominio.exepcion.FondYouException;

public class EditarPreguntaUseCaseImpl implements EditarPreguntaUseCase {

    private final PreguntaRepositoryPort preguntaRepositoryPort;

    public EditarPreguntaUseCaseImpl(PreguntaRepositoryPort preguntaRepositoryPort){
        this.preguntaRepositoryPort=preguntaRepositoryPort;
    }

    @Override
    public boolean editar(Pregunta e,Long examenId) throws FondYouException {
        return preguntaRepositoryPort.editar(e,examenId);
    }
}
