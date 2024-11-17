package co.com.asprilla.libreria.controller;

import co.com.asprilla.libreria.service.CommonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommonController<E, S extends CommonService<E>> {

    private final S service;

    public CommonController(S service) {
        this.service = service;
    }

    @Value("${config.balanceador.test}")
    protected String balanceadorTest;

    @GetMapping("/balanceador-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<>();
        response.put("balanceadorTest", balanceadorTest);
        response.put("alumnos", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {

        Optional <E> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ob.get());

    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody E entity) {
        E entityDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
    }

    @DeleteMapping("/eliminar/{id}")
    protected ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
