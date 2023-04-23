package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CompraDTO;
import co.edu.uniquindio.unimarket.dto.CompraGetDTO;
import co.edu.uniquindio.unimarket.dto.DetalleCompraDTO;
import co.edu.uniquindio.unimarket.entidades.MetodoPago;
import co.edu.uniquindio.unimarket.servicios.interfaces.CompraServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@SpringBootTest
public class CompraServicioTest {
    @Autowired
    private CompraServicio compraServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComprasUsuario() throws Exception{
        List<CompraGetDTO> compras = compraServicio.listarCompras(1l);
        compras.forEach(System.out::println);
        Assertions.assertEquals(false, compras.isEmpty());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void  crearCompra() throws  Exception{
        CompraDTO nuevaCompra  = new CompraDTO();
        List<DetalleCompraDTO> listaDetalleCompraDTO = new ArrayList<>();
        DetalleCompraDTO detalleCompraDTO = new DetalleCompraDTO();

        nuevaCompra.setDetalleCompras(listaDetalleCompraDTO);
        nuevaCompra.setMetodoPago(MetodoPago.PAYONEER);
        nuevaCompra.setPrecio(90000);
        nuevaCompra.setIdUsuario(1l);

        Long idCreado = compraServicio.crearCompra(nuevaCompra);
        System.out.println(idCreado);
    }
}