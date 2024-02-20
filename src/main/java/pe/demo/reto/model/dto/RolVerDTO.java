package pe.demo.reto.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolVerDTO {
	private Long idRol;
	private String descripcion;
	private LocalDate fechaCreacion;
	private LocalDate fechaEdicion;
}
