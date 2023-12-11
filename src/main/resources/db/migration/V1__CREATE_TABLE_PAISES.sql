CREATE TABLE paises (
    pais_id  INT NOT NULL AUTO_INCREMENT,
    codigo_pais VARCHAR(5) NOT NULL UNIQUE,
    nombre_pais varchar(75) NOT NULL UNIQUE,

    PRIMARY KEY(pais_id)
) ENGINE=InnoDB;