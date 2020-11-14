drop table if exists fare;
create table fare(
	bustype varchar(40) NOT NULL,
    fareperkm INT NOT null,
    primary key(bustype)
);

