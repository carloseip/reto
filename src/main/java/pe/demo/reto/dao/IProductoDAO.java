package pe.demo.reto.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import pe.demo.reto.model.Producto;

public interface IProductoDAO extends R2dbcRepository<Producto, Long> {

}
