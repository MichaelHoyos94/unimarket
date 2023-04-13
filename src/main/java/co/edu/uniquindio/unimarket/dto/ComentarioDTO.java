package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {
    @NotNull
    @NotBlank
    @Length(min = 5, max = 120, message = "El comentario debe tener entre 5 y 120 caracteres.")
    private String comentario;
    private Long idUsuario;
    private Long idProducto;
}
