package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ProductoDTO;
import co.edu.uniquindio.unimarket.dto.ProductoGetDTO;
import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.interfaces.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ProductoServicioTest {
    @Autowired
    private ProductoServicio productoServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearProducto() throws Exception{
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre("Carro Control Remoto");
        productoDTO.setDescripcion("Es un carro de baterias que funciona a control remoto");
        productoDTO.setPrecio(13000);
        productoDTO.setImagenes(new HashMap<>());
        productoDTO.setFechaLimite(LocalDate.now().plusDays(30));
        productoDTO.setIdUsuario(1L);
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(Categoria.ENTRETENIMIENTO);
        categorias.add(Categoria.CONSOLAS);
        categorias.add(Categoria.VEHICULOS);
        categorias.add(Categoria.DEPORTE);
        productoDTO.setCategoriasList(categorias);
        Long idCreado = productoServicio.crearProducto(productoDTO);
        ProductoGetDTO productoGetDTO = productoServicio.obtenerProductoId(idCreado);
        System.out.println(productoGetDTO);
        Assertions.assertNotNull(productoGetDTO);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductos(){
        List<ProductoGetDTO> productos = productoServicio.listarProductos(0);
        productos.forEach(System.out::println);
        Assertions.assertEquals(false, productos.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosBusqueda(){
        List<ProductoGetDTO> productos = productoServicio.listarProductosBusqueda("ps4", "fechaAsc", 0);
        productos.forEach(System.out::println);
        Assertions.assertEquals(false, productos.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosCategoria(){
        List<ProductoGetDTO> productos = productoServicio.listarProductosCategorias(Categoria.CONSOLAS, 0);
        productos.forEach(System.out::println);
        Assertions.assertEquals(false, productos.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosEstado(){
        List<ProductoGetDTO> productos = productoServicio.listarProductosEstado(EstadoProducto.RECHAZADO, 0);
        productos.forEach(System.out::println);
        Assertions.assertEquals(false, productos.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void marcarFavorito() throws Exception{
        Assertions.assertEquals(true, productoServicio.marcarFavorito(1l, 1l));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void marcarFavoritoDuplicado() throws Exception{
        Assertions.assertEquals(false, productoServicio.marcarFavorito(1l, 10l));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarFavoritos() throws Exception{
        Set<ProductoGetDTO> favoritos = productoServicio.listarFavoritos(1l);
        System.out.println(favoritos);
        Assertions.assertEquals(false, favoritos.isEmpty());
    }
}