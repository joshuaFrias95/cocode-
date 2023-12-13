CREATE TABLE lista_colaboradores (
    proyecto_id INT NOT NULL,
    colaborador_id INT NOT NULL,
    rol_colaborador VARCHAR(50) NOT NULL,
    activo BIT(1) NULL DEFAULT 1,

    PRIMARY KEY(proyecto_id, colaborador_id),
    FOREIGN KEY (proyecto_id) REFERENCES proyectos(proyecto_id),
    FOREIGN KEY (colaborador_id) REFERENCES usuarios(usuario_id)

) ENGINE=InnoDB;