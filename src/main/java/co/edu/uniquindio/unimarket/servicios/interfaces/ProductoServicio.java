package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDetailGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;

import java.util.List;
import java.util.Set;

public interface ProductoServicio {
    Long actualizarProductoEstado(Long idProducto, EstadoProducto estadoProducto) throws Exception;
    List<ProductoGetDTO> listarProductos(int page);
    List<ProductoGetDTO> listarProductosBusqueda(String busqueda, String sort, int page);
    List<ProductoGetDTO> listarProductosEstado(EstadoProducto estadoProducto, int page);
    List<ProductoGetDTO> listarProductosCategorias(Categoria categoria, int page);
<<<<<<< HEAD
    void marcarFavorito(Long idUsuario, Long idProducto) throws Exception;
=======
    List<ProductoGetDTO> listarProductosUsuario(Long idUsuario, int page );
    boolean marcarFavorito(Long idUsuario, Long idProducto) throws Exception;
>>>>>>> 0dfd589fcedf4bece41cc5ca07e8fcb52ad0f9ef
    Set<ProductoGetDTO> listarFavoritos(Long idUsuario) throws Exception;
    Long crearProducto(ProductoDTO productoDTO) throws Exception;
    Long actualizarProducto(Long idProducto, ProductoDTO productoDTO) throws Exception;
    void eliminarProducto(Long idUsuario, Long idProducto) throws Exception;
<<<<<<< HEAD
    void actualizarProductoCantidades(Long idProducto, int cantSolicitada) throws Exception;
    /**
     *     listarProductosUsuario();
=======

    /**
     *     actualizarProductoCantidades(); VA EN LA COMPRA
     *
>>>>>>> 0dfd589fcedf4bece41cc5ca07e8fcb52ad0f9ef
     */
    ProductoDetailGetDTO obtenerProductoId(Long idProducto) throws Exception;
    Producto obtenerProductoObj(Long idProducto) throws Exception;

}