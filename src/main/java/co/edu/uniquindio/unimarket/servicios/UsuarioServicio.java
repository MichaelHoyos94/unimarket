package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {
    Long registrarUsuario (UsuarioDTO usuarioDTO) throws Exception;
    Long actualizarUsuario(Long id, UsuarioDTO usuarioDTO) throws Exception;
    UsuarioGetDTO obtenerUsuarioId(Long idUsuario) throws Exception;
    Usuario obtenerUsuarioObj(Long idUsuario) throws Exception;
    boolean marcarFavorito(Long idUsuario, Long idProducto) throws Exception;
    //desmarcarFavorito(Long idUsuario, Long idProducto);
    Long reestablecerPassword(String email,String password, String passwordConfirm) throws Exception;
    List<ProductoGetDTO> listarFavoritos(Long idUsuario) throws Exception;
}