package dominio.examen.ports.out;

import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;

import java.util.List;

public interface ExamenRepositoryPort {

    public boolean crear(Examen e) throws FondYouException;
    public boolean editar(Examen e) throws FondYouException;
    public Examen consultarPorID(Long id) throws FondYouException;
    public List<Examen> consultarTodos() throws FondYouException;

}
