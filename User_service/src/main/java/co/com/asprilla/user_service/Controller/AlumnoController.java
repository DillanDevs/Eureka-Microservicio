package co.com.asprilla.user_service.Controller;

import co.com.asprilla.user_service.Entity.Alumno;
import co.com.asprilla.user_service.Service.AlumnoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AlumnoController {

    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @Value("${config.balanaceador.test}")
    private String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceadorTest", balanceadorTest);
        response.put("alumnos", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<?> ver(@PathVariable Long id) {

        Optional <Alumno> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ob.get());

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Alumno alumno) {
        Alumno alumnoDb = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Alumno alumnoDb = ob.get();
        alumnoDb.setNombre(alumno.getNombre());
        alumnoDb.setApellido(alumno.getApellido());
        alumnoDb.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDb));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
