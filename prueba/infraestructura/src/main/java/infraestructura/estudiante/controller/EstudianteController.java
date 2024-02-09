package infraestructura.estudiante.controller;

import aplicacion.estudiante.servicio.ServicioTareaEstudiante;
import dominio.estudiante.model.Estudiante;
import dominio.estudiante.model.Respuestas;
import dominio.exepcion.FondYouException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante")
public class EstudianteController {


    private final ServicioTareaEstudiante servicioTareaEstudiante;

    public EstudianteController(ServicioTareaEstudiante servicioTareaEstudiante){
        this.servicioTareaEstudiante = servicioTareaEstudiante;
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@RequestBody Estudiante estudiante) {
        try {
            Boolean respuesta = servicioTareaEstudiante.crear(estudiante);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> editar(@RequestBody Estudiante estudiante) {
        try {
            Boolean respuesta = servicioTareaEstudiante.editar(estudiante);
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
            Estudiante respuesta = servicioTareaEstudiante.consultar(id);
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
            List<Estudiante> respuesta = servicioTareaEstudiante.consultarTodos();
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{estudiante}/asignar-examen/{examen}")
    public ResponseEntity<?> realizarExamen(@PathVariable Long estudiante, @PathVariable Long examen) {
        try {
            Boolean respuesta = servicioTareaEstudiante.AsignarExamen(estudiante, examen);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/realiar-examen")
    public ResponseEntity<?> realizarExamen(@RequestBody Respuestas respuestas) {
        try {
            Boolean respuesta = servicioTareaEstudiante.realizarExamen(respuestas);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (FondYouException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Tenemos problemas, intenta mas tarde por favor",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
