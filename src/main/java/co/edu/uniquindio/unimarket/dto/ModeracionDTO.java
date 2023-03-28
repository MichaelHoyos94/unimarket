package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModeracionDTO {
    private Long idModerador;
    private Long idProducto;
    private EstadoProducto estadoProducto;
}
