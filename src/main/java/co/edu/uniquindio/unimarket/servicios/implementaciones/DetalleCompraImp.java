package co.edu.uniquindio.unimarket.servicios.implementaciones;


import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DetalleCompraImp  implements DetalleCompraServicio {

    private final ProductoServicio productoServicio;

    @Override
    public double crearDetalleCompra(List<DetalleCompraDTO> listaDetalleCompra, Compra compra) throws Exception {
        List<DetalleCompra> detalleCompraList = new ArrayList<>();
         Double totalCompra = 0.0;

        for (DetalleCompraDTO dt: listaDetalleCompra) {
            DetalleCompra detalle = new DetalleCompra();
            detalle.setCompra(compra);
            detalle.setProducto(productoServicio.obtenerProductoObj(dt.getIdProducto()));
            detalle.setUnidades(dt.getUnidades());
            detalle.setPrecio(dt.getPrecio());

            totalCompra += detalle.getPrecio() * detalle.getUnidades();
            detalleCompraList.add(detalle);
        }

        return totalCompra;

    }
}
