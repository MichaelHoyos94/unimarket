package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/compra")
@AllArgsConstructor
public class CompraControlador {
    private final CompraServicio compraServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCompra(@Valid @RequestBody CompraDTO compraDTO) throws Exception{
        compraServicio.crearCompra(compraDTO);
        return ResponseEntity.status(201).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Compra realizada con exito."
        ));
    }
}