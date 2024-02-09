package infraestructura.examen.config;

import aplicacion.examen.casodeuso.examen.ConsultarExamenUseCaseImpl;
import aplicacion.examen.casodeuso.examen.ConsultarTodosExamenUseCaseImpl;
import aplicacion.examen.casodeuso.examen.CrearExamenUseCaseImpl;
import aplicacion.examen.casodeuso.examen.EditarExamenUseCaseImpl;
import aplicacion.examen.casodeuso.opcion.CrearOpcionUseCaseImpl;
import aplicacion.examen.casodeuso.opcion.EditarOpcionUseCaseImpl;
import aplicacion.examen.casodeuso.pregunta.CrearPreguntaUseCaseImpl;
import aplicacion.examen.casodeuso.pregunta.EditarPreguntaUseCaseImpl;
import aplicacion.examen.servicio.ServicioTareaExamen;
import aplicacion.examen.servicio.ServicioTareaOpcion;
import aplicacion.examen.servicio.ServicioTareaPregunta;
import dominio.examen.ports.out.ExamenRepositoryPort;
import dominio.examen.ports.out.OpcionRepositoryPort;
import dominio.examen.ports.out.PreguntaRepositoryPort;
import infraestructura.examen.adapter.ExamenAdapter;
import infraestructura.examen.adapter.OpcionAdapter;
import infraestructura.examen.adapter.PreguntaAdapter;
import infraestructura.examen.repository.ExamenRepository;
import infraestructura.examen.repository.OpcionRepository;
import infraestructura.examen.repository.PreguntaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamenApplicationConfig {


    //Examen
    @Bean
    public ServicioTareaExamen servicioTareaExamen(ExamenRepositoryPort examenRepositoryPort){
        return new ServicioTareaExamen(
                new CrearExamenUseCaseImpl(examenRepositoryPort),
                new ConsultarTodosExamenUseCaseImpl(examenRepositoryPort),
                new ConsultarExamenUseCaseImpl(examenRepositoryPort),
                new EditarExamenUseCaseImpl(examenRepositoryPort)

        );
    }

    @Bean
    public ExamenRepositoryPort examenRepositoryPort(ExamenAdapter examenAdapter){
        return examenAdapter;
    }

    @Bean
    public ExamenAdapter examenAdapterPort(ExamenRepository examenRepository){
        return new ExamenAdapter(examenRepository);
    }

    //Pregunta
    @Bean
    public ServicioTareaPregunta servicioTareaPregunta(PreguntaRepositoryPort preguntaRepositoryPort){
        return new ServicioTareaPregunta(
                new CrearPreguntaUseCaseImpl(preguntaRepositoryPort),
                new EditarPreguntaUseCaseImpl(preguntaRepositoryPort)

        );
    }

    @Bean
    public PreguntaRepositoryPort preguntaRepositoryPort(PreguntaAdapter preguntaAdapter){
        return preguntaAdapter;
    }

    @Bean
    public PreguntaAdapter preguntaAdapterPort(PreguntaRepository preguntaRepository, ExamenRepository examenRepository){
        return new PreguntaAdapter(preguntaRepository,examenRepository );
    }

    //Opcion
    @Bean
    public ServicioTareaOpcion servicioTareaOpcion(OpcionRepositoryPort opcionRepositoryPort){
        return new ServicioTareaOpcion(
                new CrearOpcionUseCaseImpl(opcionRepositoryPort),
                new EditarOpcionUseCaseImpl(opcionRepositoryPort)

        );
    }

    @Bean
    public OpcionRepositoryPort opcionRepositoryPort(OpcionAdapter opcionAdapter){
        return opcionAdapter;
    }

    @Bean
    public OpcionAdapter opcionAdapterPort(OpcionRepository opcionRepository, PreguntaRepository preguntaRepository){
        return new OpcionAdapter(opcionRepository,preguntaRepository );
    }


}
