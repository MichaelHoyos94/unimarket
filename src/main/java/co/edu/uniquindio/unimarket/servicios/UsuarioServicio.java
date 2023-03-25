package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;

public interface UsuarioServicio {
    Long registrarUsuario (UsuarioDTO usuarioDTO) throws Exception;
    Long actualizarUsuario(Long id, UsuarioDTO usuarioDTO) throws Exception;
    UsuarioGetDTO obtenerUsuarioId(Long idUsuario) throws Exception;
    //marcarFavorito(Long idUsuario, Long idProducto);
    //desmarcarFavorito(Long idUsuario, Long idProducto);
    //reestablecerPassword();
    //listarFavoritos();
}