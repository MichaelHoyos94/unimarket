package co.edu.uniquindio.unimarket.dto;

import co.edu.uniquindio.unimarket.entidades.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraGetDTO {

    private Long idCompra;

    private LocalDate fecha;

    private double precio;

    private  Long idUsuario;

    private List<DetalleCompraGetDTO> detalleComprasGet;

    private MetodoPago metodoPago;


}
