package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Comentario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComentarioServicioImp implements ComentarioServicio{
    @Autowired
    private ComentarioRepo comentarioRepo;
    @Override
    public Long crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        return null;
    }
    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(Long idProducto) throws Exception {
        List<Comentario> comentariosProducto = comentarioRepo.listarComentariosProducto(idProducto);
        List<ComentarioGetDTO> comentariosGetDTO = new ArrayList<ComentarioGetDTO>();
        for (Comentario comentario: comentariosProducto) {
            ComentarioGetDTO comentarioAux = new ComentarioGetDTO();
            comentarioAux.setIdComentario(comentario.getIdComentario());
            comentarioAux.setComentario(comentario.getComentario());
            comentarioAux.setFecha(comentario.getFecha());
            comentarioAux.setIdUsuario(comentario.getUsuario().getIdPersona());
            comentarioAux.setIdProducto(comentario.getProducto().getIdProducto());
            comentariosGetDTO.add(comentarioAux);
        }
        return comentariosGetDTO;
    }
}