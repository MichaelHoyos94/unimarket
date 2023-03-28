package co.edu.uniquindio.unimarket.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CalificacionGetDTO {
    private Long idCalificacion;
    private float calificacion;
    private Long idUsuario;
    private Long idProducto;
}
