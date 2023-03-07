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
public class MetodoPago implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodoPago;
    @Column(length = 20, nullable = false, unique = true)
    private String nombreMetodoPago;
}
