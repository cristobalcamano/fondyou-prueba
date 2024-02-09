package aplicacion.examen.servicio;

import dominio.examen.model.Opcion;
import dominio.examen.model.Pregunta;
import dominio.examen.ports.in.pregunta.CrearPreguntaUseCase;
import dominio.examen.ports.in.pregunta.EditarPreguntaUseCase;
import dominio.model.Estado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicioTareaPreguntaTest {

    @InjectMocks
    private ServicioTareaPregunta servicioTareaPregunta;

    @Mock
    private CrearPreguntaUseCase crearPreguntaUseCase;
    @Mock
    private EditarPreguntaUseCase editarPreguntaUseCase;

    @Test
    void crearPregunta() throws  Exception{
        Pregunta pregunta = new Pregunta(1L, "titulo", "pregunta",
                 "descripcion", new Opcion(1l,"",new Estado(1L,"Estado")),
                new Estado(1L,"Estado"), null);

        when(crearPreguntaUseCase.crear(pregunta, 1L)).thenReturn(true);

        Boolean validar = servicioTareaPregunta.crear(pregunta, 1L);
        assertTrue(validar);

    }

    @Test
    void editarPregunta() throws  Exception{
        Pregunta pregunta = new Pregunta(1L, "titulo", "pregunta",
                "descripcion", new Opcion(1l,"",new Estado(1L,"Estado")),
                new Estado(1L,"Estado"), null);

        when(editarPreguntaUseCase.editar(pregunta, 1L)).thenReturn(true);

        Boolean validar = servicioTareaPregunta.editar(pregunta, 1L);
        assertTrue(validar);

    }

}
