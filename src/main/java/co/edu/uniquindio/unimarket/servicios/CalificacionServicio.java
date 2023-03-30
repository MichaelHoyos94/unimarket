package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.dto.CalificacionGetDTO;

import java.util.List;

public interface CalificacionServicio {
    Long crearCalificacion(CalificacionDTO calificacionDTO) throws Exception;
    List<CalificacionGetDTO> listarCalificaciones(Long idProducto) throws Exception;
    CalificacionGetDTO obtenerCalificacionId(Long idCalificacion) throws Exception;
    //promediarCalificaciones();
}