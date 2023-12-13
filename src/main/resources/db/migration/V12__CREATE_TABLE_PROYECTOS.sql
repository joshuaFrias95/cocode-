CREATE TABLE proyectos (
    proyecto_id INT NOT NULL AUTO_INCREMENT,
    nombre_proyecto VARCHAR(25) NOT NULL,
    descripcion_proyecto VARCHAR(250) NOT NULL,
    portada VARCHAR(250),
    lista_colaboradores INT,
    lista_tecnologias INT,
    lista_tareas INT,
    dificultad INT NOT NULL,
    fecha_registro_proyecto DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activo BIT(1) NULL DEFAULT 1,

    PRIMARY KEY(proyecto_id),
    FOREIGN KEY (dificultad) REFERENCES dificultades(dificultad_id)
) ENGINE=InnoDB;


