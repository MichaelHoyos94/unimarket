package co.edu.uniquindio.unimarket.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioGetDTO {
    private Long idUsuario;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    @ToString.Exclude
    private String password;
}
