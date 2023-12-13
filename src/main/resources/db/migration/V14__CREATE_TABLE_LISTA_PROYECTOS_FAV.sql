CREATE TABLE lista_proyectosfav (
    usuario_id INT NOT NULL,
    proyecto_id INT NOT NULL,

    PRIMARY KEY (usuario_id, proyecto_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(proyecto_id)
) ENGINE=InnoDB;
