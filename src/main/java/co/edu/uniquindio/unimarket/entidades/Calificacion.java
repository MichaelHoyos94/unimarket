package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalificacion;
    private float calificacion;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Producto producto;
}