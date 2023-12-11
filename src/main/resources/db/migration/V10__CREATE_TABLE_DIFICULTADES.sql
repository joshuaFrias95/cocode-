CREATE TABLE dificultades (
    dificultad_id INT NOT NULL AUTO_INCREMENT,
    nombre_dificultad VARCHAR(15) NOT NULL UNIQUE,

    PRIMARY KEY(dificultad_id)
) ENGINE=InnoDB;