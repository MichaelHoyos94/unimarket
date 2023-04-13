package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.SubastaDTO;
import co.edu.uniquindio.unimarket.dto.SubastaGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SubastaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class SubastaServicioTest {
    @Autowired
    private SubastaServicio subastaServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearSubasta() throws Exception{
        SubastaDTO subastaDTO = new SubastaDTO();
        subastaDTO.setNombreProducto("Lenovo");
        subastaDTO.setDescripcion("Laptop casi nueva");
        subastaDTO.setFechaLimite(LocalDate.now().plusDays(30));
        subastaDTO.setValorInicial(450000);
        subastaDTO.setIdUsuario(1l);
        Long idCreado = subastaServicio.crearSubasta(subastaDTO);
        SubastaGetDTO subastaGetDTO = subastaServicio.buscarSubastaId(idCreado);
        System.out.println("La subasta: " + subastaGetDTO);
        Assertions.assertNotNull(subastaServicio.buscarSubastaId(idCreado));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSubastas() throws Exception{
        List<SubastaGetDTO> subastas = subastaServicio.listarSubastas(0);
        subastas.forEach(System.out::println);
        Assertions.assertEquals(false, subastas.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSubastasBusqueda() throws Exception{
        List<SubastaGetDTO> subastas = subastaServicio.listarSubastasBusqueda("Iphone", 0);
        subastas.forEach(System.out::println);
        Assertions.assertEquals(false, subastas.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSubastasBusquedaOrdValorAsc() throws Exception{
        List<SubastaGetDTO> subastas = subastaServicio.listarSubastasBusquedaOrdValorAsc("Iphone", 0);
        subastas.forEach(System.out::println);
        Assertions.assertEquals(false, subastas.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSubastasBusquedaOrdValorDesc() throws Exception{
        List<SubastaGetDTO> subastas = subastaServicio.listarSubastasBusquedaOrdValorDesc("Iphone", 0);
        subastas.forEach(System.out::println);
        Assertions.assertEquals(false, subastas.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSubastasBusquedaPorCerrar(){
        List<SubastaGetDTO> subastas = subastaServicio.listarSubastasBusquedaPorCerrar("Iphone", 0);
        subastas.forEach(System.out::println);
        Assertions.assertEquals(false, subastas.isEmpty());
    }
}