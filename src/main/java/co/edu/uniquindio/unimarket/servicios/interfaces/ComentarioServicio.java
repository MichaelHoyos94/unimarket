package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;

import java.util.List;

public interface ComentarioServicio {
    Long crearComentario(ComentarioDTO comentarioDTO) throws Exception;
    List<ComentarioGetDTO> listarComentariosProducto(Long idProducto) throws Exception;
    //PARA PRUEBAS
    ComentarioGetDTO obtenerComentarioId(Long idComentario) throws Exception;
}