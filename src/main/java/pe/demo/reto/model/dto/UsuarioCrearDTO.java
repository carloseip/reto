package pe.demo.reto.model.dto;

import java.time.LocalDate;

public record UsuarioCrearDTO(String nombres, String apellidoPaterno, String apellidoMaterno,
		String documentoIdent, int celular, String direccion, LocalDate fechaNacimiento, String correo,
		String nombreUsuario, String claveUsuario, LocalDate fechaCreacion, LocalDate fechaEdicion) {
}
