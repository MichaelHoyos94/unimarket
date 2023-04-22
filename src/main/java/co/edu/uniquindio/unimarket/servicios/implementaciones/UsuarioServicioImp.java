package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.*;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServicioImp implements UsuarioServicio {
    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Long registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        boolean existe = usuarioRepo.findByEmail(usuarioDTO.getEmail()) != null || usuarioRepo.findByCedula(usuarioDTO.getCedula()) != null;
        if (existe)
            throw new Exception("El correo electronico o cedula ya esta en uso.");
        Usuario usuario = convertirDTO(usuarioDTO);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepo.save(usuario).getIdPersona();
    }
    @Override
    public Long actualizarUsuario(Long id, UsuarioActualizarDTO usuarioActualizarDTO) throws Exception {
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        if (usuario == null)
            throw new Exception("El usuario no existe.");
        usuario.setCedula(usuarioActualizarDTO.getCedula());
        usuario.setNombre(usuarioActualizarDTO.getNombre());
        usuario.setEmail(usuarioActualizarDTO.getEmail());
        usuario.setTelefono(usuarioActualizarDTO.getTelefono());
        usuario.setCiudad(usuarioActualizarDTO.getCiudad());
        usuario.setDireccion(usuarioActualizarDTO.getDireccion());
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
        return false;
    }

    @Override
    public Long reestablecerPassword(RecuperarPassDTO recuperarPassDTO) throws Exception {
        if (recuperarPassDTO.getPassword() != recuperarPassDTO.getPasswordconfirm())
            throw new Exception("Las claves de acceso no coinciden");
        Usuario usuario = usuarioRepo.findByEmail(recuperarPassDTO.getEmail());
        if (usuario == null)
            throw new Exception("El usuario con este correo no existe.");
        usuario.setPassword(passwordEncoder.encode(recuperarPassDTO.getPassword()));
        return usuarioRepo.save(usuario).getIdPersona();
    }
    @Override
    public List<ProductoGetDTO> listarFavoritos(Long idUsuario) throws Exception {
        //O buscar usuario y luego usuario.getFavoritos(); ?
        //List<Producto> favoritos = usuarioRepo.findById(idUsuario).orElse(null).getFavoritos();
        //List<ProductoGetDTO> listaFavoritos = listarFavoritosDTO(favoritos);
        return null;
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
}