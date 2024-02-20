package pe.demo.reto.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaVerDTO {
	private Long idCategoria;
	private String descripcion;
	private LocalDate fechaCreacion;
	private LocalDate fechaEdicion;
}
