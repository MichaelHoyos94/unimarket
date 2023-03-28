package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.UsuarioDTO;
import co.edu.uniquindio.unimarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuario(){
        UsuarioDTO nuevoUsuario = new UsuarioDTO("Jessica", "jess@gmail.com", "1094967777", "Armenia", "Cra 11 Cll 6", "3119900000", "1234");
        try {
            Long id = usuarioServicio.registrarUsuario(nuevoUsuario);
            Assertions.assertEquals(6l, id);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuario(){
        UsuarioDTO nuevosDatos = new UsuarioDTO();
        Long idUsuario = 1l;
        nuevosDatos.setNombre("Martha");
        try {
            Long idActualizado = usuarioServicio.actualizarUsuario(idUsuario, nuevosDatos);
            System.out.println(usuarioServicio.obtenerUsuarioId(idActualizado).getNombre());
            Assertions.assertEquals(nuevosDatos.getNombre(), usuarioServicio.obtenerUsuarioId(idActualizado).getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void reestablecerPassword() throws Exception{
        Long idUsuario = usuarioServicio.reestablecerPassword("lhoyos@gmail.com", "4321", "4321");
        Assertions.assertEquals("4321", usuarioServicio.obtenerUsuarioId(idUsuario).getPassword());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuario() throws Exception{
        UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuarioId(1l);
        System.out.println(usuarioGetDTO);
        Assertions.assertNotNull(usuarioGetDTO);
    }
}