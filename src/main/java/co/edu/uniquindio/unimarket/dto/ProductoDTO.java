package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private String nombre;
    private String descripcion;
    private double precio;
    private Map<String,String> imagenes;
    private LocalDate fechaLimite;
    private Long idUsuario;
    private List<Categoria> categoriasList;
}
