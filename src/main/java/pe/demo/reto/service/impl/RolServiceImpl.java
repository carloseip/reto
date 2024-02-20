package pe.demo.reto.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.demo.reto.dao.IRolDAO;
import pe.demo.reto.model.Rol;
import pe.demo.reto.model.dto.RolCrearDTO;
import pe.demo.reto.model.dto.RolVerDTO;
import pe.demo.reto.service.IRolService;
import pe.demo.reto.utils.UtilDTOMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class RolServiceImpl implements IRolService{

	private final IRolDAO dao;
	private final UtilDTOMapper mapper;

	@Override
	public Mono<RolVerDTO> verRol(Long idRol) {
		return dao.findById(idRol).map(rol -> mapper.convertToDto(rol));
	}

	@Override
	public Mono<RolVerDTO> guardarRol(RolCrearDTO rolCrear) {
		Rol rol = mapper.convertToEntity(rolCrear);
		rol.setEstado(true);
		return dao.save(rol).map(rolDao -> mapper.convertToDto(rolDao));
	}

	@Override
	public Mono<RolVerDTO> editarRol(Long idRol, RolCrearDTO rolCrear) {
		Rol rol = mapper.convertToEntity(rolCrear);
		rol.setIdRol(idRol);
		return dao.save(rol).map(rolDao -> mapper.convertToDto(rolDao));
	}

	@Override
	public Mono<Void> eliminarRol(Long idRol) {
		return dao.deleteById(idRol);
	}

	@Override
	public Flux<RolVerDTO> listarRoles() {
		return dao.findAll().map(t -> mapper.convertToDto(t));
	}

}
