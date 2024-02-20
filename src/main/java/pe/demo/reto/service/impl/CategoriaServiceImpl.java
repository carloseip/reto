package pe.demo.reto.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.demo.reto.dao.ICategoriaDAO;
import pe.demo.reto.model.Categoria;
import pe.demo.reto.model.dto.CategoriaCrearDTO;
import pe.demo.reto.model.dto.CategoriaVerDTO;
import pe.demo.reto.service.ICategoriaService;
import pe.demo.reto.utils.UtilDTOMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CategoriaServiceImpl implements ICategoriaService {

	private final ICategoriaDAO dao;
	private final UtilDTOMapper mapper;

	@Override
	public Mono<CategoriaVerDTO> verCategoria(Long id) {
		return dao.findById(id).map(categoria -> mapper.convertToDto(categoria));
	}

	@Override
	public Mono<CategoriaVerDTO> guardarCategoria(CategoriaCrearDTO categoria) {
		Categoria cat = mapper.convertToEntity(categoria);
		cat.setEstado(true);
		return dao.save(cat).map(catDao -> mapper.convertToDto(catDao));
	}

	@Override
	public Mono<CategoriaVerDTO> editarCategoria(Long id, CategoriaCrearDTO categoria) {
		Categoria cat = mapper.convertToEntity(categoria);
		cat.setIdCategoria(id);
		return dao.save(cat).map(catDao -> mapper.convertToDto(catDao));
	}

	@Override
	public Mono<Void> eliminarCategoria(Long id) {
		return dao.deleteById(id);
	}

	@Override
	public Flux<CategoriaVerDTO> listarCategorias() {
		return dao.findAll().map(t -> mapper.convertToDto(t));
	}
}
