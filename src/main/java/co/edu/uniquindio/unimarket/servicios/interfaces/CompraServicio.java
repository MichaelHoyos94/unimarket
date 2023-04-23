package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CompraServicio {

    Long crearCompra (CompraDTO compraDTO) throws Exception;
    List<CompraGetDTO> listarCompras (Long idUsuario) throws Exception;
    Compra obtenerCompraObj(Long idCompra) throws Exception;
}