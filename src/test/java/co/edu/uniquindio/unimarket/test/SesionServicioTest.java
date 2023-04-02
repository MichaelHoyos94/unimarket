package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
public class SesionServicioTest {
    @Autowired
    private SesionServicio sesionServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void login(){
        String email = "lhoyos@gmail.com";
        String password = "1234";
        try {
            TokenDTO tokenDTO = sesionServicio.login(email, password);
            System.out.println(tokenDTO.getToken());
            Assertions.assertNotNull(tokenDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}