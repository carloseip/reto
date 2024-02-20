package pe.demo.reto.service;

import pe.demo.reto.model.dto.RolCrearDTO;
import pe.demo.reto.model.dto.RolVerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IRolService {

	Mono<RolVerDTO> verRol(Long idRol);
	Mono<RolVerDTO> guardarRol(RolCrearDTO rol);
    Mono<RolVerDTO> editarRol(Long idRol, RolCrearDTO rol);
    Mono<Void> eliminarRol(Long idRol);
    Flux<RolVerDTO> listarRoles();
}
