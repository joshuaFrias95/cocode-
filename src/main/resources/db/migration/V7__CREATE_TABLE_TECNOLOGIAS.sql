CREATE TABLE tecnologias (
    id bigint not null auto_increment,
    nombre_tecnologia varchar(15) not null unique,
    primary key(id)
);