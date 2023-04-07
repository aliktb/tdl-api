--liquibase formatted sql

--changeset Ali Khattab:add properties to tasks

alter table tasks add column task_title varchar(255);
--rollback alter table tasks drop column task_title;

alter table tasks add column task_description varchar(511);
--rollback alter table tasks drop column task_description;

alter table tasks add column created_date timestamp;
--rollback alter table tasks drop column created_date;