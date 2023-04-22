package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.servicios.interfaces.EmailServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class EmailServicioTest {
    @Autowired
    private EmailServicio emailServicio;
    @Test
    public void enviarEmail() throws Exception{
        emailServicio.enviarEmail("Prueba email servicio", "FUnciona!!", "maaguirreh@uqvirtual.edu.co");
    }
}
