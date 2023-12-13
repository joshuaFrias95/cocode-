CREATE TABLE lista_tecnologias_usuario (
    usuario_id INT NOT NULL,
    tecnologia_id INT NOT NULL,

    PRIMARY KEY (usuario_id, tecnologia_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (tecnologia_id) REFERENCES tecnologias(tecnologia_id)
) ENGINE=InnoDB;
