package infraestructura.examen.controller;

import aplicacion.examen.servicio.ServicioTareaExamen;
import dominio.exepcion.FondYouException;
import dominio.examen.model.Examen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("examen")
public class ExamenController {

    private final ServicioTareaExamen servicioTareaExamen;

    public ExamenController(ServicioTareaExamen servicioTareaExamen){
        this.servicioTareaExamen = servicioTareaExamen;
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Examen examen) {
        try {
            Boolean respuesta = servicioTareaExamen.crear(examen);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> editar(@RequestBody Examen examen) {
        try {
            Boolean respuesta = servicioTareaExamen.editar(examen);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultar(@PathVariable Long id) {
        try {
            Examen respuesta = servicioTareaExamen.consultar(id);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<?> concultarTodos() {
        try {
            List<Examen> respuesta = servicioTareaExamen.consultarTodos();
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
