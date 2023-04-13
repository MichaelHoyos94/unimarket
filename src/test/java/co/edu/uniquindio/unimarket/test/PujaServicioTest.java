package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.PujaDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.PujaServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class PujaServicioTest {
    @Autowired
    private PujaServicio pujaServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearPuja() throws Exception{
        PujaDTO pujaDTO = new PujaDTO();
        pujaDTO.setIdSubasta(1l);
        pujaDTO.setIdUsuario(1l);
        pujaDTO.setValorPuja(1500000);
        Long idCreado = pujaServicio.crearPuja(pujaDTO);
        Assertions.assertNotNull(pujaServicio.obtenerPujaId(idCreado));
    }
}
