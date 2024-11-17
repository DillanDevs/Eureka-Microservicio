package co.com.asprilla.curso_service.models.entity;

import co.com.asprilla.entitylibrary.models.entity.Alumno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Getter
    @OneToMany(fetch = FetchType.LAZY)
    private List<Alumno> listaAlumno;

    public void addAlumnos(Alumno alumno) {
        this.listaAlumno.add(alumno);
    }

    public void removeAlumnos(Alumno alumno) {
        this.listaAlumno.remove(alumno);
    }

    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
    }
}


