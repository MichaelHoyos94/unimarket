package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImp implements UsuarioServicio{
    private UsuarioRepo usuarioRepo;
    public UsuarioServicioImp(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

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
}
