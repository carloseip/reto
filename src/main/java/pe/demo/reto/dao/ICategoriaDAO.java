package pe.demo.reto.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import pe.demo.reto.model.Categoria;

public interface ICategoriaDAO extends R2dbcRepository<Categoria, Long> {

}
