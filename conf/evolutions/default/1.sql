# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table url_mapping (
  id                        integer not null,
  key                       varchar(255),
  url                       varchar(255),
  constraint uq_url_mapping_key unique (key),
  constraint uq_url_mapping_url unique (url),
  constraint pk_url_mapping primary key (id))
;

create sequence url_mapping_seq;




# --- !Downs

drop table if exists url_mapping cascade;

drop sequence if exists url_mapping_seq;

