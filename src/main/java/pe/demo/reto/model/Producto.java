package pe.demo.reto.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table("Producto")
public class Producto {
	@Id
	@Column("idProducto")
	private Long idProducto;
	@Column("descripcion")
	private String descripcion;
	@Column("precio")
	private double precio;
	@Column("fechacreacion")
	private LocalDate fechaCreacion;
	@Column("fechaedicion")
	private LocalDate fechaEdicion;
	@Column(value="estado")
	private boolean estado;
	@Column("idCategoria")
	private Long idCategoria;

}
