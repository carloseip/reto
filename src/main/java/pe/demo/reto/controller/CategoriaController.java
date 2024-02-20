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
import pe.demo.reto.model.dto.CategoriaCrearDTO;
import pe.demo.reto.model.dto.CategoriaVerDTO;
import pe.demo.reto.service.ICategoriaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

	private final ICategoriaService service;

    @GetMapping
    Flux<CategoriaVerDTO> getCategorias() {
        return service.listarCategorias();
    }
	
	@GetMapping("{id}")
    Mono<CategoriaVerDTO> getCategoria(@PathVariable("id") Long id) {
        return service.verCategoria(id);
    }
	
    @PostMapping
    Mono<CategoriaVerDTO> postCategoria(@RequestBody CategoriaCrearDTO categoria) {
        return service.guardarCategoria(categoria);
    }

    @PutMapping("{id}")
    Mono<CategoriaVerDTO> putCategoria(@PathVariable("id") Long id, @RequestBody CategoriaCrearDTO categoria) {
        return service.editarCategoria(id, categoria);
    }

    @DeleteMapping("{id}")
    Mono<Void> deleteCategoria(@PathVariable("id") Long id) {
        return service.eliminarCategoria(id);
    }
}
