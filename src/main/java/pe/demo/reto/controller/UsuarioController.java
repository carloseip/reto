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
import pe.demo.reto.model.dto.UsuarioAccesoDTO;
import pe.demo.reto.model.dto.UsuarioCrearDTO;
import pe.demo.reto.model.dto.UsuarioLoginDTO;
import pe.demo.reto.model.dto.UsuarioVerDTO;
import pe.demo.reto.service.IUsuarioService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

	private final IUsuarioService service;

    @GetMapping
    Flux<UsuarioVerDTO> getUsuarios() {
        return service.listarUsuarios();
    }
	
	@GetMapping("{id}")
    Mono<UsuarioVerDTO> getUsuario(@PathVariable("id") Long id) {
        return service.verUsuario(id);
    }
	
    @PostMapping
    Mono<UsuarioVerDTO> postUsuario(@RequestBody UsuarioCrearDTO usuario) {
        return service.guardarUsuario(usuario);
    }

    @PutMapping("{id}")
    Mono<UsuarioVerDTO> putUsuario(@PathVariable("id") Long id, @RequestBody UsuarioCrearDTO usuario) {
        return service.editarUsuario(id, usuario);
    }

    @DeleteMapping("{id}")
    Mono<Void> deleteCar(@PathVariable("id") Long id) {
        return service.eliminarUsuario(id);
    }
	
    @PostMapping("login")
    Mono<UsuarioAccesoDTO> loginUsuario(@RequestBody UsuarioLoginDTO usuario) {
        return service.loginUsuario(usuario) ;
    }
}
