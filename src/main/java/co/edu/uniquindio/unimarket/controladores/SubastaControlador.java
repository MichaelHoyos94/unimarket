package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.SubastaDTO;
import co.edu.uniquindio.unimarket.dto.SubastaGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SubastaServicio;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subasta")
@AllArgsConstructor
public class SubastaControlador {
    private final SubastaServicio subastaServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearSubasta(@Valid @RequestBody SubastaDTO subastaDTO) throws Exception{
        subastaServicio.crearSubasta(subastaDTO);
        return ResponseEntity.status(201).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Subasta creada con exito."
        ));
    }
    @GetMapping("/subastas/all")
    public ResponseEntity<MensajeDTO> listarSubastas(@RequestParam int page) throws Exception{
        List<SubastaGetDTO> subastas = subastaServicio.listarSubastas(page);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                subastas
        ));
    }
    @GetMapping("/subastas")
    public ResponseEntity<MensajeDTO> listarSubastasBusqueda(@RequestParam String busqueda, @RequestParam @Nullable String sort, @RequestParam int page) throws Exception{
        List<SubastaGetDTO> subastas = subastaServicio.listarSubastasBusqueda(busqueda, sort, page);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                subastas
        ));
    }
}
