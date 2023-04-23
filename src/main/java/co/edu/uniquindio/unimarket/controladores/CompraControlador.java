package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.entidades.Compra;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
@AllArgsConstructor
public class CompraControlador {

    private final CompraServicio compraServicio;

    @PostMapping("/crear")
    public Long crearCompra(@RequestBody CompraDTO compraDTO) throws Exception{

        return compraServicio.crearCompra(compraDTO);

    }

    /*@GetMapping("/listar/{idUsuario}")
    public List<CompraGetDTO> listarCompras (@PathVariable Long idUsuario) throws Exception{
        return compraServicio.listarCompras(idUsuario);
    }*/

    @GetMapping("/obtener/{idCompra}")
    public Compra obtenerCompraObj(@PathVariable Long idCompra) throws Exception{
        return compraServicio.obtenerCompraObj(idCompra);
    }
}
