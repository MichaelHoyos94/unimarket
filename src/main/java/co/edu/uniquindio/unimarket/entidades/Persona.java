package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import java.io.Serializable;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public abstract class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long idPersona;
    @Column(length = 50, nullable = false)
    @ToString.Include
    private String nombre;
    @Column(length = 11, nullable = false, unique = true)
    @ToString.Include
    private String cedula;
    @Email
    @Column(length = 100, nullable = false, unique = true)
    @ToString.Include
    private String email;
    @Column(nullable = false)
    private String password;
}