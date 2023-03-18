package co.edu.uniquindio.unimarket.servicios;

public interface ProductoServicio {
    crearProducto(ProductoDTO productoDTO);
    eliminarProducto();
    actualizarProducto();
    actualizarProductoEstado();
    actualizarProductoCantidades();
    listarProductosCategoria();
    listarProductosUsuario();
    listarProductosEstado();
    listarProductosNombre();
    listarProductosPrecio();
    listarProductoCodigo();
}
