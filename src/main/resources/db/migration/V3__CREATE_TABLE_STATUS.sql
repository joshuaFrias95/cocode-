CREATE TABLE status (
    status_id INT NOT NULL AUTO_INCREMENT,
    nombre_status VARCHAR(20) NOT NULL UNIQUE,

    PRIMARY KEY(status_id)
) ENGINE=InnoDB;