package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Producto;

public interface ProductoServicio {
    /**
     *
     *     crearProducto();
     *     eliminarProducto();
     *     actualizarProducto();
     *     actualizarProductoEstado();
     *     actualizarProductoCantidades();
     *     listarProductosCategoria();
     *     listarProductosUsuario();
     *     listarProductosEstado();
     *     listarProductosNombre();
     *     listarProductosPrecio();
     *     listarProductoCodigo();
     */
    Producto obtenerProductoObj(Long idProducto) throws Exception;
}