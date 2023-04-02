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
        List<SubastaGetDTO> subastasGetDTO = subastaServicio.listarSubastas();
        boolean esVacia = subastasGetDTO.isEmpty();
        System.out.println(subastasGetDTO);
        Assertions.assertEquals(false, esVacia);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarSubastasProducto() throws Exception{
        List<SubastaGetDTO> subastasGetDTO = subastaServicio.listarSubastasNombre("Iphone");
        System.out.println(subastasGetDTO);
        Assertions.assertEquals(false, subastasGetDTO.isEmpty());
    }
}