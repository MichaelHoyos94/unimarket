package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.SubastaDTO;
import co.edu.uniquindio.unimarket.dto.SubastaGetDTO;
import co.edu.uniquindio.unimarket.entidades.Subasta;
import co.edu.uniquindio.unimarket.repositorios.SubastaRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubastaServicioImp implements SubastaServicio{
    private final SubastaRepo subastaRepo;
    private final UsuarioServicio usuarioServicio;
    private final ProductoServicio productoServicio;
    @Override
    public Long crearSubasta(SubastaDTO subastaDTO) throws Exception {
        Subasta subasta = convertirDTO(subastaDTO);
        return subastaRepo.save(subasta).getIdSubasta();
    }
    @Override
    public List<SubastaGetDTO> listarSubastas() throws Exception {
        List<Subasta> subastas = subastaRepo.findAll();
        return listarSubastasDTO(subastas);
    }

    @Override
    public SubastaGetDTO buscarSubastaId(Long idSubasta) throws Exception {
        Subasta subasta = subastaRepo.findById(idSubasta).orElse(null);
        SubastaGetDTO subastaGetDTO = convertirObj(subasta);
        return subastaGetDTO;
    }
    @Override
    public List<SubastaGetDTO> listarSubastasProducto(String busqueda) throws Exception {
        return null;
    }

    @Override
    public Subasta obtenerSubastaObj(Long idSubasta) throws Exception{
        Subasta subasta = subastaRepo.findById(idSubasta).orElse(null);
        if (subasta == null)
            throw new Exception("La subasta no existe.");
        return subasta;
    }
    private SubastaGetDTO convertirObj(Subasta subasta) {
        SubastaGetDTO subastaGetDTO = new SubastaGetDTO();
        subastaGetDTO.setIdSubasta(subasta.getIdSubasta());
        subastaGetDTO.setValorInicial(subasta.getValorInicial());
        subastaGetDTO.setFechaInicio(subasta.getFechaInicio());
        subastaGetDTO.setFechaFin(subasta.getFechaFin());
        subastaGetDTO.setIdUsuario(subasta.getUsuario().getIdPersona());
        subastaGetDTO.setIdProducto(subasta.getProducto().getIdProducto());
        //subastaGetDTO.setEstado(subasta.getEstado());
        //subastaGetDTO.setPujas(subasta.getPujas());
        return subastaGetDTO;
    }
    private Subasta convertirDTO(SubastaDTO subastaDTO) throws Exception{
        Subasta subasta = new Subasta();
        subasta.setEstado(true);
        subasta.setValorInicial(subastaDTO.getValorInicial());
        subasta.setFechaInicio(LocalDate.now());
        subasta.setFechaFin(subastaDTO.getFechaFin());
        subasta.setUsuario(usuarioServicio.obtenerUsuarioObj(subastaDTO.getIdUsuario()));
        subasta.setProducto(productoServicio.obtenerProductoObj(subastaDTO.getIdProducto()));
        subasta.setPujas(new ArrayList<>());
        return subasta;
    }
    private List<SubastaGetDTO> listarSubastasDTO(List<Subasta> subastas){
        List<SubastaGetDTO> subastasGetDTO = new ArrayList<>();
        for (Subasta subasta : subastas) {
            SubastaGetDTO subastaAux = new SubastaGetDTO();
            subastaAux.setIdSubasta(subasta.getIdSubasta());
            subastaAux.setFechaInicio(subasta.getFechaInicio());
            subastaAux.setFechaFin(subasta.getFechaFin());
            subastaAux.setValorInicial(subasta.getValorInicial());
            subastaAux.setIdUsuario(subasta.getUsuario().getIdPersona());
            subastaAux.setIdProducto(subasta.getProducto().getIdProducto());
            //subastaAux.setPujas(subasta.getPujas());
            //subastaAux.setEstado(subasta.getEstado());
            subastasGetDTO.add(subastaAux);
        }
        return subastasGetDTO;
    }
}