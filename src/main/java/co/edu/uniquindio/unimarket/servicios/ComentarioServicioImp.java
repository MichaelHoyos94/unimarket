package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Comentario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImp implements ComentarioServicio{
    private final ComentarioRepo comentarioRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;

    @Override
    public Long crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario comentario = convertirDTO(comentarioDTO);
        return comentarioRepo.save(comentario).getIdComentario();
    }
    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(Long idProducto) throws Exception {
        List<Comentario> comentariosProducto = comentarioRepo.listarComentariosProducto(idProducto);
        List<ComentarioGetDTO> comentariosGetDTO = listarComentariosGetDTO(comentariosProducto);
        return comentariosGetDTO;
    }
    private List<ComentarioGetDTO> listarComentariosGetDTO (List<Comentario> comentarios){
        List<ComentarioGetDTO> comentariosGetDTO = new ArrayList<ComentarioGetDTO>();
        for (Comentario comentario: comentarios) {
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
    private Comentario convertirDTO(ComentarioDTO comentarioDTO) throws Exception{
        Comentario comentario = new Comentario();
        comentario.setComentario(comentarioDTO.getComentario());
        comentario.setFecha(comentario.getFecha());
        comentario.setUsuario(usuarioServicio.obtenerUsuarioObj(comentarioDTO.getIdUsuario()));
        comentario.setProducto(productoServicio.obtenerProductoObj(comentarioDTO.getIdProducto()));
        return comentario;
    }
}