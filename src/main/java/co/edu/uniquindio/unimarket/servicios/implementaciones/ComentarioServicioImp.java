package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Comentario;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ComentarioServicioImp implements ComentarioServicio {
    private final ComentarioRepo comentarioRepo;
    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    @Override
    public Long crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario comentario = convertirDTO(comentarioDTO);
        return comentarioRepo.save(comentario).getIdComentario();
    }
    @Override
    public List<ComentarioGetDTO> listarComentariosProducto(Long idProducto) {
        List<Comentario> comentariosProducto = comentarioRepo.listarComentariosProducto(idProducto);
        List<ComentarioGetDTO> comentariosGetDTO = listarComentariosGetDTO(comentariosProducto);
        return comentariosGetDTO;
    }
    @Override
    public ComentarioGetDTO obtenerComentarioId(Long idComentario) throws Exception {
        Comentario comentario = comentarioRepo.findById(idComentario).orElse(null);
        ComentarioGetDTO comentarioGetDTO = convertirObj(comentario);
        return comentarioGetDTO;
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
        Producto producto = productoRepo.findById(comentarioDTO.getIdProducto()).orElse(null);
        Usuario usuario = usuarioRepo.findById(comentarioDTO.getIdUsuario()).orElse(null);
        if (usuario == null || producto == null)
            throw new Exception("El usuario o producto no existen.");
        Comentario comentario = new Comentario();
        comentario.setComentario(comentarioDTO.getComentario());
        comentario.setFecha(LocalDate.now());
        comentario.setUsuario(usuario);
        comentario.setProducto(producto);
        return comentario;
    }
    private ComentarioGetDTO convertirObj(Comentario comentario){
        ComentarioGetDTO comentarioGetDTO = new ComentarioGetDTO();
        comentarioGetDTO.setIdComentario(comentario.getIdComentario());
        comentarioGetDTO.setComentario(comentario.getComentario());
        comentarioGetDTO.setFecha(comentario.getFecha());
        comentarioGetDTO.setIdUsuario(comentario.getUsuario().getIdPersona());
        comentarioGetDTO.setIdProducto(comentario.getProducto().getIdProducto());
        return comentarioGetDTO;
    }
}