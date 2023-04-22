package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.Email;
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
public class RecuperarPassDTO {
    @NotNull
    @NotBlank(message = "El campo email es obligatorio.")
    @Email(message = "Ingrese un email valido.")
    private String email;
    @NotNull
    @NotBlank(message = "El campo password es obligatorio.")
    private String password;
    @NotNull
    @NotBlank(message = "Confirme el password.")
    private String passwordconfirm;
}