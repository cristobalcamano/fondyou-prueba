package aplicacion.examen.servicio;

import aplicacion.util.Utilidades;
import dominio.examen.model.Opcion;
import dominio.examen.ports.in.opcion.CrearOpcionUseCase;
import dominio.examen.ports.in.opcion.EditarOpcionUseCase;
import dominio.exepcion.FondYouException;

public class ServicioTareaOpcion implements CrearOpcionUseCase, EditarOpcionUseCase {

    private final CrearOpcionUseCase crearOpcionUseCase;
    private final EditarOpcionUseCase editarOpcionUseCase;

    public ServicioTareaOpcion(CrearOpcionUseCase crearOpcionUseCase, EditarOpcionUseCase editarOpcionUseCase){
        this.crearOpcionUseCase = crearOpcionUseCase;
        this.editarOpcionUseCase = editarOpcionUseCase;
    }

    @Override
    public boolean crear(Opcion e,Long preguntaId) throws FondYouException {
        if(Utilidades.vacio(e.getOpcion())
                ||Utilidades.vacio(preguntaId)
                || Utilidades.vacio(e.getEstado() != null ? e.getEstado().getId() : 0L)){
            throw new FondYouException("Los valores opcion, pregunta y Estado " +
                    "son obligatorios");
        }
        return crearOpcionUseCase.crear(e,preguntaId);
    }

    @Override
    public boolean editar(Opcion e,Long preguntaId) throws FondYouException {
        if(Utilidades.vacio(e.getOpcion())
                || Utilidades.vacio(e.getId())
                || Utilidades.vacio(preguntaId)
                || Utilidades.vacio(e.getEstado() != null ? e.getEstado().getId() : 0L)){
            throw new FondYouException("Los valores id, opcion, pregunta y Estado " +
                    "son obligatorios");
        }
        return editarOpcionUseCase.editar(e,preguntaId);
    }
}
