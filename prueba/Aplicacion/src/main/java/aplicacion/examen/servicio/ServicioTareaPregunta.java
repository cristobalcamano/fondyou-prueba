package aplicacion.examen.servicio;

import aplicacion.util.Utilidades;
import dominio.examen.model.Pregunta;
import dominio.examen.ports.in.pregunta.CrearPreguntaUseCase;
import dominio.examen.ports.in.pregunta.EditarPreguntaUseCase;
import dominio.exepcion.FondYouException;

public class ServicioTareaPregunta implements CrearPreguntaUseCase, EditarPreguntaUseCase {

    private final CrearPreguntaUseCase crearPreguntaUseCase;
    private final EditarPreguntaUseCase editarPreguntaUseCase;

    public ServicioTareaPregunta(CrearPreguntaUseCase crearPreguntaUseCase,
                                 EditarPreguntaUseCase editarPreguntaUseCase){
        this.crearPreguntaUseCase=crearPreguntaUseCase;
        this.editarPreguntaUseCase=editarPreguntaUseCase;
    }


    @Override
    public boolean crear(Pregunta p, Long examenId) throws FondYouException {
        if(Utilidades.vacio(examenId)
                || Utilidades.vacio(p.getPregunta())
                || Utilidades.vacio(p.getDescripcion())
                || Utilidades.vacio(p.getTitulo())
                || Utilidades.vacio(p.getEstado() != null ? p.getEstado().getId() : 0L)){
            throw new FondYouException("Los valores examen, pregunta, descripcion, titulo y Estado " +
                    "son obligatorios");
        }
        return crearPreguntaUseCase.crear(p, examenId);
    }

    @Override
    public boolean editar(Pregunta p, Long examenId) throws FondYouException {
        if(Utilidades.vacio(examenId)
                || Utilidades.vacio(p.getPregunta())
                ||Utilidades.vacio(p.getDescripcion())
                ||Utilidades.vacio(p.getTitulo())
                || Utilidades.vacio(p.getEstado() != null ? p.getEstado().getId() : 0L)){
            throw new FondYouException("Los valores examen id, pregunta, descripcion, titulo y Estado " +
                    "son obligatorios");
        }
        return editarPreguntaUseCase.editar(p,examenId);
    }
}
