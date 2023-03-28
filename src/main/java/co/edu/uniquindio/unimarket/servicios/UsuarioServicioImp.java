package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServicioImp implements UsuarioServicio{
    private final UsuarioRepo usuarioRepo;
    @Override
    public Long registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        boolean existe = usuarioRepo.findByEmail(usuarioDTO.getEmail()) != null;
        if (existe)
            throw new Exception("El correo electronico ya esta en uso.");
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCedula(usuarioDTO.getCedula());
        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setEmail(usuarioDTO.getEmail());
        nuevoUsuario.setPassword(usuarioDTO.getPassword());
        nuevoUsuario.setCiudad(usuarioDTO.getCiudad());
        nuevoUsuario.setTelefono(usuarioDTO.getTelefono());
        nuevoUsuario.setDireccion(usuarioDTO.getDireccion());
        return usuarioRepo.save(nuevoUsuario).getIdPersona();
    }
    @Override
    public Long actualizarUsuario(Long id, UsuarioDTO usuarioDTO) throws Exception {
        boolean existe = usuarioRepo.findById(id) != null;
        if (!existe)
            throw new Exception("El usuario no existe.");
        usuarioRepo.actualizarUsuario(id, usuarioDTO.getNombre());
        return id;
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
    public Long reestablecerPassword(String email, String password, String passwordConfirm) throws Exception {
        if (password != passwordConfirm)
            throw new Exception("Las claves de acceso no coinciden");
        Usuario usuario = usuarioRepo.findByEmail(email);
        if (usuario == null)
            throw new Exception("El usuario con este correo no existe.");
        usuario.setPassword(password);
        return usuarioRepo.save(usuario).getIdPersona();
    }
}