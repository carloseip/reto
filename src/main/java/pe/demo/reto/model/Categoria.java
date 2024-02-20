package pe.demo.reto.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table("Categoria")
public class Categoria {
	@Id
	@Column("idCategoria")
	private Long idCategoria;
	@Column("descripcion")
	private String descripcion;
	@Column("fechacreacion")
	private LocalDate fechaCreacion;
	@Column("fechaedicion")
	private LocalDate fechaEdicion;
	@Column(value="estado")
	private boolean estado;
}
