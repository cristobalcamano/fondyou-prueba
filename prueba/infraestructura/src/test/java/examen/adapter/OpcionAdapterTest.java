package examen.adapter;

import dominio.examen.model.Opcion;
import infraestructura.examen.adapter.OpcionAdapter;
import infraestructura.examen.model.entity.OpcionEntity;
import infraestructura.examen.model.entity.PreguntaEntity;
import infraestructura.examen.repository.OpcionRepository;
import infraestructura.examen.repository.PreguntaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OpcionAdapterTest {

    @InjectMocks
    private OpcionAdapter opcionAdapter;

    @Mock
    private OpcionRepository opcionRepository;
    @Mock
    private PreguntaRepository preguntaRepository;

    @Test
    void crear() throws  Exception{

        PreguntaEntity preguntaEntity = new PreguntaEntity();
        when(preguntaRepository.findById(1L)).thenReturn(Optional.of(preguntaEntity));
        when(opcionRepository.save(any())).thenReturn(null);

        Opcion o = new Opcion();

        Boolean validar= opcionAdapter.crear(o, 1L);
        assertTrue(validar);

    }

    @Test
    void editar() throws  Exception{
        PreguntaEntity preguntaEntity = new PreguntaEntity();
        when(preguntaRepository.findById(1L)).thenReturn(Optional.of(preguntaEntity));

        OpcionEntity opcionEntity = new OpcionEntity();
        when(opcionRepository.findById(1L)).thenReturn(Optional.of(opcionEntity));
        when(opcionRepository.save(any())).thenReturn(null);

        Opcion o = new Opcion();
        o.setId(1L);
        Boolean validar= opcionAdapter.editar(o, 1L);
        assertTrue(validar);

    }

}
