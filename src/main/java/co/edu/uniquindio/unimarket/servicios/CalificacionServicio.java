package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.CalificacionGetDTO;

import java.util.List;

public interface CalificacionServicio {
    Long crearCalificacion();
    List<CalificacionGetDTO> listarCalificaciones(Long idProducto);
}