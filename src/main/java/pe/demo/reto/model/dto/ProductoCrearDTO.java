package pe.demo.reto.model.dto;

import java.time.LocalDate;

public record ProductoCrearDTO(String descripcion, double precio, LocalDate fechaCreacion, LocalDate fechaEdicion,
		Long idCategoria) {

}
