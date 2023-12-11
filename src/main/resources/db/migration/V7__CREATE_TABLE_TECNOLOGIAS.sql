CREATE TABLE tecnologias (
    tecnologia_id INT NOT NULL AUTO_INCREMENT,
    nombre_tecnologia VARCHAR(15) NOT NULL UNIQUE,

    PRIMARY KEY(tecnologia_id)
) ENGINE=InnoDB;