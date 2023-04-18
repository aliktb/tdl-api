--liquibase formatted sql

--changeset Ali Khattab:Initial Script

create sequence tdl.hibernate_sequence start with 1 increment by 1;

create table tdl.tasks (id uuid not null, username varchar(255) not null, due_date timestamp, complete boolean);

--rollback drop sequence tdl.hibernate_sequence;

--rollback drop table tdl.tasks;
