package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public abstract class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long idPersona;
    @Column(length = 50, nullable = false)
    private String nombre;
    @Column(length = 50, nullable = false)
    private String apellido;
    @Column(length = 11, nullable = false, unique = true)
    private String cedula;
    @Email
    @Column(length = 100, nullable = false, unique = true)
    private String email;
    @Column(length = 10, nullable = false, unique = true)
    private String telefono;
    @Column(length = 100, nullable = false)
    private String direccion;
    @Column(length = 50, nullable = false)
    private String password;
}