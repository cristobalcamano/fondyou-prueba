package dominio.examen.ports.out;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Pregunta;

public interface PreguntaRepositoryPort {

    public boolean crear(Pregunta e,Long examenId) throws FondYouException;
    public boolean editar(Pregunta e,Long examenId) throws FondYouException;

}
