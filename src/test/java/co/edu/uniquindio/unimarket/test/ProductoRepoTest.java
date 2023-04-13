package co.edu.uniquindio.unimarket.test;

import co.edu.uniquindio.unimarket.entidades.Producto;
import co.edu.uniquindio.unimarket.repositorios.ProductoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
public class ProductoRepoTest {
    @Autowired
    private ProductoRepo productoRepo;
}