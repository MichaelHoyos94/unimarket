package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.dto.CalificacionGetDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.entidades.Calificacion;
import co.edu.uniquindio.unimarket.servicios.interfaces.CalificacionServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("api/calificaciones")
@AllArgsConstructor
public class CalificacionControlador {

    private final CalificacionServicio calificacionServicio;

    @PostMapping("/CrearCalificacion")
    public ResponseEntity<MensajeDTO> crearCalificacion(@Valid @RequestBody CalificacionDTO calificacionDTO) throws Exception{
        calificacionServicio.crearCalificacion(calificacionDTO);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Calificacion creada con exito"
        ));
    }

    @GetMapping("/all")
    public ResponseEntity<MensajeDTO> listarCalificaciones(@RequestParam Long idProducto) throws Exception {
        List<CalificacionGetDTO> calificaciones = calificacionServicio.listarCalificaciones(idProducto);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                calificaciones
        ));
    }

    @GetMapping("/{idCalificacion}")
    public ResponseEntity<MensajeDTO> obtenerCalificacion(@PathVariable Long idCalificacion) throws Exception {
        CalificacionGetDTO calificacionGetDTO = calificacionServicio.obtenerCalificacionId(idCalificacion);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                calificacionGetDTO
        ));
    }




}
