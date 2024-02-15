package estudiante.adapter;

import dominio.estudiante.model.Estudiante;
import dominio.estudiante.model.Respuestas;
import dominio.model.Estado;
import dominio.model.ZonaHoraria;
import infraestructura.estudiante.adapter.EstudianteAdapter;
import infraestructura.estudiante.model.entity.EstudianteEntity;
import infraestructura.estudiante.model.entity.EstudianteExamenCEntity;
import infraestructura.estudiante.repository.EstudianteExamenRepository;
import infraestructura.estudiante.repository.EstudianteRepository;
import infraestructura.estudiante.repository.RespuestasRepository;
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
public class EstudianteAdapterTest {

    @InjectMocks
    private EstudianteAdapter estudianteAdapter;

    @Mock
    private EstudianteRepository estudianteRepository;

    @Mock
    private EstudianteExamenRepository estudianteExamenRepository;

    @Mock
    private ExamenRepository examenRepository;

    @Mock
    private RespuestasRepository respuestasRepository;

    @Test
    void crear() throws  Exception{

        Estudiante estudiante = new Estudiante();

        Estado estado = new Estado();
        estado.setId(1L);
        estudiante.setEstado(estado);

        ZonaHoraria zonaHoraria = new ZonaHoraria();
        zonaHoraria.setId(1L);
        estudiante.setZonaHoraria(zonaHoraria);

        when(estudianteRepository.save(any())).thenReturn(null);

        Boolean validar = estudianteAdapter.crear(estudiante);
        assertTrue(validar);
    }

    @Test
    void editar() throws  Exception{
        Estudiante estudiante = new Estudiante();

        EstudianteEntity estudianteE = new EstudianteEntity();
        estudianteE.setId(1L);

        Estado estado = new Estado();
        estado.setId(1L);
        estudiante.setEstado(estado);

        ZonaHoraria zonaHoraria = new ZonaHoraria();
        zonaHoraria.setId(1L);
        estudiante.setZonaHoraria(zonaHoraria);

        when(estudianteRepository.findById(any())).thenReturn(Optional.of(estudianteE));
        when(estudianteRepository.save(any())).thenReturn(null);
        Boolean validar = estudianteAdapter.editar(estudiante);
        assertTrue(validar);

    }

    @Test
    void consultarPorID() throws  Exception{
        EstudianteEntity estudianteE = new EstudianteEntity();
        estudianteE.setId(1L);

        EstadoEntity estado = new EstadoEntity();
        estado.setIdEstado(1L);
        estudianteE.setIdEstado(estado);

        ZonaHorariaEntity zonaHoraria = new ZonaHorariaEntity();
        zonaHoraria.setIdZonaHoraria(1L);
        estudianteE.setIdZonaHoraria(zonaHoraria);

        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(estudianteE));

        Estudiante estudianteValidar = estudianteAdapter.consultarPorID(1L);
        assertEquals(estudianteValidar.getId(),1L);
    }

    @Test
    void consultarTodos() throws  Exception{
        EstudianteEntity estudianteE = new EstudianteEntity();
        estudianteE.setId(1L);

        EstadoEntity estado = new EstadoEntity();
        estado.setIdEstado(1L);
        estudianteE.setIdEstado(estado);

        ZonaHorariaEntity zonaHoraria = new ZonaHorariaEntity();
        zonaHoraria.setIdZonaHoraria(1L);
        estudianteE.setIdZonaHoraria(zonaHoraria);

        List<EstudianteEntity> listaEstudiante = new ArrayList();
        listaEstudiante.add(estudianteE);
        when(estudianteRepository.findAll()).thenReturn(listaEstudiante);

        List<Estudiante> listaValidar = estudianteAdapter.consultarTodos();
        assertEquals(listaValidar.get(0).getId(),1L);

    }

    @Test
    void asignarExamen() throws  Exception{
        EstudianteEntity estudianteE = new EstudianteEntity();
        estudianteE.setId(1L);

        EstadoEntity estado = new EstadoEntity();
        estado.setIdEstado(1L);
        estudianteE.setIdEstado(estado);

        ZonaHorariaEntity zonaHoraria = new ZonaHorariaEntity();
        zonaHoraria.setIdZonaHoraria(1L);
        zonaHoraria.setZonaHoraria("America/Bogota");
        estudianteE.setIdZonaHoraria(zonaHoraria);

        ExamenEntity examenEntity = new ExamenEntity();
        examenEntity.setFechaExamen("2024-02-12 12:30:00");
        when(examenRepository.findById(1L)).thenReturn(Optional.of(examenEntity));
        when(estudianteRepository.findById(1L)).thenReturn(Optional.of(estudianteE));
        when(estudianteExamenRepository
                .findExamenEstudianteByEstudianteAndExamen(1L,1L)).thenReturn(null);
        when(estudianteExamenRepository.save(any())).thenReturn(null);
        Boolean validar = estudianteAdapter.asignarExamen(1L,1L);
        assertTrue(validar);
    }

    @Test
    void realizarExamen() throws  Exception{

        EstudianteEntity estudianteEntity = new EstudianteEntity();
        EstudianteExamenCEntity estudianteExamenEntity = new EstudianteExamenCEntity();
        when(estudianteRepository.findByIdAndPregunta(1L, 1L)).thenReturn(estudianteEntity);
        when(estudianteRepository.findExamenByIdAndPregunta(1L, 1L)).thenReturn(1L);
        when(estudianteExamenRepository.findById(1L)).thenReturn(Optional.of(estudianteExamenEntity));
        when(estudianteRepository.validateStatus(1L, 1L)).thenReturn(estudianteEntity);
        when(respuestasRepository.findRespuestaByEstudiante
                (1L, 1L)).thenReturn(0);
        when(respuestasRepository.save(any())).thenReturn(null);

        Respuestas respuestas =  new Respuestas();
        respuestas.setRespuesta(1L);
        respuestas.setEstudiante(1L);
        respuestas.setPregunta(1L);
        Boolean validar = estudianteAdapter.realizarExamen(respuestas);
        assertTrue(validar);

    }

}
