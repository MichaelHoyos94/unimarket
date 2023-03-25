package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    @Query("select u from Usuario u where u.idPersona = :idUsuario")
    Usuario obtenerUsuarioId(Long idUsuario);
    @Transactional
    @Modifying
    @Query("update Usuario u set u.nombre = :nombre where u.idPersona = :idUsuario")
    void actualizarUsuario(Long idUsuario, String nombre);
    Usuario findByEmail(String email);
    Usuario findByEmailAndPassword(String email, String password);
}