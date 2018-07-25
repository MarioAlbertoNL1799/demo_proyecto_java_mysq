create database demo_proyecto;
use demo_proyecto;
create table productos(
    id_producto int(10) unsigned auto_increment primary key,
    nombre_producto varchar(35) not null,
    marca enum('Quacker','Cemex','Duracell','Otro'),
    existencias int(5) unsigned not null);

insert into productos (nombre_producto, marca, existencias) VALUES
    ("Aceite", 1, 20),
    ("Pilas AAA", 3, 15);