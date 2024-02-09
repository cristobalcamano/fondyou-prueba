package aplicacion.estudiante.servicio;

import dominio.estudiante.model.Estudiante;
import dominio.estudiante.model.Respuestas;
import dominio.estudiante.ports.in.*;
import dominio.model.Estado;
import dominio.model.ZonaHoraria;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicioTareaEstudianteTest {

    @InjectMocks
    private ServicioTareaEstudiante servicioTareaEstudiante;

    @Mock
    private CrearEstudianteUseCase crearEstudianteUseCase;
    @Mock
    private EditarEstudianteUseCase editarEstudianteUseCase;
    @Mock
    private ConsultarTodosEstudianteUseCase consultarTodosEstudianteUseCase;
    @Mock
    private ConsultarEstudianteUsecase consultarEstudianteUsecase;
    @Mock
    private RealizarExamenUseCase realizarExamenUseCase;
    @Mock
    private AsignarExamenEstudianteUseCase asignarExamenEstudianteUseCase;

    @Test
    void crearEstudiante() throws  Exception{
        Estudiante estudiante = new Estudiante(1L, "nombre", "identificacion",
                new ZonaHoraria(1L,""), new Estado(1L,"Estado"));

        when(crearEstudianteUseCase.crear(estudiante)).thenReturn(true);

        Boolean validar = servicioTareaEstudiante.crear(estudiante);
        assertTrue(validar);

    }

    @Test
    void editarEstudiante() throws Exception{
        Estudiante estudiante = new Estudiante(1L, "nombre", "identificacion",
                new ZonaHoraria(1L,""), new Estado(1L,"Estado"));

        when(editarEstudianteUseCase.editar(estudiante)).thenReturn(true);

        Boolean validar = servicioTareaEstudiante.editar(estudiante);
        assertTrue(validar);
    }

    @Test
    void consultarTodosEstudiante() throws  Exception{
        List<Estudiante> lista = new ArrayList();
        Estudiante estudiante = new Estudiante(1L, "nombre", "identificacion",
                new ZonaHoraria(1L,""), new Estado(1L,"Estado"));

        lista.add(estudiante);

        when(consultarTodosEstudianteUseCase.consultarTodos()).thenReturn(lista);

        List<Estudiante> listaVal = servicioTareaEstudiante.consultarTodos();
        assertEquals(listaVal.get(0).getNombre(),"nombre");

    }

    @Test
    void consultarEstudiante() throws  Exception{
        Estudiante estudiante = new Estudiante(1L, "nombre", "identificacion",
                new ZonaHoraria(1L,""), new Estado(1L,"Estado"));

        when(consultarEstudianteUsecase.consultar(1L)).thenReturn(estudiante);

        Estudiante estudianteVal = servicioTareaEstudiante.consultar(1L);
        assertEquals(estudianteVal.getNombre(),"nombre");
    }

    @Test
    void realizarExamen() throws  Exception{
        Respuestas respuestas = new Respuestas(1L,1L,1L,1L);

        when(realizarExamenUseCase.realizarExamen(respuestas)).thenReturn(true);

        Boolean validar = servicioTareaEstudiante.realizarExamen(respuestas);
        assertTrue(validar);

    }

    @Test
    void asignarExamen() throws  Exception{

        when(asignarExamenEstudianteUseCase.AsignarExamen(1L,1L)).thenReturn(true);

        Boolean validar = servicioTareaEstudiante.AsignarExamen(1L,1L);
        assertTrue(validar);
    }

}
