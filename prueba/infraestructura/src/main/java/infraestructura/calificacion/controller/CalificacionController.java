package infraestructura.calificacion.controller;

import aplicacion.calificacion.servicio.ServicioTareaCalificacion;
import dominio.estudiante.model.Estudiante;
import dominio.exepcion.FondYouException;
import dominio.resultados.model.Calificacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("calificacion")
public class CalificacionController {

    private final ServicioTareaCalificacion servicioTareaCalificacion;

    public CalificacionController(ServicioTareaCalificacion servicioTareaCalificacion){
        this.servicioTareaCalificacion = servicioTareaCalificacion;
    }

    @PostMapping("/examen/{examen}")
    public ResponseEntity<?> crear(@PathVariable Long examen) {
        try {
            Boolean respuesta = servicioTareaCalificacion.calificar(examen);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{estudiante}")
    public ResponseEntity<?> consultar(@PathVariable Long estudiante) {
        try {
            Calificacion respuesta = servicioTareaCalificacion.consultar(estudiante);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> consultarTodos() {
        try {
            List<Calificacion> respuesta = servicioTareaCalificacion.consultarTodos();
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
