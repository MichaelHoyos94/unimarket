package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    @Query("select u from Usuario u where u.idPersona = :idUsuario")
    Usuario obtenerUsuarioId(Long idUsuario);
    @Query("select u.favoritos from Usuario u where u.idPersona = :idUsuario")
    List<Producto> listarFavoritos(Long idUsuario);
    @Transactional
    @Modifying
    @Query("update Usuario u set u.nombre = :nombre where u.idPersona = :idUsuario")
    void actualizarUsuario(Long idUsuario, String nombre);
    @Query("select u from Usuario u where u.email = :email")
    Usuario findByEmail(String email);
    Usuario findByCedula(String cedula);
    Usuario findByEmailAndPassword(String email, String password);
}