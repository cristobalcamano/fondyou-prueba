package dominio.estudiante.ports.out;

import dominio.estudiante.model.Estudiante;
import dominio.estudiante.model.Respuestas;
import dominio.exepcion.FondYouException;

import java.text.ParseException;
import java.util.List;

public interface EstudianteRepositoryPort {

    public Boolean crear(Estudiante e) throws FondYouException;
    public Boolean editar(Estudiante e) throws FondYouException;
    public Estudiante consultarPorID(Long id) throws FondYouException;
    public List<Estudiante> consultarTodos() throws FondYouException;
    public Boolean asignarExamen(Long estudiante, Long Examen) throws FondYouException;
    public Boolean realizarExamen(Respuestas respuestas) throws FondYouException;

}
