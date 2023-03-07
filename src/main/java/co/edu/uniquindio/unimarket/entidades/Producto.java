package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Producto implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    @Column(length = 30, nullable = false)
    private String nombre;
    @Column(nullable = true)
    private String imagen;
    @Column(nullable = true)
    private String descripcion;
    @Column(nullable = false)
    @PositiveOrZero
    private double precio;
}