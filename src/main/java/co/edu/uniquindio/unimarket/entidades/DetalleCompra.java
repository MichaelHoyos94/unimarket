package co.edu.uniquindio.unimarket.entidades;

import java.io.Serializable;
import jakarta.persistence.*;
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
public class DetalleCompra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleCompra;
    private int unidades;
    private double precio;
    @ManyToOne
    private Compra compra;
    @ManyToOne
    private Producto producto;
}
