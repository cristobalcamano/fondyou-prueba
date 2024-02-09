package aplicacion.calificacion.casodeuso;

import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;
import dominio.resultados.ports.in.ConsultarCalificacionUseCase;
import dominio.resultados.ports.out.CalificacionRepositoryPort;

public class ConsultarCalificacionUseCaseImpl implements ConsultarCalificacionUseCase {

    private final CalificacionRepositoryPort calificacionRepositoryPort;

    public ConsultarCalificacionUseCaseImpl(CalificacionRepositoryPort calificacionRepositoryPort){
        this.calificacionRepositoryPort  = calificacionRepositoryPort;
    }

    @Override
    public Calificacion consultar(Long id) throws FondYouException {
        return calificacionRepositoryPort.consultar(id);
    }
}
