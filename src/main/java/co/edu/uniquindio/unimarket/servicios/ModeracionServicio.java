package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.ModeracionDTO;

public interface ModeracionServicio {
    Long moderarProducto(ModeracionDTO moderacionDTO) throws Exception;
}