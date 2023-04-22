package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModeracionDTO {
    @NotNull(message = "Ingrese el moderador.")
    private Long idModerador;
    @NotNull(message = "Ingrese el producto.")
    private Long idProducto;
    @NotNull
    private EstadoProducto estadoProducto;
}