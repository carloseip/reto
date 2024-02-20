package pe.demo.reto.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table("Usuario")
public class Usuario {

	@Id
	@Column(value = "idusuario")
	private Long idUsuario;
	@Column(value = "nombres")
	private String nombres;
	@Column(value = "apellidopaterno")
	private String apellidoPaterno;
	@Column(value = "apellidomaterno")
	private String apellidoMaterno;
	@Column(value = "documentoident")
	private String documentoIdent;
	@Column(value = "celular")
	private int celular;
	@Column(value = "direccion")
	private String direccion;
	@Column(value = "fechanacimiento")
	private LocalDate fechaNacimiento;
	@Column(value = "correo")
	private String correo;
	@Column(value = "nombreusuario")
	private String nombreUsuario;
	@Column(value = "claveusuario")
	private String claveUsuario;
	@Column(value = "fechacreacion")
	private LocalDate fechaCreacion;
	@Column(value = "fechaedicion")
	private LocalDate fechaEdicion;
}
