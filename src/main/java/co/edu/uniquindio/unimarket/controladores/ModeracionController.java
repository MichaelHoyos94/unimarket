package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ModeracionDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ModeracionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/moderacion")
@AllArgsConstructor
public class ModeracionController {
    private final ModeracionServicio moderacionServicio;
    @PostMapping("/moderar")
    public ResponseEntity<MensajeDTO> moderarProducto(@Valid @RequestBody ModeracionDTO moderacionDTO) throws Exception{
        moderacionServicio.moderarProducto(moderacionDTO);
        return ResponseEntity.status(201).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Producto moderado con exito."
        ));
    }
}