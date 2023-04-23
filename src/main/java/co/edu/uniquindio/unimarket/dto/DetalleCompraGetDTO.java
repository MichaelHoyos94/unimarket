package co.edu.uniquindio.unimarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCompraGetDTO {

    private long idDetalleCompra;

    private Long idProducto;

    private Long idCompra;

    private int unidades;

    private double precio;

}