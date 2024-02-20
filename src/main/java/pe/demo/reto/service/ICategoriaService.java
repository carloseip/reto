package pe.demo.reto.service;

import pe.demo.reto.model.dto.CategoriaCrearDTO;
import pe.demo.reto.model.dto.CategoriaVerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICategoriaService {

	Mono<CategoriaVerDTO> verCategoria(Long id);
	Mono<CategoriaVerDTO> guardarCategoria(CategoriaCrearDTO categoria);
    Mono<CategoriaVerDTO> editarCategoria(Long id, CategoriaCrearDTO categoria);
    Mono<Void> eliminarCategoria(Long id);
    Flux<CategoriaVerDTO> listarCategorias();
}
