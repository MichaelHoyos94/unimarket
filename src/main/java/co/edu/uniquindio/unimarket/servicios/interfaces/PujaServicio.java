package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.PujaDTO;
import co.edu.uniquindio.unimarket.dto.PujaGetDTO;

import java.util.List;

public interface PujaServicio {
    Long crearPuja(PujaDTO pujaDTO) throws Exception;
}