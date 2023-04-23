package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Long> {
    @Query("select c from Compra c where c.idCompra = :idCompra ")
    Compra getCompraById(Long idCompra);

    @Query("select c from Compra c where c.usuario.idPersona = :idUsuario")
    List<Compra> listarComprasUsuario(Long idUsuario);
}
