package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.dto.*;
import co.edu.uniquindio.unimarket.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class UsuarioServicioTest {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuario() throws Exception{
        UsuarioDTO nuevoUsuario = new UsuarioDTO("Jessica", "jess@gmail.com", "1094967777", "Armenia", "Cra 11 Cll 6", "3119900000", "jbkvyvubiukvghvjjlughchgvh");
        UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuarioId(usuarioServicio.registrarUsuario(nuevoUsuario));
        System.out.println(usuarioGetDTO.getIdUsuario());
        Assertions.assertNotNull(nuevoUsuario);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarUsuario() throws Exception{
        UsuarioGetDTO oldUser = usuarioServicio.obtenerUsuarioId(1l);
        System.out.println(oldUser);
        UsuarioActualizarDTO nuevosDatos = new UsuarioActualizarDTO();
        nuevosDatos.setNombre("Martha");
        nuevosDatos.setCiudad("Medellin");
        nuevosDatos.setCedula("1094904781");
        nuevosDatos.setDireccion("Av bolivar");
        nuevosDatos.setTelefono("3218005576");
        nuevosDatos.setEmail("martha@gmail.com");
        UsuarioGetDTO newUser = usuarioServicio.obtenerUsuarioId(usuarioServicio.actualizarUsuario(1l, nuevosDatos));
        System.out.println(newUser);
        Assertions.assertNotEquals(oldUser, newUser);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void reestablecerPassword() throws Exception{
        Long idUsuario = usuarioServicio.reestablecerPassword(new RecuperarPassDTO("joaquin@gmail.com", "1234", "1234"));
        Assertions.assertEquals("4321", usuarioServicio.obtenerUsuarioId(idUsuario).getPassword());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerUsuario() throws Exception{
        UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuarioId(1l);
        System.out.println(usuarioGetDTO);
        Assertions.assertNotNull(usuarioGetDTO);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void marcarFavorito() throws Exception{
        boolean exitoso = usuarioServicio.marcarFavorito(1l, 2l);
        Assertions.assertEquals(true, exitoso);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void desmarcarFavorito() throws Exception{

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarFavoritos() throws Exception{
        List<ProductoGetDTO> listaFavoritos = usuarioServicio.listarFavoritos(1l);
        System.out.println(listaFavoritos);
        Assertions.assertEquals(false, listaFavoritos.isEmpty());
    }
}