package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepo extends JpaRepository<Calificacion, Long> {
    @Query("select c from Calificacion c where c.producto.idProducto = :idProducto")
    List<Calificacion> listarCalificacionesProducto(Long idProducto);
    @Query("select c from Calificacion c where c.producto.idProducto = :idProducto and c.usuario.idPersona = :idUsuario")
    Calificacion obtenerCalificacionProductoUsuario(Long idProducto, Long idUsuario);
}