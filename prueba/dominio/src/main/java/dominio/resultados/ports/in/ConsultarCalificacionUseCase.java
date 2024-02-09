package dominio.resultados.ports.in;

import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;

public interface ConsultarCalificacionUseCase {

    public Calificacion consultar(Long id) throws FondYouException;

}
