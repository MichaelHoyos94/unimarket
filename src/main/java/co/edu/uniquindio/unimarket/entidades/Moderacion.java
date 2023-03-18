package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Moderacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Moderador moderador;
    @ManyToOne
    private Producto producto;
    @Enumerated(value = EnumType.STRING)
    private EstadoProducto estadoProducto;
}