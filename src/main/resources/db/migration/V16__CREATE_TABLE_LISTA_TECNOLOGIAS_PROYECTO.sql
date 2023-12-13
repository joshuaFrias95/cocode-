CREATE TABLE lista_tecnologias_proyecto (
    proyecto_id INT NOT NULL,
    tecnologia_id INT NOT NULL,

    PRIMARY KEY (proyecto_id, tecnologia_id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(proyecto_id),
    FOREIGN KEY (tecnologia_id) REFERENCES tecnologias(tecnologia_id)
) ENGINE=InnoDB;
