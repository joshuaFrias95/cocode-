CREATE TABLE status (
    id bigint not null auto_increment,
    nombre_status varchar(20) not null unique,
    primary key(id)
);