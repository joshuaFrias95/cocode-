CREATE TABLE lista_proyectos (
    usuario_id INT NOT NULL,
    proyecto_id INT NOT NULL,
    rol_proyecto INT NOT NULL,
    activo BIT(1) NULL DEFAULT 1,

    PRIMARY KEY (usuario_id, proyecto_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (rol_proyecto) REFERENCES rol_proyecto(proyecto_id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(proyecto_id)
) ENGINE=InnoDB;
