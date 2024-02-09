package calificacion.adapter;

import dominio.resultados.model.Calificacion;
import infraestructura.calificacion.adapter.CalificacionAdapter;
import infraestructura.calificacion.model.entity.CalificacionEntity;
import infraestructura.calificacion.model.entity.EstudianteExamenEntity;
import infraestructura.calificacion.repository.CalificacionRepository;
import infraestructura.calificacion.repository.EstudianteExamenCRepository;
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
public class CalificacionAdapterTest {

    @InjectMocks
    private infraestructura.calificacion.adapter.CalificacionAdapter calificacionAdapter;
    @Mock
    private CalificacionRepository calificacionRepository;
    @Mock
    private EstudianteExamenCRepository estudianteExamenCRepository;

    @Test
    void calificar() throws  Exception{
        EstudianteExamenEntity estudianteExamenEntity = new EstudianteExamenEntity(1L, 1L,
                1L, "Zona");
        List<EstudianteExamenEntity> lista = new ArrayList<>();
        lista.add(estudianteExamenEntity);
        when(estudianteExamenCRepository.findAllEstudiantesByExamen(1L)).thenReturn(lista);

        when(estudianteExamenCRepository.
                findAllrespuestasByEsrudiante(1L, 1L)).thenReturn(1);

        when(calificacionRepository.save(any())).thenReturn(null);

        Boolean validar= calificacionAdapter.calificar(1L);
        assertTrue(validar);

    }

    @Test
    void consultar() throws  Exception{
        CalificacionEntity calificacionEntity = new CalificacionEntity(1L,
                "Calificacion final", 1L);

        EstudianteExamenEntity estudianteExamenEntity = new EstudianteExamenEntity(1L,1L,
                1L,"ZonaHoraria");

        when(calificacionRepository.findById(1L)).thenReturn(Optional.of(calificacionEntity));
        when(estudianteExamenCRepository.findById(calificacionEntity.getIdEstudianteExamen()))
                        .thenReturn(Optional.of(estudianteExamenEntity));

        Calificacion calificacionVal = calificacionAdapter.consultar(1L);
        assertEquals(calificacionVal.getEstudiante(),1L);
    }

    @Test
    void consultarTodos() throws  Exception{
        CalificacionEntity calificacionEntity = new CalificacionEntity(1L,
                "Calificacion final", 1L);
        List<CalificacionEntity> lista = new ArrayList();
        lista.add(calificacionEntity);

        EstudianteExamenEntity estudianteExamenEntity = new EstudianteExamenEntity(1L,
                1L, 1L, "ZonaHoraria");

        when(calificacionRepository.findAll()).thenReturn(lista);
        when(estudianteExamenCRepository.findById(1L)).thenReturn(Optional.of(estudianteExamenEntity));

        List<Calificacion> listaCalificacion = calificacionAdapter.consultarTodos();
        assertEquals(listaCalificacion.get(0).getEstudiante(),1L);

    }

}
