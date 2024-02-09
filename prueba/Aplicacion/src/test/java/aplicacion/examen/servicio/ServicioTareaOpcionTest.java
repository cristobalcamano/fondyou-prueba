package aplicacion.examen.servicio;

import dominio.examen.model.Opcion;
import dominio.examen.ports.in.opcion.CrearOpcionUseCase;
import dominio.examen.ports.in.opcion.EditarOpcionUseCase;
import dominio.model.Estado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicioTareaOpcionTest {

    @InjectMocks
    private ServicioTareaOpcion  servicioTareaOpcion;

    @Mock
    private CrearOpcionUseCase crearOpcionUseCase;
    @Mock
    private EditarOpcionUseCase editarOpcionUseCase;

    @Test
    void crearOpcion() throws  Exception{

        Opcion opcion = new Opcion(1L,"Opcion", new Estado(1L,"Estado"));

        when(crearOpcionUseCase.crear(opcion,1L)).thenReturn(true);
        Boolean validar = servicioTareaOpcion.crear(opcion,1L);
        assertTrue(validar);


    }

    @Test
    void editarOpcion() throws  Exception{

        Opcion opcion = new Opcion(1L,"Opcion", new Estado(1L,"Estado"));

        when(editarOpcionUseCase.editar(opcion,1L)).thenReturn(true);
        Boolean validar = servicioTareaOpcion.editar(opcion,1L);
        assertTrue(validar);
    }


}
