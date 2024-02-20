package pe.demo.reto.service;

import pe.demo.reto.model.dto.ProductoCrearDTO;
import pe.demo.reto.model.dto.ProductoVerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductoService {

	Mono<ProductoVerDTO> verProducto(Long id);
	Mono<ProductoVerDTO> guardarProducto(ProductoCrearDTO producto);
    Mono<ProductoVerDTO> editarProducto(Long id, ProductoCrearDTO producto);
    Mono<Void> eliminarProducto(Long id);
    Flux<ProductoVerDTO> listarProductos();
}
