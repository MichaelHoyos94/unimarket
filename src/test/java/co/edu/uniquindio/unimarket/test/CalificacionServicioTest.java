package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.CalificacionDTO;
import co.edu.uniquindio.unimarket.dto.CalificacionGetDTO;
import co.edu.uniquindio.unimarket.servicios.CalificacionServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class CalificacionServicioTest {
    @Autowired
    private CalificacionServicio calificacionServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void crearCalificacion() throws Exception{
        CalificacionDTO nuevaCalificacion = new CalificacionDTO();
        nuevaCalificacion.setCalificacion(4.5f);
        nuevaCalificacion.setIdUsuario(1L);
        nuevaCalificacion.setIdProducto(5L);
        Long idCreado = calificacionServicio.crearCalificacion(nuevaCalificacion);
        Assertions.assertEquals(9, idCreado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarCalificaciones() throws Exception {
        List<CalificacionGetDTO> calificacionesGetDTO = calificacionServicio.listarCalificaciones(10l);
        boolean esVacio = calificacionesGetDTO == null;
        Assertions.assertEquals(false, esVacio);
        for (CalificacionGetDTO calificacionGetDTO: calificacionesGetDTO) {
            System.out.println(calificacionGetDTO);
        }
    }
}