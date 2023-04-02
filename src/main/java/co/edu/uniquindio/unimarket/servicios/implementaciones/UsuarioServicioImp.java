package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServicioImp implements UsuarioServicio {
    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo; //SOLO PRUEBAS
    private final ProductoServicio productoServicio;
    @Override
    public Long registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        boolean existe = usuarioRepo.findByEmail(usuarioDTO.getEmail()) != null;
        if (existe)
            throw new Exception("El correo electronico ya esta en uso.");
        Usuario nuevoUsuario = convertirDTO(usuarioDTO);
        return usuarioRepo.save(nuevoUsuario).getIdPersona();
    }
    @Override
    public Long actualizarUsuario(Long id, UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        if (usuario == null)
            throw new Exception("El usuario no existe.");
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setCiudad(usuarioDTO.getCiudad());
        usuario.setDireccion(usuarioDTO.getDireccion());
        return usuarioRepo.save(usuario).getIdPersona();
    }
    @Override
    public UsuarioGetDTO obtenerUsuarioId(Long idUsuario) throws Exception {
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        if (usuario == null)
            throw new Exception("El usuario no existe");
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();
        usuarioGetDTO.setIdUsuario(usuario.getIdPersona());
        usuarioGetDTO.setNombre(usuario.getNombre());
        usuarioGetDTO.setEmail(usuario.getEmail());
        usuarioGetDTO.setDireccion(usuario.getDireccion());
        usuarioGetDTO.setTelefono(usuario.getTelefono());
        usuarioGetDTO.setPassword(usuario.getPassword());
        return usuarioGetDTO;
    }
    @Override
    public Usuario obtenerUsuarioObj(Long idUsuario) throws Exception {
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        if (usuario == null){
            throw new Exception("El usuario no existe.");
        }
        return usuario;
    }

    @Override
    public boolean marcarFavorito(Long idUsuario, Long idProducto) throws Exception {
        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        Producto producto = productoServicio.obtenerProductoObj(idProducto);
        if (usuario == null || producto == null)
            throw new Exception("El usuario o el producto no existen.");
        List<Producto> productos = usuario.getProductos();
        List<Usuario> usuarios = producto.getUsuarios();
        if(productos.add(producto) && usuarios.add(usuario)){
            usuario.setFavoritos(productos);
            producto.setUsuarios(usuarios);
            return true;
        }
        return false;
    }

    @Override
    public Long reestablecerPassword(String email, String password, String passwordConfirm) throws Exception {
        if (password != passwordConfirm)
            throw new Exception("Las claves de acceso no coinciden");
        Usuario usuario = usuarioRepo.findByEmail(email);
        if (usuario == null)
            throw new Exception("El usuario con este correo no existe.");
        usuario.setPassword(password);
        return usuarioRepo.save(usuario).getIdPersona();
    }
    @Override
    public List<ProductoGetDTO> listarFavoritos(Long idUsuario) throws Exception {
        //O buscar usuario y luego usuario.getFavoritos(); ?
        List<Producto> favoritos = usuarioRepo.findById(idUsuario).orElse(null).getFavoritos();
        List<ProductoGetDTO> listaFavoritos = listarFavoritosDTO(favoritos);
        return listaFavoritos;
    }
    private Usuario convertirDTO(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setCiudad(usuarioDTO.getCiudad());
        usuario.setDireccion(usuarioDTO.getDireccion());
        return usuario;
    }
    private List<ProductoGetDTO> listarFavoritosDTO(List<Producto> productos){
        List<ProductoGetDTO> productosGetDTO = new ArrayList<>();
        for (Producto producto : productos ) {
            ProductoGetDTO productoAux = new ProductoGetDTO();
            productoAux.setIdProducto(producto.getIdProducto());
            productoAux.setNombre(producto.getNombre());
            productoAux.setDescripcion(producto.getDescripcion());
            productoAux.setUnidades(producto.getUnidades());
            productoAux.setPrecio(producto.getPrecio());
            productoAux.setFechaCreacion(producto.getFechaCreacion());
            productoAux.setFechaLimite(producto.getFechaLimite());
            productoAux.setCategorias(producto.getCategorias());
            productosGetDTO.add(productoAux);
        }
        return productosGetDTO;
    }
}