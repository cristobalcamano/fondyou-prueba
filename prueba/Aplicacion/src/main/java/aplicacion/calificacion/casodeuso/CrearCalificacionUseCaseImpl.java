package aplicacion.calificacion.casodeuso;

import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;
import dominio.resultados.ports.in.CrearCalificacionUseCase;
import dominio.resultados.ports.out.CalificacionRepositoryPort;

public class CrearCalificacionUseCaseImpl implements CrearCalificacionUseCase {

    private final CalificacionRepositoryPort calificacionRepositoryPort;

    public CrearCalificacionUseCaseImpl(CalificacionRepositoryPort calificacionRepositoryPort){
        this.calificacionRepositoryPort  = calificacionRepositoryPort;
    }

    @Override
    public Boolean calificar(Long idExamen) throws FondYouException {
        return calificacionRepositoryPort.calificar(idExamen);
    }
}
