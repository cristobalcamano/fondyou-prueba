package aplicacion.examen.servicio;

import dominio.examen.model.Examen;
import dominio.examen.ports.in.examen.ConsultarExamenUseCase;
import dominio.examen.ports.in.examen.ConsultarTodosExamenUseCase;
import dominio.examen.ports.in.examen.CrearExamenUseCase;
import dominio.examen.ports.in.examen.EditarExamenUseCase;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicioTareaExamenTest {

    @InjectMocks
    private ServicioTareaExamen servicioTareaExamen;

    @Mock
    private CrearExamenUseCase crearExamenUseCase;
    @Mock
    private ConsultarTodosExamenUseCase consultarTodosExamenUseCase;
    @Mock
    private ConsultarExamenUseCase consultarExamenUseCase;
    @Mock
    private EditarExamenUseCase editarExamenUseCase;

    @Test
    void crearExamen() throws Exception {
        ZonaHoraria zonaHoraria = new ZonaHoraria(1L,"Zona");
        Estado estado = new Estado(1L,"Estado" );
        Examen examen = new Examen(1L, "nombre", "descripcion", "fechaExamen",
                zonaHoraria, estado, null);
        when(crearExamenUseCase.crear(any())).thenReturn(true);

        Boolean validar = servicioTareaExamen.crear(examen);
        assertTrue(validar);

    }

    @Test
    void consultarExamen() throws Exception {

        ZonaHoraria zonaHoraria = new ZonaHoraria(1L,"Zona");
        Estado estado = new Estado(1L,"Estado" );
        Examen examen = new Examen(1L, "nombre", "descripcion", "fechaExamen",
                zonaHoraria, estado, null);

        when(consultarExamenUseCase.consultar(1L)).thenReturn(examen);

        Examen examenVal = servicioTareaExamen.consultar(1L);
        assertEquals(examenVal.getNombre(),"nombre");

    }

    @Test
    void consultarTodosExamen() throws Exception {

        ZonaHoraria zonaHoraria = new ZonaHoraria(1L,"Zona");
        Estado estado = new Estado(1L,"Estado" );
        Examen examen = new Examen(1L, "nombre", "descripcion", "fechaExamen",
                zonaHoraria, estado, null);
        List<Examen> examenList = new ArrayList();
        examenList.add(examen);

        when(consultarTodosExamenUseCase.consultarTodos()).thenReturn(examenList);

        List<Examen> examenListVal = servicioTareaExamen.consultarTodos();

        assertEquals(examenListVal.get(0).getFechaExamen(),"fechaExamen");
    }

    @Test
    void editarExamen() throws Exception {

        ZonaHoraria zonaHoraria = new ZonaHoraria(1L,"Zona");
        Estado estado = new Estado(1L,"Estado" );
        Examen examen = new Examen(1L, "nombre", "descripcion", "fechaExamen",
                zonaHoraria, estado, null);

        when(editarExamenUseCase.editar(examen)).thenReturn(true);

        Boolean validar = servicioTareaExamen.editar(examen);
        assertTrue(validar);

    }

}
