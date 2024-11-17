package co.com.asprilla.user_service.Service;

import co.com.asprilla.entitylibrary.models.entity.Alumno;
import co.com.asprilla.libreria.service.CommonServiceImpl;
import co.com.asprilla.user_service.Repository.AlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        super(alumnoRepository);
    }
}
