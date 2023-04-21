package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class ProductoServicioImp implements ProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    @Override
    public Long actualizarProductoEstado(Long idProducto, EstadoProducto estadoProducto) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("El producto no existe.");
        producto.setEstadoProducto(estadoProducto);
        return productoRepo.save(producto).getIdProducto();
    }
    @Override
    public List<ProductoGetDTO> listarProductos(int page) {
        List<Producto> productos = productoRepo.listarProductos(paginar(0));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public List<ProductoGetDTO> listarProductosBusqueda(String busqueda, int page) {
        Pageable pageable = PageRequest.of(page,20);
        List<Producto> productos = productoRepo.listarProductosBusqueda(busqueda, pageable);
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public List<ProductoGetDTO> listarProductosBusquedaOrdPrecioAsc(String busqueda, int page) {
        List<Producto> productos = productoRepo.listarProductosBusquedaOrdPrecioAsc(busqueda, paginar(page));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public List<ProductoGetDTO> listarProductosBusquedaOrdPrecioDesc(String busqueda, int page) {
        List<Producto> productos = productoRepo.listarProductosBusquedaOrdPrecioDesc(busqueda, paginar(page));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public List<ProductoGetDTO> listarProductosBusquedaOrdFechaAsc(String busqueda, int page) {
        List<Producto> productos = productoRepo.listarProductosBusquedaOrdFechaAsc(busqueda, paginar(page));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public List<ProductoGetDTO> listarProductosBusquedaOrdFechaDesc(String busqueda, int page) {
        List<Producto> productos = productoRepo.listarProductosBusquedaOrdFechaDesc(busqueda, paginar(page));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    //PENDIENTE
    @Override
    public List<ProductoGetDTO> listarProductosBusquedaOrdCalDesc(String busqueda, int page) {
        List<Object[]> productosCalificados = productoRepo.listarCalificaciones(busqueda, paginar(page));
        List<Producto> productos = new ArrayList<>();
        for (Object[] productoCalificado: productosCalificados) {
            Producto producto = (Producto) productoCalificado[0];
            productos.add(producto);
        }
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public List<ProductoGetDTO> listarProductosEstado(EstadoProducto estadoProducto, int page) {
        List<Producto> productos = productoRepo.listarProductosEstado(estadoProducto, paginar(page));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public List<ProductoGetDTO> listarProductosCategorias(Categoria categoria, int page) {
        List<Producto> productos = productoRepo.listarProductosCategoria(categoria, paginar(page));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public boolean marcarFavorito(Long idUsuario, Long idProducto) throws Exception{
        Usuario usuario = usuarioServicio.obtenerUsuarioObj(idUsuario);
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        return usuario.getFavoritos().add(producto);
    }
    @Override
    public Set<ProductoGetDTO> listarFavoritos(Long idUsuario) throws Exception {
        Usuario usuario = usuarioServicio.obtenerUsuarioObj(idUsuario);
        if (usuario == null)
            throw new Exception("El usuario no existe.");
        Set<Producto> favoritos = usuario.getFavoritos();
        Set<ProductoGetDTO> favoritosGetDTO = listarFavoritosDTO(favoritos);
        return favoritosGetDTO;
    }

    @Override
    public Long crearProducto(ProductoDTO productoDTO) throws Exception {
        Producto producto = convertirDTO(productoDTO);
        return productoRepo.save(producto).getIdProducto();
    }

    @Override
    public Long actualizarProducto(Long idProducto, ProductoDTO productoDTO) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("El producto no existe.");
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setImagenes(productoDTO.getImagenes());
        producto.setFechaLimite(productoDTO.getFechaLimite());
        producto.setCategorias(productoDTO.getCategoriasList());
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
    private Pageable paginar(int page){
        Pageable pageable = PageRequest.of(page, 20);
        return pageable;
    }
    private Producto convertirDTO(ProductoDTO productoDTO) throws Exception{
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setImagenes(productoDTO.getImagenes());
        producto.setFechaLimite(productoDTO.getFechaLimite());
        producto.setFechaCreacion(LocalDate.now());
        producto.setEstadoProducto(EstadoProducto.PENDIENTE);
        producto.setUnidades(9);
        producto.setCategorias(productoDTO.getCategoriasList());
        producto.setUsuario(usuarioServicio.obtenerUsuarioObj(productoDTO.getIdUsuario()));
        return producto;
    }

    private Set<ProductoGetDTO> listarFavoritosDTO(Set<Producto> productos){
        Set<ProductoGetDTO> productosGetDTO = new HashSet<>();
        for (Producto producto : productos) {
            ProductoGetDTO productoAux = new ProductoGetDTO();
            productoAux.setIdProducto(producto.getIdProducto());
            productoAux.setNombre(producto.getNombre());
            productoAux.setDescripcion(producto.getDescripcion());
            productoAux.setEstadoProducto(producto.getEstadoProducto());
            productoAux.setPrecio(producto.getPrecio());
            productoAux.setUnidades(producto.getUnidades());
            productoAux.setFechaCreacion(producto.getFechaCreacion());
            productoAux.setFechaLimite(producto.getFechaLimite());
            productoAux.setCategorias(producto.getCategorias());
            productosGetDTO.add(productoAux);
        }
        return productosGetDTO;
    }
    private List<ProductoGetDTO> listarDTO(List<Producto> productos){
        List<ProductoGetDTO> productosGetDTO = new ArrayList<>();
        for (Producto producto : productos) {
            ProductoGetDTO productoAux = new ProductoGetDTO();
            productoAux.setIdProducto(producto.getIdProducto());
            productoAux.setNombre(producto.getNombre());
            productoAux.setDescripcion(producto.getDescripcion());
            productoAux.setEstadoProducto(producto.getEstadoProducto());
            productoAux.setPrecio(producto.getPrecio());
            productoAux.setUnidades(producto.getUnidades());
            productoAux.setFechaCreacion(producto.getFechaCreacion());
            productoAux.setFechaLimite(producto.getFechaLimite());
            productoAux.setCategorias(producto.getCategorias());
            productosGetDTO.add(productoAux);
        }
        return productosGetDTO;
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