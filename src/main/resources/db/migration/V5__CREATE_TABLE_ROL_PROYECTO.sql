CREATE TABLE rol_proyecto (
    proyecto_id INT NOT NULL AUTO_INCREMENT,
    nombre_rol_proyecto VARCHAR(15) NOT NULL UNIQUE,

    PRIMARY KEY(proyecto_id)
) ENGINE=InnoDB;