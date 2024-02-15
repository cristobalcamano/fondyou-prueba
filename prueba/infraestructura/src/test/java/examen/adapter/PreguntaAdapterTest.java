package examen.adapter;

import dominio.examen.model.Opcion;
import dominio.examen.model.Pregunta;
import dominio.model.Estado;
import infraestructura.examen.adapter.PreguntaAdapter;
import infraestructura.examen.model.entity.ExamenEntity;
import infraestructura.examen.model.entity.PreguntaEntity;
import infraestructura.examen.repository.ExamenRepository;
import infraestructura.examen.repository.PreguntaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PreguntaAdapterTest {

    @InjectMocks
    private PreguntaAdapter preguntaAdapter;

    @Mock
    private PreguntaRepository preguntaRepository;
    @Mock
    private ExamenRepository examenRepository;

    //@Test
    void crear() throws  Exception{
        ExamenEntity examenEntity = new ExamenEntity();
        when(examenRepository.findById(1L)).thenReturn(Optional.of(examenEntity));
        when(preguntaRepository.save(any())).thenReturn(null);

        Pregunta pregunta = new Pregunta();
        pregunta.setId(1L);

        Opcion opcion = new Opcion();
        opcion.setId(1L);

        Estado estado = new Estado();
        estado.setId(1L);
        opcion.setEstado(estado);

        pregunta.setOpcionCorrecta(opcion);
        Boolean validar= preguntaAdapter.crear(pregunta, 1L);
        assertTrue(validar);
    }

    //@Test
    void editar() throws  Exception{
        ExamenEntity examenEntity = new ExamenEntity();
        when(examenRepository.findById(1L)).thenReturn(Optional.of(examenEntity));

        PreguntaEntity preguntaEntity = new PreguntaEntity();
        when(preguntaRepository.findById(any())).thenReturn(Optional.of(preguntaEntity));
        when(examenRepository.
                findExamenEstudianteByEstudianteAndExamen(1L, 1L))
                .thenReturn(1);
        when(preguntaRepository.save(any())).thenReturn(null);

        Pregunta pregunta = new Pregunta();
        pregunta.setId(1L);

        Opcion opcion = new Opcion();
        opcion.setId(1L);

        Estado estado = new Estado();
        estado.setId(1L);
        opcion.setEstado(estado);

        pregunta.setOpcionCorrecta(opcion);
        Boolean validar= preguntaAdapter.editar(pregunta, 1L);
        assertTrue(validar);
    }

}
