package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;

import java.util.List;

public interface DetalleCompraServicio {

    double crearDetalleCompra (List<DetalleCompraDTO> listaDetalleCompra, Compra compra) throws Exception;
}
