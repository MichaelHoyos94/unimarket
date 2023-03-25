package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    private String nombre;
    private String email;
    private String cedula;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String password;
}