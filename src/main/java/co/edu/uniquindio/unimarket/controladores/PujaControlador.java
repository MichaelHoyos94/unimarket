package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.PujaDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.PujaServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/puja")
@AllArgsConstructor
public class PujaControlador {
    private final PujaServicio pujaServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearPuja(@Valid @RequestBody PujaDTO pujaDTO) throws Exception{
        pujaServicio.crearPuja(pujaDTO);
        return ResponseEntity.status(201).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Puja realizada con exito. ¡Buena suerte!"
        ));
    }
}