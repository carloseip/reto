package pe.demo.reto.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.demo.reto.dao.IProductoDAO;
import pe.demo.reto.model.Producto;
import pe.demo.reto.model.dto.ProductoCrearDTO;
import pe.demo.reto.model.dto.ProductoVerDTO;
import pe.demo.reto.service.IProductoService;
import pe.demo.reto.utils.UtilDTOMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductoServiceImpl implements IProductoService {

	private final IProductoDAO dao;
	private final UtilDTOMapper mapper;

	@Override
	public Mono<ProductoVerDTO> verProducto(Long id) {
		return dao.findById(id).map(producto -> mapper.convertToDto(producto));
	}

	@Override
	public Mono<ProductoVerDTO> guardarProducto(ProductoCrearDTO producto) {
		Producto prod = mapper.convertToEntity(producto);
		prod.setEstado(true);
		prod.setIdProducto(null);
		return dao.save(prod).map(prodDao -> mapper.convertToDto(prodDao));
	}

	@Override
	public Mono<ProductoVerDTO> editarProducto(Long id, ProductoCrearDTO producto) {
		Producto prod = mapper.convertToEntity(producto);
		prod.setIdProducto(id);
		return dao.save(prod).map(prodDao -> mapper.convertToDto(prodDao));
	}

	@Override
	public Mono<Void> eliminarProducto(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public Flux<ProductoVerDTO> listarProductos() {
		return dao.findAll().map(t -> mapper.convertToDto(t));
	}
}
