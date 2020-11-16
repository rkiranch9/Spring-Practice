drop table if exists bussearch;
create table bussearch(
	id INT NOT NULL AUTO_INCREMENT,
	source_city varchar(10) NOT NULL,
	destination_city varchar(10) NOT NULL,
	bustype varchar(40) NOT NULL,
    distance INT NOT null,
    primary key(id)
);

