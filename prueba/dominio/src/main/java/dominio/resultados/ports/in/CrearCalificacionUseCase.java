package dominio.resultados.ports.in;

import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;

public interface CrearCalificacionUseCase {

    public Boolean calificar(Long idExamen) throws FondYouException;

}
