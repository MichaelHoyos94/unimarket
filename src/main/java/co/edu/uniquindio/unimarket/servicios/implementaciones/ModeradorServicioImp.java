package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.entidades.Moderador;
import co.edu.uniquindio.unimarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModeradorServicioImp implements ModeradorServicio {
    private final ModeradorRepo moderadorRepo;
    @Override
    public Moderador obtenerModeradorObj(Long idModerador) {
        Moderador moderador = moderadorRepo.findById(idModerador).orElse(null);
        if (moderador == null)
            throw new RuntimeException("El moderador no existe");
        return moderador;
    }
}
