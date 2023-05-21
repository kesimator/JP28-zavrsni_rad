# d:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < D:\EDUNOVA_vjezbe\F1.sql

drop database if exists F1;
create database F1;
use F1;

create table ekipa(
    sifra int not null primary key auto_increment,
    naziv varchar(500) not null,
    pogonska_jedinica varchar(100) not null
);

create table vozac(
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(100) not null,
    datum_rodenja date not null,
    mjesto_rodenja varchar(100),
    drzavljanstvo varchar(50),
    vozacev_broj int(2) not null,
    ekipa int not null,
    foreign key (ekipa) references ekipa(sifra)
);

create table konstruktorski_naslov(
    godina_osvajanja date not null,
    ekipa int not null,
    foreign key (ekipa) references ekipa(sifra)
);

create table vozacki_naslov(
    godina_osvajanja date not null,
    vozac int not null,
    foreign key (vozac) references vozac(sifra)
);

