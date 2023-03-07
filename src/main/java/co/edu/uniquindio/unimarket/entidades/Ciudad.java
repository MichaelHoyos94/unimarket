package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Ciudad implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;
    @Column(length = 20, nullable = false, unique = true)
    private String nombreCiudad;
}
