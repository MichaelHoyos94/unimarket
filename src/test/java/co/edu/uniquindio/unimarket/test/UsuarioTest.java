package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarUsuario(){
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCedula("1094934040");
        nuevoUsuario.setEmail("joosorio@outlook.com");
        nuevoUsuario.setNombre("Johana");
        nuevoUsuario.setPassword("1234");
        nuevoUsuario.setCiudad("Armenia");
        nuevoUsuario.setDireccion("Cll 12 Cra 15");
        nuevoUsuario.setTelefono("3218095133");
        Usuario usuarioRegistrado = usuarioRepo.save(nuevoUsuario);
        Assertions.assertEquals(usuarioRegistrado, usuarioRepo.obtenerUsuarioId(usuarioRegistrado.getIdPersona()));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuarios(){
        List<Usuario> usuarios = usuarioRepo.findAll();
        usuarios.forEach(System.out::println);
    }
}