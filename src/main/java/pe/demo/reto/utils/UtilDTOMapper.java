package pe.demo.reto.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.stereotype.Service;

import pe.demo.reto.model.Categoria;
import pe.demo.reto.model.Producto;
import pe.demo.reto.model.Rol;
import pe.demo.reto.model.Usuario;
import pe.demo.reto.model.dto.CategoriaCrearDTO;
import pe.demo.reto.model.dto.CategoriaVerDTO;
import pe.demo.reto.model.dto.ProductoCrearDTO;
import pe.demo.reto.model.dto.ProductoVerDTO;
import pe.demo.reto.model.dto.RolCrearDTO;
import pe.demo.reto.model.dto.RolVerDTO;
import pe.demo.reto.model.dto.UsuarioAccesoDTO;
import pe.demo.reto.model.dto.UsuarioCrearDTO;
import pe.demo.reto.model.dto.UsuarioVerDTO;

@Service
public class UtilDTOMapper {

	private final ModelMapper modelMapper = new ModelMapper();
	private final ModelMapper modelMapperRecord = new ModelMapper().registerModule(new RecordModule());
	
	public UsuarioVerDTO convertToDto(Usuario user) {
		return modelMapper.map(user, UsuarioVerDTO.class);
	}
	
	public UsuarioAccesoDTO convertToDtoLogin(Usuario user) {
		return modelMapper.map(user, UsuarioAccesoDTO.class);
	}
	
	public RolVerDTO convertToDto(Rol rol) {
		return modelMapper.map(rol, RolVerDTO.class);
	}
	
	public CategoriaVerDTO convertToDto(Categoria categoria) {
		return modelMapper.map(categoria, CategoriaVerDTO.class);
	}
	
	public ProductoVerDTO convertToDto(Producto producto) {
		return modelMapper.map(producto, ProductoVerDTO.class);
	}

	public Usuario convertToEntity(UsuarioCrearDTO usuarioCrearDTO) {
		return modelMapperRecord.map(usuarioCrearDTO, Usuario.class);
	}

	public Rol convertToEntity(RolCrearDTO rolCrearDTO) {
		return modelMapperRecord.map(rolCrearDTO, Rol.class);
	}

	public Categoria convertToEntity(CategoriaCrearDTO categoriaCrearDTO) {
		return modelMapperRecord.map(categoriaCrearDTO, Categoria.class);
	}

	public Producto convertToEntity(ProductoCrearDTO productoCrearDTO) {
		return modelMapperRecord.map(productoCrearDTO, Producto.class);
	}
}
