package dominio.examen.ports.in.pregunta;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Pregunta;

public interface EditarPreguntaUseCase {

    public boolean editar(Pregunta e, Long examenId) throws FondYouException;

}
