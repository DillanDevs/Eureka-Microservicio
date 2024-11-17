package co.com.asprilla.curso_service.service;

import co.com.asprilla.curso_service.models.entity.Curso;
import co.com.asprilla.curso_service.repository.CursoRepository;
import co.com.asprilla.libreria.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

    public CursoServiceImpl(CursoRepository cursoRepository) {
        super(cursoRepository);
    }

}
