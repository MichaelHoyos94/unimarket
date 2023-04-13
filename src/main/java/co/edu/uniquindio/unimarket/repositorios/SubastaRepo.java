package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Subasta;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubastaRepo extends JpaRepository<Subasta, Long> {
    @Query("select s from Subasta s where s.nombreProducto like concat('%', :busqueda, '%') ")
    List<Subasta> listarSubastasBusqueda(String busqueda, Pageable pageable);
    @Query("select s from Subasta s where s.nombreProducto like concat('%', :busqueda, '%') order by s.valorInicial asc")
    List<Subasta> listarSubastasBusquedaOrdValorAsc(String busqueda, Pageable pageable);
    @Query("select s from Subasta s where s.nombreProducto like concat('%', :busqueda, '%') order by s.valorInicial desc")
    List<Subasta> listarSubastasBusquedaOrdValorDesc(String busqueda, Pageable pageable);
    @Query("select s from Subasta s where s.nombreProducto like concat('%', :busqueda, '%') order by s.fechaLimite asc ")
    List<Subasta> listarSubastasBusquedaPorCerrar(String busqueda, Pageable pageable);
}