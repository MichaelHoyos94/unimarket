package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoServicioImp implements ProductoServicio{
    private final ProductoRepo productoRepo;
    @Override
    public Producto obtenerProductoObj(Long idProducto) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("No existe el producto");
        return producto;
    }
}