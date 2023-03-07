package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Publicacion implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacion;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Column(nullable = false)
    private LocalDate fechaLimite;
    @PositiveOrZero
    private int cantidadProducto;
}