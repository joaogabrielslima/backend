create database AsamiStudioHair;

create table user_type(
    id int not null primary key,
    type varchar(50)
);

INSERT INTO user_type(id, type)
VALUES (1, 'Client'),
       (2, 'Employee'),
       (3, 'Manager'),
       (4, 'Admin');

create table Users(
    id int not null auto_increment primary key,
    user_type int DEFAULT 1,
    foreign key (user_type) references user_type(id),
    name varchar(100),
    email varchar(100),
    pwd varchar(50)
);

create table appointment(
    id int not null auto_increment primary key,
    client int,
    foreign key (client) references Users(id),
    employee int,
    foreign key (employee) references Users(id),
    datetime datetime,
    price double,
    description varchar(200)
)

