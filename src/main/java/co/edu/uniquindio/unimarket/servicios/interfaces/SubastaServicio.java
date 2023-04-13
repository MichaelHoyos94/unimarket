package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.SubastaDTO;
import co.edu.uniquindio.unimarket.dto.SubastaGetDTO;
import co.edu.uniquindio.unimarket.entidades.Puja;
import co.edu.uniquindio.unimarket.entidades.Subasta;

import java.util.List;

public interface SubastaServicio {
    Long crearSubasta(SubastaDTO subastaDTO) throws Exception;
    //Long agregarPuja(Puja puja);
    List<SubastaGetDTO> listarSubastas(int page) throws Exception;
    SubastaGetDTO buscarSubastaId(Long idSubasta) throws Exception;
    List<SubastaGetDTO> listarSubastasBusqueda(String busqueda, int page) throws Exception;
    List<SubastaGetDTO> listarSubastasBusquedaOrdValorAsc(String busqueda, int page);
    List<SubastaGetDTO> listarSubastasBusquedaOrdValorDesc(String busqueda, int page);
    List<SubastaGetDTO> listarSubastasBusquedaPorCerrar(String busqueda, int page);
    Subasta obtenerSubastaObj(Long idSubasta) throws Exception;
    boolean agregarPuja(Long idSubasta, Puja puja) throws Exception;
}