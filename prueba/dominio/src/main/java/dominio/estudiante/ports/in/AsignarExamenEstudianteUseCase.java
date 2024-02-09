package dominio.estudiante.ports.in;

import dominio.exepcion.FondYouException;

import java.text.ParseException;

public interface AsignarExamenEstudianteUseCase {

    public Boolean AsignarExamen(Long estudiante, Long examen) throws FondYouException;

}
