package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ModeracionDTO;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.servicios.ModeracionServicio;
import co.edu.uniquindio.unimarket.servicios.ProductoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class ModeracionServicioTest {
    @Autowired
    private ModeracionServicio moderacionServicio;
    @Autowired
    private ProductoServicio productoServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void moderarProducto() throws Exception{
        ModeracionDTO moderacionDTO = new ModeracionDTO();
        moderacionDTO.setIdProducto(1l);
        moderacionDTO.setIdModerador(1l);
        moderacionDTO.setEstadoProducto(EstadoProducto.RECHAZADO);
        Assertions.assertNotNull(moderacionServicio.moderarProducto(moderacionDTO));
        Assertions.assertEquals(moderacionDTO.getEstadoProducto(), productoServicio.obtenerProductoId(moderacionDTO.getIdProducto()).getEstadoProducto());
    }
}