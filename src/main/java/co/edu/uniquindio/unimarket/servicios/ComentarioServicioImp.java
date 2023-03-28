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
        Comentario nuevoComentario = new Comentario();
        nuevoComentario.setComentario(nuevoComentario.getComentario());
        nuevoComentario.setUsuario(usuarioServicio.obtenerUsuarioObj(comentarioDTO.getIdUsuario()));
        nuevoComentario.setProducto(productoServicio.obtenerProductoObj(comentarioDTO.getIdProducto()));
        nuevoComentario.setFecha(LocalDate.now());
        return comentarioRepo.save(nuevoComentario).getIdComentario();
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