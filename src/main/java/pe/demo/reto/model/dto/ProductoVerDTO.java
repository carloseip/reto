package pe.demo.reto.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoVerDTO {
	private Long idProducto;
	private String descripcion;
	private double precio;
	private LocalDate fechaCreacion;
	private LocalDate fechaEdicion;
	private Long idCategoria;
}
