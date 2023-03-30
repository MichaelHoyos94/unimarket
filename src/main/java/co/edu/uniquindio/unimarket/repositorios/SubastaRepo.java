package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaRepo extends JpaRepository<Subasta, Long> {
    @Query("select s from Subasta s where s.nombreProducto like %:nombreProducto%")
    List<Subasta> listarSubastasProducto(String nombreProducto);
}