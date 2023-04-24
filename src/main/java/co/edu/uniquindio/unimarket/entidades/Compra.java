package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Compra implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;
    private LocalDate fecha;
    private double precio;
    @ManyToOne
    private Usuario usuario;
    @Enumerated(value = EnumType.STRING)
    private MetodoPago metodoPago;
    @OneToMany(mappedBy = "compra")
    private List<DetalleCompra> detalle;
}