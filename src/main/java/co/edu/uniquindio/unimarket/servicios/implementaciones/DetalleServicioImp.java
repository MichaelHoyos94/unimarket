package co.edu.uniquindio.unimarket.servicios.implementaciones;


import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.DetalleCompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DetalleServicioImp implements DetalleCompraServicio {
    private final DetalleCompraRepo detalleCompraRepo;
    private final ProductoServicio productoServicio;
    @Override
    public double crearDetalleCompra(List<DetalleCompraDTO> listaDetalleCompra, Compra compra) throws Exception {
        List<DetalleCompra> detalleCompraList = new ArrayList<>();
        Double totalCompra = 0.0;
        for (DetalleCompraDTO dt: listaDetalleCompra) {
            DetalleCompra detalle = new DetalleCompra();
            Producto producto = productoServicio.obtenerProductoObj(dt.getIdProducto());
            detalle.setCompra(compra);
            detalle.setProducto(producto);
            productoServicio.actualizarProductoCantidades(dt.getIdProducto(), dt.getUnidades());
            detalle.setUnidades(dt.getUnidades());
            detalle.setPrecio(dt.getUnidades() * producto.getPrecio());
            totalCompra += detalle.getPrecio();
            detalleCompraList.add(detalle);
        }
        detalleCompraRepo.saveAll(detalleCompraList);
        return totalCompra;
    }
}