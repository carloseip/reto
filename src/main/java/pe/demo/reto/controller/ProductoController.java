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
import pe.demo.reto.model.dto.ProductoCrearDTO;
import pe.demo.reto.model.dto.ProductoVerDTO;
import pe.demo.reto.service.IProductoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/producto")
public class ProductoController {

	private final IProductoService service;

    @GetMapping
    Flux<ProductoVerDTO> getProductos() {
        return service.listarProductos();
    }
	
	@GetMapping("{id}")
    Mono<ProductoVerDTO> getProducto(@PathVariable("id") Long id) {
        return service.verProducto(id);
    }
	
    @PostMapping
    Mono<ProductoVerDTO> postProducto(@RequestBody ProductoCrearDTO producto) {
        return service.guardarProducto(producto);
    }

    @PutMapping("{id}")
    Mono<ProductoVerDTO> putProducto(@PathVariable("id") Long id, @RequestBody ProductoCrearDTO producto) {
        return service.editarProducto(id, producto);
    }

    @DeleteMapping("{id}")
    Mono<Void> deleteProducto(@PathVariable("id") Long id) {
        return service.eliminarProducto(id);
    }
}
