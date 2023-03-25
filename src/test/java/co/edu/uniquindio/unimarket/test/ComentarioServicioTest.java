package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.ComentarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ComentarioServicioTest {
    @Autowired
    private ComentarioServicio comentarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosProducto(){
        try {
            //List<ComentarioGetDTO> comentariosGetDTO = comentarioServicio.listarComentariosProducto(1l);
            //comentariosGetDTO.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}