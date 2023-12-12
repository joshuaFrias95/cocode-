CREATE TABLE usuarios (
    usuario_id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    email VARCHAR(75) NOT NULL UNIQUE,
    password VARCHAR(250) NOT NULL,
    pais INT,
    descripcion VARCHAR(200),
    puesto VARCHAR(75),
    avatar VARCHAR(250),
    puntos INT NOT NULL DEFAULT 50,
    fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activo BIT(1) NULL DEFAULT 1,

    PRIMARY KEY(usuario_id),
    FOREIGN KEY (pais) REFERENCES paises(pais_id)
) ENGINE=InnoDB;


