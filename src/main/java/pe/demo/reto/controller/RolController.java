package pe.demo.reto.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.demo.reto.model.dto.RolCrearDTO;
import pe.demo.reto.model.dto.RolVerDTO;
import pe.demo.reto.service.IRolService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/rol")
public class RolController {

	private final IRolService service;

    @GetMapping
    Flux<RolVerDTO> getRoles() {
        return service.listarRoles();
    }
	
	@GetMapping("{id}")
    Mono<RolVerDTO> getRol(@PathVariable("id") Long id) {
        return service.verRol(id);
    }
	
    @PostMapping
    Mono<RolVerDTO> postRol(@RequestBody RolCrearDTO rol) {
        return service.guardarRol(rol);
    }

    @PutMapping("{id}")
    Mono<RolVerDTO> putRol(@PathVariable("id") Long id, @RequestBody RolCrearDTO rol) {
        return service.editarRol(id, rol);
    }

    @DeleteMapping("{id}")
    Mono<Void> deleteRol(@PathVariable("id") Long id) {
        return service.eliminarRol(id);
    }
}
