package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDetailGetDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
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
    private final ComentarioServicio comentarioServicio;
    private final CalificacionServicio calificacionServicio;
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
    public List<ProductoGetDTO> listarProductosBusqueda(String busqueda, String sort, int page) {
        List<Producto> productos = consultarProductos(busqueda, sort, page);
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
    public List<ProductoGetDTO> listarProductosUsuario(Long idUsuario, int page) {
        List<Producto> productos = productoRepo.listarProductosPorUsuario(idUsuario, paginar(page));
        List<ProductoGetDTO> productosGetDTO = listarDTO(productos);
        return productosGetDTO;
    }
    @Override
    public void marcarFavorito(Long idUsuario, Long idProducto) throws Exception{
        Usuario usuario = usuarioServicio.obtenerUsuarioObj(idUsuario);
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        usuario.getFavoritos().add(producto);
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
    public void eliminarProducto(Long idUsuario, Long idProducto) throws Exception {
        Producto producto = productoRepo.obtenerProductoIdProductoIdUsuario(idProducto, idUsuario);
        if (producto == null)
            throw new Exception("Algo ha ido mal, puede que el producto no exista o no sea tuyo.");
        producto.setEstadoProducto(EstadoProducto.FINALIZADO);
        productoRepo.save(producto);
    }

<<<<<<< HEAD
    @Override
    public void actualizarProductoCantidades(Long idProducto, int cantSolicitada) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("El producto no existe");
        if (producto.getUnidades() < cantSolicitada)
            throw new Exception("No hay suficientes unidades de: " + producto.getNombre());
        producto.setUnidades(producto.getUnidades() - cantSolicitada);
        productoRepo.save(producto);
    }
=======
>>>>>>> 0dfd589fcedf4bece41cc5ca07e8fcb52ad0f9ef

    @Override
    public ProductoDetailGetDTO obtenerProductoId(Long idProducto) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("El producto no existe");
        ProductoDetailGetDTO productoDetailGetDTO = convertirObjDetail(producto);
        return productoDetailGetDTO;
    }
    @Override
    public Producto obtenerProductoObj(Long idProducto) throws Exception {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        if (producto == null)
            throw new Exception("No existe el producto");
        return producto;
    }
    private List<Producto> consultarProductos(String busqueda, String sort, int page) {
        if (sort != null){
            if (sort.equalsIgnoreCase("fechaAsc"))
                return productoRepo.listarProductosBusquedaOrdFechaAsc(busqueda, paginar(page));
            if (sort.equalsIgnoreCase("fechaDesc"))
                return productoRepo.listarProductosBusquedaOrdFechaDesc(busqueda, paginar(page));
            if (sort.equalsIgnoreCase("precioAsc"))
                return productoRepo.listarProductosBusquedaOrdPrecioAsc(busqueda, paginar(page));
            if (sort.equalsIgnoreCase("precioDesc"))
                return productoRepo.listarProductosBusquedaOrdPrecioDesc(busqueda, paginar(page));
        }
        /*if (sort == "calAsc")
            return productoRepo.listarCalificaciones(busqueda, paginar(page)); PENDIENTE*/
        return productoRepo.listarProductosBusqueda(busqueda, paginar(page));
    }
    private Pageable paginar(int page){
        Pageable pageable = PageRequest.of(page, 20);
        return pageable;
    }
    private Producto convertirDTO(ProductoDTO productoDTO) throws Exception{
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setUnidades(productoDTO.getUnidades());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setImagenes(productoDTO.getImagenes());
        producto.setFechaLimite(productoDTO.getFechaLimite());
        producto.setFechaCreacion(LocalDate.now());
        producto.setEstadoProducto(EstadoProducto.PENDIENTE);
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
    private ProductoDetailGetDTO convertirObjDetail(Producto producto) throws Exception{
        ProductoDetailGetDTO productoDetailGetDTO = new ProductoDetailGetDTO();
        productoDetailGetDTO.setIdProducto(producto.getIdProducto());
        productoDetailGetDTO.setNombre(producto.getNombre());
        productoDetailGetDTO.setDescripcion(producto.getDescripcion());
        productoDetailGetDTO.setEstadoProducto(producto.getEstadoProducto());
        productoDetailGetDTO.setUnidades(producto.getUnidades());
        productoDetailGetDTO.setPrecio(producto.getPrecio());
        productoDetailGetDTO.setFechaCreacion(producto.getFechaCreacion());
        productoDetailGetDTO.setFechaLimite(producto.getFechaLimite());
        productoDetailGetDTO.setCategorias(producto.getCategorias());
        productoDetailGetDTO.setComentarios(comentarioServicio.listarComentariosProducto(producto.getIdProducto()));
        productoDetailGetDTO.setCalificaciones(calificacionServicio.listarCalificaciones(producto.getIdProducto()));
        return productoDetailGetDTO;
    }
}