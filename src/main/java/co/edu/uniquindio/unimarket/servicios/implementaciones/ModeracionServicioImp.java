package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.ModeracionDTO;
import co.edu.uniquindio.unimarket.entidades.Moderacion;
import co.edu.uniquindio.unimarket.repositorios.ModeracionRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeracionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeracionServicioImp implements ModeracionServicio {
    private final ModeracionRepo moderacionRepo;
    private final ProductoServicio productoServicio;
    private final ModeradorServicio moderadorServicio;
    @Override
    public Long moderarProducto(ModeracionDTO moderacionDTO) throws Exception{
        Moderacion moderacion = convertirDTO(moderacionDTO);
        productoServicio.actualizarProductoEstado(moderacionDTO.getIdProducto(), moderacionDTO.getEstadoProducto());
        return moderacionRepo.save(moderacion).getId();
    }
    private Moderacion convertirDTO(ModeracionDTO moderacionDTO) throws Exception{
        Moderacion moderacion = new Moderacion();
        moderacion.setProducto(productoServicio.obtenerProductoObj(moderacionDTO.getIdProducto()));
        moderacion.setModerador(moderadorServicio.obtenerModeradorObj(moderacionDTO.getIdModerador()));
        moderacion.setEstadoProducto(moderacionDTO.getEstadoProducto());
        return moderacion;
    }
}
