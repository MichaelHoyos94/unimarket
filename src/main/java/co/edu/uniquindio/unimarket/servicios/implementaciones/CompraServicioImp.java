package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.repositorios.CompraRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.DetalleCompraServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompraServicioImp implements CompraServicio {
    private final CompraRepo compraRepo;
    private final UsuarioServicio usuarioServicio;
    private final DetalleCompraServicio detalleCompraServicio;
    @Override
    public Long crearCompra(CompraDTO compraDTO) throws Exception {
        Compra compra = convertirDTO(compraDTO);
        Long idCompraSaved = compraRepo.save(compra).getIdCompra();
        compra.setPrecio(detalleCompraServicio.crearDetalleCompra(compraDTO.getDetalleCompras(), compra));
        compraRepo.save(compra);
        return idCompraSaved;
    }

    @Override
    public List<CompraGetDTO> listarCompras(Long idUsuario) throws Exception {
        List<Compra> listaCompras = compraRepo.listarComprasUsuario(idUsuario);
        List<CompraGetDTO> comprasGetDTO = listarComprasGetDTO(listaCompras);
        return comprasGetDTO;
    }

    @Override
    public Compra obtenerCompraObj(Long idCompra) throws Exception {
        Compra compra = compraRepo.findById(idCompra).orElse(null);
        if(compra == null)
            throw  new Exception("No existe la compra");
        return compra;
    }
    private List<CompraGetDTO> listarComprasGetDTO(List<Compra> listaCompras) {
        List<CompraGetDTO> compraGetDTO = new ArrayList<>();
        for (Compra compra: listaCompras) {
            CompraGetDTO compraAux = new CompraGetDTO();
            compraAux.setIdCompra(compra.getIdCompra());
            compraAux.setPrecio(compra.getPrecio());
            compraAux.setFecha(compra.getFecha());
            compraAux.setIdUsuario(compra.getUsuario().getIdPersona());
            compraAux.setMetodoPago(compra.getMetodoPago());
            compraGetDTO.add(compraAux);
        }
        return compraGetDTO;
    }
    private Compra convertirDTO (CompraDTO compraDTO) throws Exception{
        Compra compra = new Compra();
        compra.setFecha(LocalDate.now());
        compra.setUsuario(usuarioServicio.obtenerUsuarioObj(compraDTO.getIdUsuario()));
        compra.setMetodoPago(compraDTO.getMetodoPago());
        compra.setPrecio(0);
        compra.setDetalle(new ArrayList<>());
        return compra;
    }
}
