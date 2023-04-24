package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.*;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {
    Long registrarUsuario (UsuarioDTO usuarioDTO) throws Exception;
    Long actualizarUsuario(Long id, UsuarioActualizarDTO usuarioActualizarDTO) throws Exception;
    UsuarioGetDTO obtenerUsuarioId(Long idUsuario) throws Exception;
    Usuario obtenerUsuarioObj(Long idUsuario) throws Exception;
    //desmarcarFavorito(Long idUsuario, Long idProducto);
    Long reestablecerPassword(RecuperarPassDTO recuperarPassDTO) throws Exception;
    List<ProductoGetDTO> listarFavoritos(Long idUsuario) throws Exception;
}