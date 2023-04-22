package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    @NotNull
    @NotBlank(message = "El producto debe tener un nombre.")
    private String nombre;
    @NotNull
    @Positive
    private int unidades;
    @NotNull
    private String descripcion;
    @NotNull
    @Positive
    private double precio;
    @NotNull
    private HashMap<String,String> imagenes;
    @NotNull
    private LocalDate fechaLimite;
    @NotNull
    private Long idUsuario;
    @NotNull
    private List<Categoria> categoriasList;
}
