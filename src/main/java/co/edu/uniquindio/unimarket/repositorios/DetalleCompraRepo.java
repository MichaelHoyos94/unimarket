package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleCompraRepo extends JpaRepository<DetalleCompra, Long> {
    @Query("select dc from DetalleCompra dc where dc.compra.idCompra = :idCompra")
    List<DetalleCompra> getDetalleCompraByIdCompra(Long idCompra);
}
