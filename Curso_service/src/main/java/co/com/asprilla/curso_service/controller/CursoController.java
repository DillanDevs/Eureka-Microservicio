package co.com.asprilla.curso_service.controller;

import co.com.asprilla.curso_service.models.entity.Curso;
import co.com.asprilla.curso_service.service.CursoService;
import co.com.asprilla.entitylibrary.models.entity.Alumno;
import co.com.asprilla.libreria.controller.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController extends CommonController<Curso, CursoService> {

    private final CursoService service;

    public CursoController(CursoService service) {
        super(service);
        this.service = service;
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody Curso curso, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Curso cursoDb = ob.get();
        cursoDb.setNombre(curso.getNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

    @PutMapping("/{id}/add-alumno")
    public ResponseEntity<?> addAlumno(@RequestBody List<Alumno> alumno, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Curso cursoDb = ob.get();
        alumno.forEach(cursoDb::addAlumnos);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

    @PutMapping("/{id}/remove-alumno")
    public ResponseEntity<?> removeAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Curso cursoDb = ob.get();
        cursoDb.removeAlumnos(alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
    }

}
