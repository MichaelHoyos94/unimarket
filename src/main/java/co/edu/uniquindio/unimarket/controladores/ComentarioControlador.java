package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CalificacionGetDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
@AllArgsConstructor
public class ComentarioControlador {
    private final ComentarioServicio comentarioServicio;

    @PostMapping("/crearComentario")
    public ResponseEntity<MensajeDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception{
        comentarioServicio.crearComentario(comentarioDTO);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Comentario creado exitosamente."
        ));
    }
    @GetMapping("/all")
    public ResponseEntity<MensajeDTO> listarComentarios(@RequestParam Long idProducto) throws Exception {
        List<ComentarioGetDTO> comentarios = comentarioServicio.listarComentariosProducto(idProducto);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                comentarios
        ));
    }

    @GetMapping("/{idComentario}")
    public ResponseEntity<MensajeDTO> obtenerComentario(@PathVariable Long idComentario) throws Exception {
        ComentarioGetDTO comentarioGetDTO = comentarioServicio.obtenerComentarioId(idComentario);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                comentarioGetDTO
        ));
    }



}
