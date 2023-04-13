package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.SubastaDTO;
import co.edu.uniquindio.unimarket.dto.SubastaGetDTO;
import co.edu.uniquindio.unimarket.entidades.Puja;
import co.edu.uniquindio.unimarket.entidades.Subasta;
import co.edu.uniquindio.unimarket.repositorios.SubastaRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.SubastaServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubastaServicioImp implements SubastaServicio {
    private final SubastaRepo subastaRepo;
    private final UsuarioServicio usuarioServicio;
    @Override
    public Long crearSubasta(SubastaDTO subastaDTO) throws Exception {
        Subasta subasta = convertirDTO(subastaDTO);
        return subastaRepo.save(subasta).getIdSubasta();
    }
    @Override
    public List<SubastaGetDTO> listarSubastas(int page) throws Exception {
        List<Subasta> subastas = subastaRepo.findAll(paginar(page)).toList();
        return listarSubastasDTO(subastas);
    }
    @Override
    public SubastaGetDTO buscarSubastaId(Long idSubasta) throws Exception {
        Subasta subasta = subastaRepo.findById(idSubasta).orElse(null);
        if (subasta == null)
            throw new Exception("No existe la subasta");
        SubastaGetDTO subastaGetDTO = convertirObj(subasta);
        return subastaGetDTO;
    }
    @Override
    public List<SubastaGetDTO> listarSubastasBusqueda(String busqueda, int page) throws Exception {
        List<Subasta> subastas = subastaRepo.listarSubastasBusqueda(busqueda, paginar(page));
        if (subastas.isEmpty())
            throw new Exception("La busqueda no coincide con ninguna subasta");
        List<SubastaGetDTO> subastasGetDTO = listarSubastasDTO(subastas);
        return subastasGetDTO;
    }
    @Override
    public List<SubastaGetDTO> listarSubastasBusquedaOrdValorAsc(String busqueda, int page) {
        List<Subasta> subastas = subastaRepo.listarSubastasBusquedaOrdValorAsc(busqueda, paginar(page));
        List<SubastaGetDTO> subastasGetDTO = listarSubastasDTO(subastas);
        return subastasGetDTO;
    }
    @Override
    public List<SubastaGetDTO> listarSubastasBusquedaOrdValorDesc(String busqueda, int page) {
        List<Subasta> subastas = subastaRepo.listarSubastasBusquedaOrdValorDesc(busqueda, paginar(page));
        List<SubastaGetDTO> subastasGetDTO = listarSubastasDTO(subastas);
        return subastasGetDTO;
    }
    @Override
    public List<SubastaGetDTO> listarSubastasBusquedaPorCerrar(String busqueda, int page) {
        List<Subasta> subastas = subastaRepo.listarSubastasBusquedaPorCerrar(busqueda, paginar(page));
        List<SubastaGetDTO> subastasGetDTO = listarSubastasDTO(subastas);
        return subastasGetDTO;
    }
    @Override
    public Subasta obtenerSubastaObj(Long idSubasta) throws Exception{
        Subasta subasta = subastaRepo.findById(idSubasta).orElse(null);
        if (subasta == null)
            throw new Exception("La subasta no existe.");
        return subasta;
    }
    @Override
    public boolean agregarPuja(Long idSubasta, Puja puja) throws Exception{
        Subasta subasta = obtenerSubastaObj(idSubasta);
        int last = subasta.getPujas().size() - 1;
        if (puja.getValorPuja() <= subasta.getValorInicial() || subasta.getPujas().get(last).getValorPuja() >= puja.getValorPuja())
            return false;
        return true;
    }
    private Pageable paginar(int page){
        return PageRequest.of(page, 20);
    }
    private SubastaGetDTO convertirObj(Subasta subasta) {
        SubastaGetDTO subastaGetDTO = new SubastaGetDTO();
        subastaGetDTO.setIdSubasta(subasta.getIdSubasta());
        subastaGetDTO.setNombreProducto(subasta.getNombreProducto());
        subastaGetDTO.setDescripcion(subasta.getDescripcion());
        subastaGetDTO.setEstado(subasta.getEstado());
        subastaGetDTO.setValorInicial(subasta.getValorInicial());
        subastaGetDTO.setFechaInicio(subasta.getFechaInicio());
        subastaGetDTO.setFechaLimite(subasta.getFechaLimite());
        subastaGetDTO.setIdUsuario(subasta.getUsuario().getIdPersona());
        //subastaGetDTO.setEstado(subasta.getEstado());
        //subastaGetDTO.setPujas(subasta.getPujas());
        return subastaGetDTO;
    }
    private Subasta convertirDTO(SubastaDTO subastaDTO) throws Exception{
        Subasta subasta = new Subasta();
        subasta.setNombreProducto(subastaDTO.getNombreProducto());
        subasta.setDescripcion(subastaDTO.getDescripcion());
        subasta.setEstado(true);
        subasta.setValorInicial(subastaDTO.getValorInicial());
        subasta.setFechaInicio(LocalDate.now());
        subasta.setFechaLimite(subastaDTO.getFechaLimite());
        subasta.setUsuario(usuarioServicio.obtenerUsuarioObj(subastaDTO.getIdUsuario()));
        subasta.setPujas(new ArrayList<>());
        return subasta;
    }
    private List<SubastaGetDTO> listarSubastasDTO(List<Subasta> subastas){
        List<SubastaGetDTO> subastasGetDTO = new ArrayList<>();
        for (Subasta subasta : subastas) {
            SubastaGetDTO subastaAux = new SubastaGetDTO();
            subastaAux.setIdSubasta(subasta.getIdSubasta());
            subastaAux.setNombreProducto(subasta.getNombreProducto());
            subastaAux.setDescripcion(subasta.getDescripcion());
            subastaAux.setEstado(subasta.getEstado());
            subastaAux.setFechaInicio(subasta.getFechaInicio());
            subastaAux.setFechaLimite(subasta.getFechaLimite());
            subastaAux.setValorInicial(subasta.getValorInicial());
            subastaAux.setIdUsuario(subasta.getUsuario().getIdPersona());
            //subastaAux.setPujas(subasta.getPujas());
            subastasGetDTO.add(subastaAux);
        }
        return subastasGetDTO;
    }
}