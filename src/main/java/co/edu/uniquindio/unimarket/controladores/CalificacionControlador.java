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
@RequestMapping("api/calificacion")
@AllArgsConstructor
public class CalificacionControlador {

    private final CalificacionServicio calificacionServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearCalificacion(@Valid @RequestBody CalificacionDTO calificacionDTO) throws Exception{
        calificacionServicio.crearCalificacion(calificacionDTO);
        return ResponseEntity.status(201).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Calificacion creada con exito"
        ));
    }
}