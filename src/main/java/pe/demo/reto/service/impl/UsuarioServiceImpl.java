package pe.demo.reto.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.demo.reto.dao.IUsuarioDAO;
import pe.demo.reto.model.Usuario;
import pe.demo.reto.model.dto.UsuarioAccesoDTO;
import pe.demo.reto.model.dto.UsuarioCrearDTO;
import pe.demo.reto.model.dto.UsuarioLoginDTO;
import pe.demo.reto.model.dto.UsuarioVerDTO;
import pe.demo.reto.service.IUsuarioService;
import pe.demo.reto.utils.JWTUtil;
import pe.demo.reto.utils.UtilDTOMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements IUsuarioService {

	private final IUsuarioDAO dao;
	private final UtilDTOMapper mapper;
    private final JWTUtil jwtUtil;

	@Override
	public Mono<UsuarioVerDTO> verUsuario(Long idUsuario) {
		return dao.findById(idUsuario).map(t -> mapper.convertToDto(t));
	}

	@Override
	public Mono<UsuarioVerDTO> guardarUsuario(UsuarioCrearDTO usuario) {
		Usuario user = mapper.convertToEntity(usuario);
		return dao.save(user).map(t -> mapper.convertToDto(t));
	}

	@Override
	public Mono<UsuarioVerDTO> editarUsuario(Long idUsuario, UsuarioCrearDTO usuario) {
		Usuario user = mapper.convertToEntity(usuario);
		user.setIdUsuario(idUsuario);
		return dao.save(user).map(t -> mapper.convertToDto(t));
	}

	@Override
	public Mono<Void> eliminarUsuario(Long idUsuario) {
		return dao.deleteById(idUsuario);
	}

	@Override
	public Flux<UsuarioVerDTO> listarUsuarios() {
		return dao.findAll().map(t -> mapper.convertToDto(t));
	}

	@Override
	public Mono<UsuarioAccesoDTO> loginUsuario(UsuarioLoginDTO usuario) {
		return dao.findByNombreUsuarioAndClaveUsuario(usuario.getNombreUsuario(), usuario.getClaveUsuario())
				.map(t -> validarAcceso(t));
	}

	private UsuarioAccesoDTO validarAcceso(Usuario user) {
		UsuarioAccesoDTO usuario = mapper.convertToDtoLogin(user);
		if(usuario!=null) {
			usuario.setToken(jwtUtil.generateToken(user.getNombreUsuario()));
		}
		return usuario;
	}

}
