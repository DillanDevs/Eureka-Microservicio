package co.com.asprilla.user_service.Service;

import co.com.asprilla.entitylibrary.models.entity.Alumno;
import co.com.asprilla.libreria.service.CommonService;

public interface AlumnoService extends CommonService<Alumno> {
    Alumno save(Alumno alumno);
    void deleteById(Long id);
}
