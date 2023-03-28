package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.SubastaDTO;
import co.edu.uniquindio.unimarket.dto.SubastaGetDTO;
import co.edu.uniquindio.unimarket.entidades.Subasta;

import java.util.List;

public interface SubastaServicio {
    Long crearSubasta(SubastaDTO subastaDTO) throws Exception;
    //Long agregarPuja(Puja puja);
    List<SubastaGetDTO> listarSubastas() throws Exception;
    SubastaGetDTO buscarSubastaId(Long idSubasta) throws Exception;
    List<SubastaGetDTO> listarSubastasProducto(String busqueda) throws Exception;

    Subasta obtenerSubastaObj(Long idSubasta) throws Exception;
}