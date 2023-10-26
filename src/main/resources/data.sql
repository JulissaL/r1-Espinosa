create database spring_boot;
use Spring_Boot;

create table Cliente(
id int not null primary key auto_increment,
client_name varchar(80) not null,
balance varchar(80) not null,
estado varchar(80) not null
);

insert into Cliente(client_name,balance,estado)values('Genesis','400','Activo');
insert into Cliente(client_name,balance,estado)values('Rodrigo','100','Activo');

select * from Cliente;