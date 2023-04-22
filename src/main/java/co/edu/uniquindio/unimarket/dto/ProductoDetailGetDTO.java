package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductoDetailGetDTO {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private EstadoProducto estadoProducto;
    private int unidades;
    private double precio;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    private List<Categoria> categorias;
    private List<ComentarioGetDTO> comentarios;
    private List<CalificacionGetDTO> calificaciones;
}
