package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.*;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioControlador {
    private final UsuarioServicio usuarioServicio;
    @PutMapping("/actualizar/{id}")
    ResponseEntity<MensajeDTO> actualizarUsuario(@PathVariable Long id,@RequestBody UsuarioActualizarDTO usuarioActualizarDTO) throws Exception{
        usuarioServicio.actualizarUsuario(id, usuarioActualizarDTO);
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK, false, "Actualizado con exito."));
    }
    @GetMapping("/obtener/{idUsuario}")
    ResponseEntity<MensajeDTO> obtenerUsuarioId(@PathVariable Long idUsuario) throws Exception{
        UsuarioGetDTO usuario = usuarioServicio.obtenerUsuarioId(idUsuario);
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK, false, usuario));
    }
    @PutMapping("/recuperarPassword")
    ResponseEntity<MensajeDTO> reestablecerPassword(@RequestBody RecuperarPassDTO recuperarPassDTO) throws Exception{
        usuarioServicio.reestablecerPassword(recuperarPassDTO);
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK, false, "Password recuperado."));
    }

    @GetMapping("/findbyemail/{email}")
    ResponseEntity<MensajeDTO> findbyemail(@PathVariable String email) throws Exception{
        UsuarioGetDTO usuario = usuarioServicio.findByEmail(email);
        return ResponseEntity.status(200).body(new MensajeDTO(HttpStatus.OK, false, usuario));
    }


}
