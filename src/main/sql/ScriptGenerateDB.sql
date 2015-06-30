CREATE TABLE GEEK (
id int not null,
nom varchar(255) not null,
prenom varchar(255) not null,
mail varchar(255) not null,
sexe varchar(1) not null,
description varchar(255) not null,
photo varchar(255) not null,
constraint pk_GEEK primary key (id));

CREATE TABLE INTERET(
id int not null,
libelle varchar(255) not null,
icone varchar(255) not null,
constraint pk_INTERET primary key (id));

CREATE TABLE AVOIR(
id_Geek int not null,
id_Interet int not null,
constraint pk_AVOIR primary key (id_Geek, id_Interet));

ALTER TABLE AVOIR
add constraint fk_GEEKAVOIR foreign key (id_Geek) references GEEK(id);

ALTER TABLE AVOIR
add constraint fk_INTERETAVOIR foreign key (id_Interet) references INTERET(id);

create table STATS (
heure varchar(30),
ip varchar(20),
id_geek int,
constraint pk_audit primary key (heure)
);

alter table audit
add constraint fk_audit_geek foreign key (id_geek) references geek(id);