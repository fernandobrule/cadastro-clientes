


-- ##############################################################
-- Create Table: CLIENTE
-- ##############################################################
create table if not exists dbcadclidev.cliente(
   --
   cliente_id         bigint unsigned not null auto_increment,
   cliente_name       varchar(64) not null,
   cliente_surname    varchar(64) not null,
   cliente_age        smallint not null,
   cliente_address    varchar(64) not null,
   cliente_city       varchar(64) not null,
   cliente_country    varchar(64) not null,
   cliente_mobile     varchar(16) not null,
   cliente_email      varchar(254) not null,
   --
   constraint cliente_pk primary key(cliente_id)
) engine = innodb default charset=latin1;


