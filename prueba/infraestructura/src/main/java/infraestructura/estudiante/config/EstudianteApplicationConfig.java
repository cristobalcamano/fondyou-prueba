package infraestructura.estudiante.config;

import aplicacion.estudiante.casodeuso.*;
import aplicacion.estudiante.servicio.ServicioTareaEstudiante;
import dominio.estudiante.ports.out.EstudianteRepositoryPort;
import infraestructura.estudiante.adapter.EstudianteAdapter;
import infraestructura.estudiante.repository.EstudianteExamenRepository;
import infraestructura.estudiante.repository.EstudianteRepository;
import infraestructura.estudiante.repository.RespuestasRepository;
import infraestructura.examen.repository.ExamenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstudianteApplicationConfig {

    @Bean
    public ServicioTareaEstudiante servicioTareaEstudiante(EstudianteRepositoryPort estudianteRepositoryPort){
        return new ServicioTareaEstudiante(
                new CrearEstudianteUseCaseImpl(estudianteRepositoryPort),
                new EditarEstudianteUseCaseImpl(estudianteRepositoryPort),
                new ConsultarTodosEstidianteUseCaseImpl(estudianteRepositoryPort),
                new ConsultarEstudianteUseCaseImpl(estudianteRepositoryPort),
                new RealizarExamenUseCaseImpl(estudianteRepositoryPort),
                new AsignarExamenEstudianteUseCaseImpl(estudianteRepositoryPort)

        );
    }

    @Bean
    public EstudianteRepositoryPort estudianteRepositoryPort(EstudianteAdapter estudianteAdapter){
        return estudianteAdapter;
    }

    @Bean
    public EstudianteAdapter estudianteAdapterPort(EstudianteRepository estudianteRepository,
                                                   EstudianteExamenRepository estudianteExamenRepository,
                                                   ExamenRepository examenRepository,
                                                   RespuestasRepository respuestasRepository){
        return new EstudianteAdapter(estudianteRepository,estudianteExamenRepository, examenRepository, respuestasRepository);
    }

}
