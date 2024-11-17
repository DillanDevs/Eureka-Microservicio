package co.com.asprilla.curso_service.repository;

import co.com.asprilla.curso_service.models.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
