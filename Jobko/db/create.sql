create database if not exists `jobko`;
use `jobko`;

create table if not exists tasks
(
    id          int auto_increment
        primary key,
    name        varchar(16) not null,
    command     varchar(66) not null,
    requires_id int         null,
    constraint name
        unique (name)
);