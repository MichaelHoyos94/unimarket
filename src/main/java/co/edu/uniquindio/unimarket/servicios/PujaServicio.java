package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.PujaDTO;

public interface PujaServicio {
    Long crearPuja(PujaDTO pujaDTO) throws Exception;
}