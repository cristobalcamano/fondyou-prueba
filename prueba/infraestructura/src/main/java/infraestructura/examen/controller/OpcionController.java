package infraestructura.examen.controller;

import aplicacion.examen.servicio.ServicioTareaOpcion;
import dominio.examen.model.Examen;
import dominio.examen.model.Opcion;
import dominio.exepcion.FondYouException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("examen/pregunta/{preguntaId}/opcion")
public class OpcionController {

    private final ServicioTareaOpcion servicioTareaOpcion;

    public OpcionController(ServicioTareaOpcion servicioTareaOpcion){
        this.servicioTareaOpcion=servicioTareaOpcion;
    }

    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Opcion opcion, @PathVariable Long preguntaId) {
        try {
            Boolean respuesta = servicioTareaOpcion.crear(opcion,preguntaId);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> editar(@RequestBody Opcion opcion, @PathVariable Long preguntaId) {
        try {
            Boolean respuesta = servicioTareaOpcion.editar(opcion,preguntaId);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
