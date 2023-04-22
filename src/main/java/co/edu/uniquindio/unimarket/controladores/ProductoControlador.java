package co.edu.uniquindio.unimarket.controladores;

import co.edu.uniquindio.unimarket.dto.MensajeDTO;
import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto")
@AllArgsConstructor
public class ProductoControlador {
    private final ProductoServicio productoServicio;
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) throws Exception{
        productoServicio.crearProducto(productoDTO);
        return ResponseEntity.status(201).body(new MensajeDTO<>(
                HttpStatus.CREATED,
                false,
                "Producto creado con exito."
        ));
    }
    @GetMapping("/productos/all")
    public ResponseEntity<MensajeDTO> listarProductos(@RequestParam int page) throws Exception{
        System.out.println(page);
        List<ProductoGetDTO> productos = productoServicio.listarProductos(page);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                productos
        ));
    }
    @GetMapping("/productos/{categoria}")
    public ResponseEntity<MensajeDTO> listarProductosCategoria(@PathVariable Categoria categoria, @RequestParam int page) throws Exception{
        List<ProductoGetDTO> productos = productoServicio.listarProductosCategorias(categoria, page);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                productos
        ));
    }
    @GetMapping("/productos")
    public ResponseEntity<MensajeDTO> listarProductosBusqueda(@RequestParam String busqueda, @RequestParam @Nullable String sort, @RequestParam int page) throws Exception{
        System.out.println(sort);
        List<ProductoGetDTO> productos = productoServicio.listarProductosBusqueda(busqueda, sort, page);
        return ResponseEntity.status(200).body(new MensajeDTO<>(
                HttpStatus.OK,
                false,
                productos
        ));
    }
}