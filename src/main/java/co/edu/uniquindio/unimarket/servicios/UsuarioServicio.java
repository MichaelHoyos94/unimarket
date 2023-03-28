package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
public interface UsuarioServicio {
    Long registrarUsuario (UsuarioDTO usuarioDTO) throws Exception;
    Long actualizarUsuario(Long id, UsuarioDTO usuarioDTO) throws Exception;
    UsuarioGetDTO obtenerUsuarioId(Long idUsuario) throws Exception;
    Usuario obtenerUsuarioObj(Long idUsuario) throws Exception;
    //marcarFavorito(Long idUsuario, Long idProducto);
    //desmarcarFavorito(Long idUsuario, Long idProducto);
    Long reestablecerPassword(String email,String password, String passwordConfirm) throws Exception;
    //listarFavoritos();
}