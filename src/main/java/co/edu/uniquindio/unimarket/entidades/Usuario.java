package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Usuario extends Persona implements Serializable {
    @Column(length = 10, nullable = false, unique = true)
    @ToString.Include
    private String telefono;
    @ToString.Include
    @Column(length = 20, nullable = false)
    private String ciudad;
    @Column(length = 100, nullable = false)
    @ToString.Include
    private String direccion;
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos; //Publicados
    @ManyToMany
    @JoinTable(name = "favoritos")
    private Set<Producto> favoritos; //Favoritos
    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;
    @OneToMany(mappedBy = "usuario")
    private List<Puja> pujas;
    @OneToMany(mappedBy = "usuario")
    private List<Subasta> subastas;
    @OneToMany(mappedBy = "usuario")
    private List<Calificacion> calificaciones;
}