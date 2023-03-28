package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.dto.CalificacionGetDTO;
import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.repositorios.CalificacionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CalificacionServicioImp implements CalificacionServicio{
    private final CalificacionRepo calificacionRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    @Override
    public Long crearCalificacion(CalificacionDTO calificacionDTO) throws Exception{
        Calificacion nuevaCalificacion = convertirDTO(calificacionDTO);
        boolean existe = nuevaCalificacion == calificacionRepo.obtenerCalificacionProductoUsuario(calificacionDTO.getIdProducto(), calificacionDTO.getIdUsuario());
        if (existe)
            throw new Exception("La calificacion ya existe");
        return calificacionRepo.save(nuevaCalificacion).getIdCalificacion();
    }

    @Override
    public List<CalificacionGetDTO> listarCalificaciones(Long idProducto) throws Exception{
        List<Calificacion> calificaciones = calificacionRepo.listarCalificacionesProducto(idProducto);
        List<CalificacionGetDTO> calificacionesGetDto = listarCalificacionesDto(calificaciones);
        if (calificacionesGetDto.isEmpty())
            throw new Exception("No hay calificaciones para este producto");
        return calificacionesGetDto;
    }

    private Calificacion convertirDTO(CalificacionDTO calificacionDTO) throws Exception{
        Calificacion nuevaCalificacion = new Calificacion();
        nuevaCalificacion.setCalificacion(calificacionDTO.getCalificacion());
        nuevaCalificacion.setUsuario(usuarioServicio.obtenerUsuarioObj(calificacionDTO.getIdUsuario()));
        nuevaCalificacion.setProducto(productoServicio.obtenerProductoObj(calificacionDTO.getIdProducto()));
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