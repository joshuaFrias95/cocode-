CREATE TABLE paises (
    id bigint not null auto_increment,
    codigo_pais varchar(5) not null unique,
    nombre_pais varchar(75) not null unique,
    primary key(id)
);