package dominio.examen.ports.in.pregunta;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Pregunta;

public interface CrearPreguntaUseCase {

    public boolean crear(Pregunta e,Long examenId) throws FondYouException;

}
