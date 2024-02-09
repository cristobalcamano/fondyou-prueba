package infraestructura.examen.controller;

import aplicacion.examen.servicio.ServicioTareaPregunta;
import dominio.examen.model.Examen;
import dominio.examen.model.Pregunta;
import dominio.exepcion.FondYouException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("examen/{idExamen}/pregunta")
public class PreguntaController {

    private final ServicioTareaPregunta servicioTareaPregunta;

    public PreguntaController(ServicioTareaPregunta servicioTareaPregunta){
        this.servicioTareaPregunta=servicioTareaPregunta;
    }

    @PostMapping("")
    public ResponseEntity<?> crear(@RequestBody Pregunta pregunta,@PathVariable Long idExamen) {
        try {
            Boolean respuesta = servicioTareaPregunta.crear(pregunta, idExamen);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> editar(@RequestBody Pregunta pregunta, @PathVariable Long idExamen) {
        try {
            Boolean respuesta = servicioTareaPregunta.editar(pregunta, idExamen);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
