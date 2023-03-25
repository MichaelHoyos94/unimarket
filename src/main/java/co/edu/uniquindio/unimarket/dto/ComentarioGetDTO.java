package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComentarioGetDTO {
    private Long idComentario;
    private String comentario;
    private LocalDate fecha;
    private Long idUsuario;
    private Long idProducto;
}
