package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.PujaDTO;
import co.edu.uniquindio.unimarket.entidades.Puja;
import co.edu.uniquindio.unimarket.repositorios.PujaRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.PujaServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.SubastaServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PujaServicioImp implements PujaServicio {
    private final PujaRepo pujaRepo;
    private final UsuarioServicio usuarioServicio;
    private final SubastaServicio subastaServicio;

    @Override
    public Long crearPuja(PujaDTO pujaDTO) throws Exception {
        Puja puja = convertirDTO(pujaDTO);
        return pujaRepo.save(puja).getIdPuja();
    }
    private Puja convertirDTO(PujaDTO pujaDTO) throws Exception{
        Puja puja = new Puja();
        puja.setValorPuja(pujaDTO.getValorPuja());
        puja.setUsuario(usuarioServicio.obtenerUsuarioObj(pujaDTO.getIdUsuario()));
        puja.setSubasta(subastaServicio.obtenerSubastaObj(pujaDTO.getIdSubasta()));
        return puja;
    }
}