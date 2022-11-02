CREATE DATABASE db_flight with template = template0 ENCODING 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';

create table Customers (

	id uuid default gen_random_uuid() primary key not null,
	id_number varchar(50) not null,
	"name" varchar(50) not null,
	last_name varchar(50) not null,
	age int not null,
	nationality varchar(50) not null
	
);

create table Airports (

	id uuid default gen_random_uuid() primary key not null,
	name varchar(50) not null,
	country varchar(50) not null,
	city varchar(50) not null

);

create table Flights (

	id uuid default gen_random_uuid() primary key not null,
	origin_id uuid references Airports(id) not null,
	destination_id uuid references Airports(id) not null,
	layover_id uuid references Flights(id) null,
	airline_name varchar(50) not null,
	departure_date timestamp with time zone not null,
	arrival_date timestamp with time zone not null,
	distance decimal not null,
	max_capacity int not null,
	actual_capacity int not null

);


create table Tickets (

	id uuid default gen_random_uuid() primary key not null,
	customer_id uuid references Customers(id),
	flight_id uuid references Flights(id) not null,
	price decimal not null,
	has_luggage boolean not null

);

CREATE ROLE api LOGIN
PASSWORD 'api_password';

REVOKE ALL PRIVILEGES ON 
ALL TABLES IN SCHEMA public
FROM api;

grant insert, update on Customers to api;
grant insert, update, select on Tickets to api;
grant select on Airports to api;
grant select, insert, update on Flights to api;


// 1. Reservas tu vuelo
// 2. Pones tus datos
//     2.1. Tus datos coinciden en la base de datos y tienes al menos 18 anios.
//      2.1.1. Tu edad se modifica en la base de datos a la nueva introducida.
//  2.2. Tus datos no figuran en la base de datos y tienes al menos 18 anios.
//        2.2.1. Se te registra en la base de datos
// 3. Se te da la opcion de anadir mas pasajeros
//     3.1. Se ha llegado a la capacidad limite del vuelo y no se pueden mas pasajeros
//        FIN
//    3.2. Se muestra un nuevo formulario para rellenar
//  BUCLE