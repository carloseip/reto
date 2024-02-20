package pe.demo.reto.dao;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import pe.demo.reto.model.Usuario;
import reactor.core.publisher.Mono;


public interface IUsuarioDAO extends R2dbcRepository<Usuario, Long> {

	public Mono<Usuario> findByNombreUsuarioAndClaveUsuario(String nombreUsuario, String claveUsuario);
	
}
