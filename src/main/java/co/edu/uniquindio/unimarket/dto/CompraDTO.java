package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.MetodoPago;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    @NotNull
    private  Long idUsuario;
    @NotNull
    @NotEmpty
        private List<DetalleCompraDTO> detalleCompras;
    @NotNull
    private MetodoPago metodoPago;
}