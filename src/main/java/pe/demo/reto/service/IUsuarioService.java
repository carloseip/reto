package pe.demo.reto.service;

import pe.demo.reto.model.dto.UsuarioAccesoDTO;
import pe.demo.reto.model.dto.UsuarioCrearDTO;
import pe.demo.reto.model.dto.UsuarioLoginDTO;
import pe.demo.reto.model.dto.UsuarioVerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUsuarioService {

	Mono<UsuarioVerDTO> verUsuario(Long idUsuario);
	Mono<UsuarioVerDTO> guardarUsuario(UsuarioCrearDTO usuario);
    Mono<UsuarioVerDTO> editarUsuario(Long idUsuario, UsuarioCrearDTO usuario);
    Mono<Void> eliminarUsuario(Long idUsuario);
    Flux<UsuarioVerDTO> listarUsuarios();
    Mono<UsuarioAccesoDTO> loginUsuario(UsuarioLoginDTO usuario);
}
