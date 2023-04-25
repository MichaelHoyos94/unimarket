package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private final SesionServicio sesionServicio;
    private final UsuarioServicio usuarioServicio;
    @PostMapping("/login")
    public ResponseEntity<MensajeDTO> login (@Valid @RequestBody SesionDTO sesionDTO) throws Exception{
        TokenDTO jwtTokenDTO = sesionServicio.login(sesionDTO);
        return ResponseEntity.status(200).body(new MensajeDTO(
                HttpStatus.OK,
                false,
                jwtTokenDTO));
    }
    @PostMapping("/registrar")
    ResponseEntity<MensajeDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception{
        usuarioServicio.registrarUsuario((usuarioDTO));
        return ResponseEntity.status(201).body(new MensajeDTO(HttpStatus.CREATED, false, "Registro exitoso."));
    }
}
