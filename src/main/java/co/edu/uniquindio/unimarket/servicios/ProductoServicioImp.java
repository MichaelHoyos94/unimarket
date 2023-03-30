package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoServicioImp implements ProductoServicio{
    private final ProductoRepo productoRepo;

    @Override
    public Long actualizarProductoEstado(Long idProducto, EstadoProducto estadoProducto) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("El producto no existe.");
        producto.setEstadoProducto(estadoProducto);
        return productoRepo.save(producto).getIdProducto();
    }

    @Override
    public ProductoGetDTO obtenerProductoId(Long idProducto) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("El producto no existe");
        ProductoGetDTO productoGetDTO = convertirObj(producto);
        return productoGetDTO;
    }
    @Override
    public Producto obtenerProductoObj(Long idProducto) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("No existe el producto");
        return producto;
    }
    private ProductoGetDTO convertirObj(Producto producto){
        ProductoGetDTO productoGetDTO = new ProductoGetDTO();
        productoGetDTO.setIdProducto(producto.getIdProducto());
        productoGetDTO.setNombre(producto.getNombre());
        productoGetDTO.setDescripcion(producto.getDescripcion());
        productoGetDTO.setEstadoProducto(producto.getEstadoProducto());
        productoGetDTO.setUnidades(producto.getUnidades());
        productoGetDTO.setPrecio(producto.getPrecio());
        productoGetDTO.setFechaCreacion(producto.getFechaCreacion());
        productoGetDTO.setFechaLimite(producto.getFechaLimite());
        productoGetDTO.setCategorias(producto.getCategorias());
        return productoGetDTO;
    }
}