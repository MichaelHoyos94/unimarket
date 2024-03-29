package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.dto.CalificacionGetDTO;
import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CalificacionServicioImp implements CalificacionServicio {
    private final CalificacionRepo calificacionRepo;
    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    @Override
    public Long crearCalificacion(CalificacionDTO calificacionDTO) throws Exception{
        Calificacion nuevaCalificacion = convertirDTO(calificacionDTO);
        boolean existe = nuevaCalificacion == calificacionRepo.obtenerCalificacionProductoUsuario(calificacionDTO.getIdProducto(), calificacionDTO.getIdUsuario());
        if (existe)
            throw new Exception("La calificacion ya existe");
        return calificacionRepo.save(nuevaCalificacion).getIdCalificacion();
    }
    @Override
    public List<CalificacionGetDTO> listarCalificaciones(Long idProducto){
        List<Calificacion> calificaciones = calificacionRepo.listarCalificacionesProducto(idProducto);
        List<CalificacionGetDTO> calificacionesGetDto = listarCalificacionesDto(calificaciones);
        return calificacionesGetDto;
    }
    @Override
    public CalificacionGetDTO obtenerCalificacionId(Long idCalificacion) throws Exception {
        Calificacion calificacion = calificacionRepo.findById(idCalificacion).orElse(null);
        if (calificacion == null)
            throw new Exception("No existe la calificacion");
        CalificacionGetDTO calificacionGetDTO = convertirObj(calificacion);
        return calificacionGetDTO;
    }
    private CalificacionGetDTO convertirObj(Calificacion calificacion) throws Exception{
        CalificacionGetDTO calificacionGetDTO = new CalificacionGetDTO();
        calificacionGetDTO.setIdCalificacion(calificacion.getIdCalificacion());
        calificacionGetDTO.setCalificacion(calificacion.getCalificacion());
        calificacionGetDTO.setIdUsuario(calificacion.getUsuario().getIdPersona());
        calificacionGetDTO.setIdProducto(calificacion.getProducto().getIdProducto());
        return calificacionGetDTO;
    }
    private Calificacion convertirDTO(CalificacionDTO calificacionDTO) throws Exception{
        Usuario usuario = usuarioRepo.findById(calificacionDTO.getIdUsuario()).orElse(null);
        Producto producto = productoRepo.findById(calificacionDTO.getIdProducto()).orElse(null);
        if (usuario == null || producto == null)
            throw new Exception("El usuario o el producto no existen.");
        Calificacion nuevaCalificacion = new Calificacion();
        nuevaCalificacion.setCalificacion(calificacionDTO.getCalificacion());
        nuevaCalificacion.setUsuario(usuario);
        nuevaCalificacion.setProducto(producto);
        return nuevaCalificacion;
    }
    private List<CalificacionGetDTO> listarCalificacionesDto(List<Calificacion> calificaciones){
        List<CalificacionGetDTO> calificacionesGetDTO = new ArrayList<CalificacionGetDTO>();
        for (Calificacion calificacion : calificaciones) {
            CalificacionGetDTO calificacionAux = new CalificacionGetDTO();
            calificacionAux.setIdCalificacion(calificacion.getIdCalificacion());
            calificacionAux.setCalificacion(calificacion.getCalificacion());
            calificacionAux.setIdProducto(calificacion.getProducto().getIdProducto());
            calificacionAux.setIdUsuario(calificacion.getUsuario().getIdPersona());
            calificacionesGetDTO.add(calificacionAux);
        }
        return calificacionesGetDTO;
    }
}