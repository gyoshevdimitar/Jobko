create database `jobko`;
use `jobko`;

create table tasks
(
    id      int auto_increment
        primary key,
    name    varchar(16) not null,
    command varchar(66) not null,
    constraint name
        unique (name)
);

create table tasks_requirements
(
    task_id        int null,
    requirement_id int null,
    constraint requirements_fk
        foreign key (requirement_id) references tasks (id),
    constraint tasks_fk
        foreign key (task_id) references tasks (id)
);

