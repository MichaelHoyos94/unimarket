package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.ComentarioDTO;
import co.edu.uniquindio.unimarket.dto.ComentarioGetDTO;
import co.edu.uniquindio.unimarket.servicios.interfaces.ComentarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@SpringBootTest
public class ComentarioServicioTest {
    @Autowired
    private ComentarioServicio comentarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void listarComentariosProducto() throws Exception{
        List<ComentarioGetDTO> comentariosGetDTO = comentarioServicio.listarComentariosProducto(10l);
        System.out.println(comentariosGetDTO);
        Assertions.assertEquals(false, comentariosGetDTO.isEmpty());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void crearComentario() throws Exception{
        ComentarioDTO comentarioDTO = new ComentarioDTO("Saludos", 1l, 1l);
        Long idCreado = comentarioServicio.crearComentario(comentarioDTO);
        ComentarioGetDTO comentarioGetDTO = comentarioServicio.obtenerComentarioId(idCreado);
        System.out.println(comentarioGetDTO);
        Assertions.assertNotNull(comentarioGetDTO);
    }
}