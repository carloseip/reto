package pe.demo.reto.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import pe.demo.reto.model.Rol;

public interface IRolDAO extends R2dbcRepository<Rol, Long> {

}
