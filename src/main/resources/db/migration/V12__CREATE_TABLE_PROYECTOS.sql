CREATE TABLE proyectos (
    proyecto_id INT NOT NULL AUTO_INCREMENT,
    nombre_proyecto VARCHAR(25) NOT NULL,
    descripcion_proyecto VARCHAR(250) NOT NULL,
    avatar VARCHAR(250),
    fecha_registro_proyecto DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activo BIT(1) NULL DEFAULT 1,

    PRIMARY KEY(proyecto_id)
) ENGINE=InnoDB;


