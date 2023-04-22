package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.SubastaDTO;
import co.edu.uniquindio.unimarket.dto.SubastaGetDTO;
import co.edu.uniquindio.unimarket.entidades.Puja;
import co.edu.uniquindio.unimarket.entidades.Subasta;

import java.util.List;

public interface SubastaServicio {
    Long crearSubasta(SubastaDTO subastaDTO) throws Exception;
    List<SubastaGetDTO> listarSubastas(int page) throws Exception;
    SubastaGetDTO buscarSubastaId(Long idSubasta) throws Exception;
    List<SubastaGetDTO> listarSubastasBusqueda(String busqueda, String sort, int page) throws Exception;
    Subasta obtenerSubastaObj(Long idSubasta) throws Exception;
    boolean agregarPuja(Long idSubasta, Puja puja) throws Exception;
}