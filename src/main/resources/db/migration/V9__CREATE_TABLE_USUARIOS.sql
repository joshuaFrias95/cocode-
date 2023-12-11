CREATE TABLE usuarios (
    usuario_id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(15) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    mail VARCHAR(75) NOT NULL UNIQUE,
    password VARCHAR(8) NOT NULL,
    pais INT NOT NULL,
    descripcion VARCHAR(200),
    puesto VARCHAR(75),
    avatar VARCHAR(200),
    puntos INT NOT NULL DEFAULT 500,
    activo BIT(1) NULL DEFAULT 1 ,

    PRIMARY KEY(usuario_id),
    FOREIGN KEY (pais) REFERENCES paises(pais_id)
) ENGINE=InnoDB;

