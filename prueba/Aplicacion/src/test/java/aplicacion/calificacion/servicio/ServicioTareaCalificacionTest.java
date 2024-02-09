package aplicacion.calificacion.servicio;

import dominio.resultados.model.Calificacion;
import dominio.resultados.ports.in.ConsultarCalificacionUseCase;
import dominio.resultados.ports.in.ConsultarTodosCalificacionUseCase;
import dominio.resultados.ports.in.CrearCalificacionUseCase;
import org.junit.jupiter.api.BeforeEach;
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
public class ServicioTareaCalificacionTest {

    @Mock
    private CrearCalificacionUseCase crearCalificacionUseCase;

    @Mock
    private ConsultarTodosCalificacionUseCase consultarTodosCalificacionUseCase;

    @Mock
    private ConsultarCalificacionUseCase consultarCalificacionUseCase;

    @InjectMocks
    private ServicioTareaCalificacion servicioTareaCalificacion;

    private String calificacion;

    @BeforeEach
    public void setUp(){
        calificacion = "calificacionFinal";
    }

    @Test
    void consultar() throws  Exception{

        Calificacion calificacionMock = new Calificacion(1L, "calificacionFinal", 1L, 1L);
        when(consultarCalificacionUseCase.consultar(1L)).thenReturn(calificacionMock);

        Calificacion calificacion = servicioTareaCalificacion.consultar(1L);
        assertEquals(calificacion.getCalificacionFinal(),"calificacionFinal");
    }

    @Test
    void consultarTodos() throws  Exception{

        Calificacion calificacion = new Calificacion(1L, "calificacionFinal", 1L, 1L);

        List<Calificacion> calificacionListMock = new ArrayList();
        calificacionListMock.add(calificacion);
        when(consultarTodosCalificacionUseCase.consultarTodos()).thenReturn(calificacionListMock);

        List<Calificacion> calificacionList = servicioTareaCalificacion.consultarTodos();
        assertEquals(calificacionList.get(0).getCalificacionFinal(),"calificacionFinal");
    }

    @Test
    void calificar() throws  Exception{
        when(crearCalificacionUseCase.calificar(1L)).thenReturn(true);
        Boolean validar = servicioTareaCalificacion.calificar(1L);
        assertTrue(validar);
    }

}
