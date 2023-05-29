package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.entidades.Categoria;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categorias")
@AllArgsConstructor
public class CategoriaController {
    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> listar() throws Exception{
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                Categoria.values()
        ));
    }
}
