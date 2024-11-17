package co.com.asprilla.entitylibrary.models.entity;

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

    @Override
    public boolean equals (Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Alumno)){
            return false;
        }
        Alumno a = (Alumno) obj;
        return this.Id != null && this.Id.equals(a.getId());
    }


}
