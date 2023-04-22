package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
public class SesionServicioTest {
    @Autowired
    private SesionServicio sesionServicio;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    @Sql("classpath:dataset.sql")
    public void login(){
        SesionDTO sesionDTO = new SesionDTO("mario@gmail.com", "1234");
        try {
            TokenDTO tokenDTO = sesionServicio.login(sesionDTO);
            System.out.println(tokenDTO.getToken());
            Assertions.assertNotNull(tokenDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}