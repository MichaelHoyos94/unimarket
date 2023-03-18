package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

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
    @NumberFormat
    @PositiveOrZero
    private int unidades;
    @Column(length = 100, nullable = true)
    private String descripcion;
    @Column(nullable = false)
    @PositiveOrZero
    private double precio;
    @ElementCollection
    @Column(nullable = false)
    private HashMap<String, String> imagenes;
    @Column(nullable = false)
    private LocalDate fechaCreacion;
    @Column(nullable = false)
    private LocalDate fechaLimite;
    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Categoria> categorias;
    @Enumerated(value = EnumType.STRING)
    private EstadoProducto estadoProducto;
    @OneToMany(mappedBy = "producto")
    private List<Comentario> comentarios;
    @OneToOne(mappedBy = "producto")
    private Subasta subasta;
    @ManyToOne
    private Usuario usuario; //El que lo publica
    @ManyToMany(mappedBy = "favoritos")
    private List<Usuario> usuarios; //Los usuarios que marcan el producto como favorito.
    @OneToMany(mappedBy = "producto")
    private List<Calificacion> calificaciones;
    @OneToMany(mappedBy = "producto")
    private List<Moderacion> moderaciones;
}