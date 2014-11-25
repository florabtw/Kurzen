# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table url_mapping (
  id                        integer not null,
  original                  varchar(255),
  shortened                 varchar(255),
  constraint uq_url_mapping_original unique (original),
  constraint uq_url_mapping_shortened unique (shortened),
  constraint pk_url_mapping primary key (id))
;

create sequence url_mapping_seq;




# --- !Downs

drop table if exists url_mapping cascade;

drop sequence if exists url_mapping_seq;

