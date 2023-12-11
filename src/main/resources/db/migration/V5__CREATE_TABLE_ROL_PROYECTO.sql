CREATE TABLE rol_proyecto (
    id bigint not null auto_increment,
    nombre_rol_proyecto varchar(15) not null unique,
    primary key(id)
);