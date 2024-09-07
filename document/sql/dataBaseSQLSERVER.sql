
CREATE DATABASE PRUEBA_LOG;

CREATE TABLE persona (
    id_persona INT IDENTITY,
    tipo VARCHAR(50),
    nombres VARCHAR(50),
    ape_paterno VARCHAR(50),
    ape_materno VARCHAR(50),
    fecha_nac DATETIME,
    pais_res VARCHAR(50),
    correo VARCHAR(50),
    CONSTRAINT pk_id_persona PRIMARY KEY (id_persona)
); 

CREATE TABLE blog (
	id_blog INT IDENTITY,
    id_persona INT,
    titulo VARCHAR(50),
    tema VARCHAR(50),
    contenido VARCHAR(50),
    periodicidad VARCHAR(50),
    sw_comentario VARCHAR(1),
    CONSTRAINT pk_id_blog PRIMARY KEY (id_blog)
);

CREATE TABLE comentario (
	id_comentario INT IDENTITY,
	id_blog INT,
    id_persona INT,
    puntuacion INT,
    CONSTRAINT pk_id_comentario PRIMARY KEY (id_comentario)
);

CREATE TABLE his_blog (
	id_his_blog INT IDENTITY,
	id_blog INT,
    id_persona INT,
    titulo VARCHAR(50),
    tema VARCHAR(50),
    contenido VARCHAR(50),
    periodicidad VARCHAR(50),
    sw_comentario VARCHAR(1),
    fecha_nac DATETIME,
    CONSTRAINT pk_id_his_blog PRIMARY KEY (id_his_blog)
);

