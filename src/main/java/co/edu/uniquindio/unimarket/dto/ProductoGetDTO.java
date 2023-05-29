package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductoGetDTO {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private EstadoProducto estadoProducto;
    private int unidades;
    private double precio;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    private List<Categoria> categorias;
    private Map<String, String> imagenes;
    private String usuarioCreacion;
}