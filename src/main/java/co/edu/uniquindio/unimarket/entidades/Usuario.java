package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Usuario extends Persona implements Serializable {
    @Column(length = 10, nullable = false, unique = true)
    private String telefono;
    @Column(length = 20, nullable = false)
    private String ciudad;
    @Column(length = 100, nullable = false)
    private String direccion;
    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos; //Publicados
    @ManyToMany
    @JoinTable(name = "favoritos")
    private List<Producto> favoritos; //Favoritos
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