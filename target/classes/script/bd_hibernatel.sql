CREATE DATABASE `bd_hibernatel` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bd_hibernatel`;

CREATE TABLE `mascotas` (
`id_mascota` int not null auto_increment,
`nombre` varchar(45) not null,
`raza` varchar(45) not null,
`color` varchar(45) not null,
`sexo` varchar(45) not null,
PRIMARY KEY (`id_mascota`)
) ENGINE=InnoDB auto_increment=6 default charset=utf8mb4;

CREATE TABLE persona(
id_persona int not null,
nombre_persona varchar(45) default null,
profesion_persona varchar(45) default null,
telefono_persona varchar(45) default null,
tipo_persona int not null,
nacimiento_id int not null,
PRIMARY KEY (id_persona)
);

CREATE TABLE nacimiento(
id_nacimiento int not null auto_increment,
ciudad_nacimiento varchar (45) default null,
departamento_nacimiento varchar (45) default null,
fecha_nacimiento date default null,
pais_nacimiento varchar (45) default null,
PRIMARY KEY (id_nacimiento)
);

create table `bd_hibernatel`.`productos`(
`id_producto` int not null auto_increment,
`nombre_producto` varchar (45) not null,
`precio_producto` double default null,
primary key (`id_producto`)
) engine=InnoDB default charset=utf8mb4;

create table `bd_hibernatel`.`personas_productos`(
`persona_id` int not null,
`producto_id` int not null,
key `FK_producto` (`producto_id`),
key `FK_persona` (`persona_id`),
constraint `FK_producto` foreign key (`producto_id`) references `productos` (`id_producto`),
constraint `FK_persona` foreign key (`persona_id`) references `persona` (`id_persona`)
) engine=InnoDB default charset=utf8mb4;

ALTER TABLE persona ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona ADD CONSTRAINT fk_persona_nacimiento foreign key (nacimiento_id) references nacimiento (id_nacimiento)
on delete no action
on update no action;

alter table `bd_hibernatel`.`mascotas` add column `persona_id` int null after `sexo`;

alter table `bd_hibernatel`.`mascotas` add index `fk_mascota_persona_idx` (`persona_id` ASC);

alter table `bd_hibernatel`.`mascotas` add constraint `fk_mascotas_persona` foreign key (`persona_id`)
references `bd_hibernatel`.`persona` (`id_persona`) on delete no action on update no action;