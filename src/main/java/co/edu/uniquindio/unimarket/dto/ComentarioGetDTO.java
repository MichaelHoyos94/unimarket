package co.edu.uniquindio.unimarket.dto;

import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ComentarioGetDTO {
    private Long idComentario;
    private String comentario;
    private LocalDate fecha;
    private Long idUsuario;
    private Long idProducto;
}
