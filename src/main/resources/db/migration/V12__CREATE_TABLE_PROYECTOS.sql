CREATE TABLE usuarios (
    usuario_id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    email VARCHAR(75) NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    pais INT,
    descripcion VARCHAR(200),
    puesto VARCHAR(75),
    avatar VARCHAR,
    puntos INT NOT NULL DEFAULT 50,
    fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activo BIT(1) NULL DEFAULT 1,

    PRIMARY KEY(usuario_id),
    FOREIGN KEY (pais) REFERENCES paises(pais_id)
) ENGINE=InnoDB;

INSERT INTO tecnologias (nombre, apellido, email, password, pais, descripcion, puesto, avatar)
VALUES('Jostin', 'Jerez', 'jostin@admin.com', '$2b$10$cfTzdD5Ze.KKH9cs4TeVlOCtQcSbhzPqwf0HbNtqgTDdjKa3zupjm',
2, 'no se que poner aquí', 'Front-end Dev', 'https://gatosde.com/wp-content/uploads/2016/11/cat-959276_1280.jpg');

