package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalificacionDTO {
    @NotNull
    @NotBlank
    @Min(1)
    @Max(5)
    private float calificacion;
    private Long idUsuario;
    private Long idProducto;
}