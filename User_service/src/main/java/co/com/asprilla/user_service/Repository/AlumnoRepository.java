package co.com.asprilla.user_service.Repository;

import co.com.asprilla.entitylibrary.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}