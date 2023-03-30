package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
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
public class Subasta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubasta;
    private String nombreProducto;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    @PositiveOrZero
    private double valorInicial;
    private String descripcion;
    private Boolean estado;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "subasta")
    private List<Puja> pujas;
}