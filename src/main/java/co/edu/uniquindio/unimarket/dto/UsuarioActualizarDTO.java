package co.edu.uniquindio.unimarket.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioActualizarDTO {
    @NotNull
    @NotBlank
    @Length(max = 120, message = "El nombre no debe exceder 120 caracteres.")
    private String nombre;
    @NotNull
    @NotBlank
    @Email(message = "Por favor, introduzca un correo valido.")
    @Length(max = 120, message = "El correo no debe exceder 120 caracteres.")
    private String email;
    @NotNull
    @NotBlank
    @Length(min = 7, max = 10, message = "Introduzca un numero de cedula valido.")
    private String cedula;
    @NotNull
    @NotBlank
    private String ciudad;
    @NotNull
    @NotBlank
    private String direccion;
    @NotNull
    @NotBlank
    private String telefono;
}
