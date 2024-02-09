package aplicacion.examen.servicio;

import aplicacion.util.Utilidades;
import dominio.examen.model.Examen;
import dominio.examen.ports.in.examen.ConsultarExamenUseCase;
import dominio.examen.ports.in.examen.ConsultarTodosExamenUseCase;
import dominio.examen.ports.in.examen.CrearExamenUseCase;
import dominio.exepcion.FondYouException;
import dominio.examen.ports.in.examen.EditarExamenUseCase;

import java.util.List;

public class ServicioTareaExamen implements CrearExamenUseCase, ConsultarTodosExamenUseCase,
        ConsultarExamenUseCase, EditarExamenUseCase {

    private final CrearExamenUseCase crearExamenUseCase;
    private final ConsultarTodosExamenUseCase consultarTodosExamenUseCase;
    private final ConsultarExamenUseCase consultarExamenUseCase;
    private final EditarExamenUseCase editarExamenUseCase;

    public ServicioTareaExamen(CrearExamenUseCase crearExamenUseCase,
                               ConsultarTodosExamenUseCase consultarTodosExamenUseCase,
                               ConsultarExamenUseCase consultarExamenUseCase,
                               EditarExamenUseCase editarExamenUseCase){
        this.crearExamenUseCase=crearExamenUseCase;
        this.consultarTodosExamenUseCase=consultarTodosExamenUseCase;
        this.consultarExamenUseCase=consultarExamenUseCase;
        this.editarExamenUseCase=editarExamenUseCase;
    }

    @Override
    public boolean crear(Examen e) throws FondYouException {
        if(Utilidades.vacio(e.getDescripcion()) || Utilidades.vacio(e.getNombre())
                || Utilidades.vacio(e.getFechaExamen())
            || Utilidades.vacio(e.getZonaHoraria() != null ? e.getZonaHoraria().getId() : 0L)
                || Utilidades.vacio(e.getEstado() != null ? e.getEstado().getId() : 0L)){
            throw new FondYouException("Los valores Nombre, Descripcion, ZonaHoraria y Estado " +
                    "son obligatorios");
        }
        return crearExamenUseCase.crear(e);
    }

    @Override
    public Examen consultar(Long id) throws FondYouException {
        return consultarExamenUseCase.consultar(id);
    }

    @Override
    public boolean editar(Examen e) throws FondYouException {
        if(Utilidades.vacio(e.getDescripcion()) || Utilidades.vacio(e.getNombre())
                || Utilidades.vacio(e.getFechaExamen())
                || Utilidades.vacio(e.getZonaHoraria() != null ? e.getZonaHoraria().getId() : 0L)
                || Utilidades.vacio(e.getEstado() != null ? e.getEstado().getId() : 0L)){
            throw new FondYouException("Los valores Nombre, Descripcion, ZonaHoraria, Fecha del " +
                    "examen formato(yyyy-MM-dd HH:mm:ss) y Estado " +
                    "son obligatorios");
        }
        return editarExamenUseCase.editar(e);
    }

    @Override
    public List<Examen> consultarTodos() throws FondYouException {
        return consultarTodosExamenUseCase.consultarTodos();
    }
}
