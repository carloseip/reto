package pe.demo.reto.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAccesoDTO {

	private Long idUsuario;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String documentoIdent;
	private int celular;
	private String direccion;
	private LocalDate fechaNacimiento;
	private String correo;
	private String nombreUsuario;
	private String token;
}
