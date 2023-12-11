CREATE TABLE paises (
    id bigint not null auto_increment,
    codigo_pais varchar(3) not null unique,
    nombre_pais varchar(25) not null unique,

    primary key(id)
);