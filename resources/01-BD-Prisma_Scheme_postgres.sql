CREATE TABLE preferencias(
    id SERIAL,
    hijos varchar(20),
    tipo_relacion varchar(20),
    diferencia_edad smallint,
    PRIMARY KEY (id)
);

CREATE TABLE usuario(
    id SERIAL,
    primer_nombre varchar(20) NOT NULL,
    segundo_nombre varchar(20),
    primer_apellido varchar(20) NOT NULL,
    segundo_apellido varchar(20),
    id_preferencias INTEGER,
    ubicacion varchar(20),
    fecha_nacimiento Date,
    email varchar(50),
    contrasena varchar(50),
    PRIMARY KEY (id)
);

CREATE TABLE preferencias_usuario(
    id_usuario INTEGER,
    id_preferencias INTEGER,
    CONSTRAINT FK_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    CONSTRAINT FK_preferencias FOREIGN KEY (id_preferencias) REFERENCES preferencias(id)

);


CREATE TABLE mensajes(
    id SERIAL,
    id_remitente INTEGER,
    id_destinatario INTEGER,
    contenido varchar(50),
    estado BOOLEAN,
    fecha_envio timestamp,
    CONSTRAINT FK_remitente FOREIGN KEY (id_remitente) REFERENCES usuario(id),
    CONSTRAINT FK_destinatario FOREIGN KEY (id_destinatario) REFERENCES usuario(id),
    PRIMARY KEY (id)

);

CREATE TABLE match(
    id SERIAL,
    id_persona1 INTEGER,
    id_persona2 INTEGER,
    estado BOOLEAN,
    CONSTRAINT FK_persona1 FOREIGN KEY (id_persona1) REFERENCES usuario(id),
    CONSTRAINT FK_persona2 FOREIGN KEY (id_persona2) REFERENCES usuario(id),
    PRIMARY KEY(id)
);





