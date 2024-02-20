create table Usuario(
	idUsuario 		SERIAL primary key,
	nombres			VARCHAR(200) not null,
	apellidoPaterno	VARCHAR(200) not null,
	apellidoMaterno	VARCHAR(200) not null,
	documentoIdent	VARCHAR(20) not null,
	celular			INT not null,
	direccion		VARCHAR(500) not null,
	fechaNacimiento	DATE not null,
	correo 			VARCHAR(100) not null,
	nombreUsuario	VARCHAR(50) unique not null,
	claveUsuario	VARCHAR(255) not null,
	fechaCreacion	DATE not null default CURRENT_DATE,
	fechaEdicion	DATE not null default CURRENT_DATE
);

create table Rol(
	idRol			SERIAL primary key,
	descripcion		VARCHAR(100) not null,
	fechaCreacion	DATE not null default CURRENT_DATE,
	fechaEdicion	DATE not null default CURRENT_DATE,
	estado			boolean	not null
);

create table Usuario_Rol(
	idUsuario 		int not null,
	idRol 			int not null,
	foreign key (idUsuario) references Usuario(idUsuario),
	foreign key (idRol) references Rol(idRol),
	primary key (idUsuario, idRol)
);


CREATE TABLE CATEGORIA(
	idCategoria		SERIAL PRIMARY KEY,
    descripcion		VARCHAR(100) NOT NULL,
	fechaCreacion	DATE not null default CURRENT_DATE,
	fechaEdicion	DATE not null default CURRENT_DATE,
	estado			boolean	not null
);

CREATE TABLE PRODUCTO(
	idProducto		SERIAL PRIMARY KEY,
    descripcion		VARCHAR(100) NOT NULL,
    precio			numeric(7,2) NOT NULL,
	fechaCreacion	DATE not null default CURRENT_DATE,
	fechaEdicion	DATE not null default CURRENT_DATE,
	estado			boolean	not null,
    idCategoria		INT NOT NULL,
    FOREIGN KEY (idCategoria) REFERENCES CATEGORIA(idCategoria)
);

-- Usar las credenciales de este usuario para obtener el token JWT y acceder a las apis.
INSERT INTO public.usuario
(idusuario, nombres, apellidopaterno, apellidomaterno, documentoident, celular, direccion, fechanacimiento, correo, nombreusuario, claveusuario, fechacreacion, fechaedicion)
VALUES(1, 'Carlos', 'Inga', 'Principe', '72103514', 925360989, 'Los Cedros E2, Puente Piedra', '1999-10-29', 'ceduardoinga@gmail.com', 'carlosip', 'carlos123', '2024-02-19', '2024-02-19');

