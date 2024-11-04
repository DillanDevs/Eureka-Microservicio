package co.com.asprilla.user_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nombre;
    private String apellido;
    private String email;

    @Column(name = "create_at")
    private Date createAt;

    @PrePersist
    private void prePersist() {
        this.createAt = new Date();
    }

}
