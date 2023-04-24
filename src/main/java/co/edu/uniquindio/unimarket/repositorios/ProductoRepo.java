package co.edu.uniquindio.unimarket.repositorios;

import co.edu.uniquindio.unimarket.entidades.Categoria;
import co.edu.uniquindio.unimarket.entidades.EstadoProducto;
import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long> {
    @Query("select p from Producto p " +
            "where p.estadoProducto = co.edu.uniquindio.unimarket.entidades.EstadoProducto.AUTORIZADO " +
            "and p.fechaLimite >= current date ")
    List<Producto> listarProductos(Pageable pageable);
    @Query("select p from Producto p " +
            "where p.nombre like concat('%', :busqueda, '%') " +
            "and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.EstadoProducto.AUTORIZADO " +
            "and p.fechaLimite >= current date ")
    List<Producto> listarProductosBusqueda(String busqueda, Pageable pageable);
    @Query("select p from Producto p " +
            "where p.nombre like concat('%', :busqueda, '%') " +
            "and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.EstadoProducto.AUTORIZADO " +
            "and p.fechaLimite >= current date " +
            "order by p.precio asc ")
    List<Producto> listarProductosBusquedaOrdPrecioAsc(String busqueda, Pageable pageable);
    @Query("select p from Producto p " +
            "where p.nombre like concat('%', :busqueda, '%') " +
            "and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.EstadoProducto.AUTORIZADO " +
            "and p.fechaLimite >= current date " +
            "order by p.precio desc ")
    List<Producto> listarProductosBusquedaOrdPrecioDesc(String busqueda, Pageable pageable);
    @Query("select p from Producto p " +
            "where p.nombre like concat('%', :busqueda, '%') " +
            "and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.EstadoProducto.AUTORIZADO " +
            "and p.fechaLimite >= current date " +
            "order by p.fechaCreacion asc ")
    List<Producto> listarProductosBusquedaOrdFechaAsc(String busqueda, Pageable pageable);
    @Query("select p from Producto p " +
            "where p.nombre like concat('%', :busqueda, '%') " +
            "and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.EstadoProducto.AUTORIZADO " +
            "and p.fechaLimite >= current date " +
            "order by p.fechaCreacion desc ")
    List<Producto> listarProductosBusquedaOrdFechaDesc(String busqueda, Pageable pageable);
    @Query("select p,avg(c.calificacion) as prom " +
            "from Producto p join p.calificaciones c " +
            "where p.nombre like concat('%', :busqueda, '%')" +
            "group by p.idProducto " +
            "order by prom desc ")
    List<Object[]> listarCalificaciones(String busqueda, Pageable pageable);
    @Query("select p from Producto p " +
            "where :categoria member of p.categorias " +
            "and p.estadoProducto = co.edu.uniquindio.unimarket.entidades.EstadoProducto.AUTORIZADO " +
            "and p.fechaLimite >= current date ")
    List<Producto> listarProductosCategoria(Categoria categoria, Pageable pageable);
    @Query("select p from Producto p where p.estadoProducto = :estado")
    List<Producto> listarProductosEstado(EstadoProducto estado, Pageable pageable);
    @Query("select p from Producto p where p.idProducto = :idProducto and p.usuario.idPersona = :idUsuario")
    Producto obtenerProductoIdProductoIdUsuario(Long idProducto, Long idUsuario);

    @Query("select p from Producto p where p.usuario.idPersona = :idUsuario")
    List<Producto> listarProductosPorUsuario(Long idUsuario, Pageable pageable);
}