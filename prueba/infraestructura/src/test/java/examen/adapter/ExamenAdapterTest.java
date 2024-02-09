package examen.adapter;

import dominio.examen.model.Examen;
import dominio.model.Estado;
import dominio.model.ZonaHoraria;
import infraestructura.examen.adapter.ExamenAdapter;
import infraestructura.examen.model.entity.ExamenEntity;
import infraestructura.examen.repository.ExamenRepository;
import infraestructura.model.entity.EstadoEntity;
import infraestructura.model.entity.ZonaHorariaEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamenAdapterTest {

    @InjectMocks
    private ExamenAdapter examenAdapter;

    @Mock
    private ExamenRepository examenRepository;

    @Test
    void crearExamen() throws Exception{

        Examen examen = new Examen(1L,  "nombre",  "descripcion",  "2023-10-10 10:00:00",
                new ZonaHoraria(1L,"Zona"), new Estado(1L,"nombre"),
                null);

        ExamenEntity examenEntity = new ExamenEntity(1L, "nombre",
                "descripcion", "2023-10-10 10:00:00", new ZonaHorariaEntity(1L,"Zona"),
                new EstadoEntity(1L,"Zona"), null);

        when(examenRepository.save(any())).thenReturn(examenEntity);

        Boolean validar = examenAdapter.crear(examen);
        assertTrue(validar);

    }

    @Test
    void editarExamen() throws  Exception{
        Examen examen = new Examen(1L,  "nombre",  "descripcion",  "2023-10-10 10:00:00",
                new ZonaHoraria(1L,"Zona"), new Estado(1L,"nombre"),
                null);

        ExamenEntity examenEntity = new ExamenEntity(1L, "nombre",
                "descripcion", "2023-10-10 10:00:00", new ZonaHorariaEntity(1L,"Zona"),
                new EstadoEntity(1L,"Zona"), null);

        when(examenRepository.save(any())).thenReturn(examenEntity);
        when(examenRepository.findById(any())).thenReturn(Optional.of(examenEntity));

        Boolean validar = examenAdapter.editar(examen);
        assertTrue(validar);
    }

    @Test
    void consultarPorIdExamen() throws  Exception{

        ExamenEntity examenEntity = new ExamenEntity(1L, "nombre",
                "descripcion", "2023-10-10 10:00:00", new ZonaHorariaEntity(1L,"Zona"),
                new EstadoEntity(1L,"Zona"), null);

        when(examenRepository.findById(any())).thenReturn(Optional.of(examenEntity));
        Examen e = examenAdapter.consultarPorID(1L);
        assertEquals(e.getNombre(),"nombre");
    }

    @Test
    void ConsultarTodosExamen() throws  Exception{
        Examen examen = new Examen(1L,  "nombre",  "descripcion",  "2023-10-10 10:00:00",
                new ZonaHoraria(1L,"Zona"), new Estado(1L,"nombre"),
                null);

        ExamenEntity examenEntity = new ExamenEntity(1L, "nombre",
                "descripcion", "2023-10-10 10:00:00", new ZonaHorariaEntity(1L,"Zona"),
                new EstadoEntity(1L,"Zona"), null);
        List<ExamenEntity> lista = new ArrayList();
        lista.add(examenEntity);
        when(examenRepository.findAll()).thenReturn(lista);

        List<Examen> listaDto = examenAdapter.consultarTodos();

        assertEquals(listaDto.get(0).getNombre(),"nombre");

    }

}
