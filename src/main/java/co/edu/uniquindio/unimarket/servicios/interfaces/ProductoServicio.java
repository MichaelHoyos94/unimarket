package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.entidades.Producto;

public interface ProductoServicio {
    Long actualizarProductoEstado(Long idProducto, EstadoProducto estadoProducto) throws Exception;
    /**
     *     crearProducto();
     *     eliminarProducto();
     *     actualizarProducto();
     *     actualizarProductoCantidades();
     *     listarProductosCategoria();
     *     listarProductosUsuario();
     *     listarProductosEstado();
     *     listarProductosNombre();
     *     listarProductosPrecio();
     *     listarProductoCodigo();
     */
    ProductoGetDTO obtenerProductoId(Long idProducto) throws Exception;
    Producto obtenerProductoObj(Long idProducto) throws Exception;
}