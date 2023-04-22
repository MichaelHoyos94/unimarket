package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubastaDTO {
    @NotNull
    @NotBlank
    @Length(min = 5, max = 120, message = "El nombre del producto debe tener entre 5 y 120 caracteres.")
    private String nombreProducto;
    private LocalDate fechaLimite;
    @NotNull
    @PositiveOrZero
    private double valorInicial;
    private String descripcion;
    private Long idUsuario;
}