package infraestructura.calificacion.config;

import aplicacion.calificacion.casodeuso.ConsultarCalificacionUseCaseImpl;
import aplicacion.calificacion.casodeuso.ConsultarTodosCalificacionUseCaseImpl;
import aplicacion.calificacion.casodeuso.CrearCalificacionUseCaseImpl;
import aplicacion.calificacion.servicio.ServicioTareaCalificacion;
import dominio.resultados.ports.out.CalificacionRepositoryPort;
import infraestructura.calificacion.adapter.CalificacionAdapter;
import infraestructura.calificacion.repository.CalificacionRepository;
import infraestructura.calificacion.repository.EstudianteExamenCRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalificacionApplicationConfig {

    @Bean
    public ServicioTareaCalificacion servicioTareaCalificacion(CalificacionRepositoryPort calificacionRepositoryPort){
        return new ServicioTareaCalificacion(
                new CrearCalificacionUseCaseImpl(calificacionRepositoryPort),
                new ConsultarTodosCalificacionUseCaseImpl(calificacionRepositoryPort),
                new ConsultarCalificacionUseCaseImpl(calificacionRepositoryPort)
        );
    }

    @Bean
    public CalificacionRepositoryPort calificacionRepositoryPort(CalificacionAdapter calificacionAdapter){
        return calificacionAdapter;
    }

    @Bean
    public CalificacionAdapter calificacionAdapter(CalificacionRepository calificacionRepository,
                                                   EstudianteExamenCRepository estudianteExamenCRepository){
        return new CalificacionAdapter(calificacionRepository, estudianteExamenCRepository);

    }

}
