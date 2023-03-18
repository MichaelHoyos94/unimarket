package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Puja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuja;
    @PositiveOrZero
    private double valorPuja;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Subasta subasta;
}
