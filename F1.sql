# d:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < D:\GitHubJP28\JP28-zavrsni_rad\F1.sql

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
    godina_osvajanja int not null,
    opis varchar(8000),
    ekipa int not null,
    foreign key (ekipa) references ekipa(sifra)
);

create table vozacki_naslov(
    godina_osvajanja int not null,
    opis varchar(8000),
    vozac int not null,
    foreign key (vozac) references vozac(sifra)
);



insert into ekipa (naziv, pogonska_jedinica)
values 
('Ferrari', 'Ferrari'),
('McLaren', 'Mercedes'),
('Mercedes', 'Mercedes'),
('Williams', 'Mercedes'),
('AlphaTauri', 'Honda RBPT'),
('Alpine', 'Renault'),
('Alfa Romeo', 'Ferrari'),
('Red Bull', 'Honda RBPT'),
('Haas', 'Ferrari'),
('Aston Martin', 'Mercedes');



insert into vozac (ime, prezime, datum_rodenja, mjesto_rodenja, drzavljanstvo, vozacev_broj, ekipa)
values 
('Charles', 'Leclerc', '1997-10-16', 'Monte Carlo, Monaco', 'Monaco', 16, 1),
('Carlos', 'Sainz', '1994-09-01', 'Madrid, Spain', 'Spain', 55, 1),
('Lando', 'Norris', '1999-11-13', 'Bristol, England', 'United Kingdom', 4, 2),
('Oscar', 'Piastri', '2001-04-06', 'Melbourne, Victoria', 'Australia', 81, 2),
('Lewis', 'Hamilton', '1985-01-07', 'Stevenage, England', 'United Kingdom', 44, 3),
-- ('George', 'Russell', '1998-02-15', 'King\'s Lynn, England', 'United Kingdom', 63, 3),
('Alexander', 'Albon', '1996-03-23', 'London, England', 'Thailand', 23, 4),
('Logan', 'Sargeant', '2000-12-31', 'Fort Lauderdale, Florida', 'United States', 2, 4),
('Yuki', 'Tsunoda', '2000-05-11', 'Sagamihara, Japan', 'Japan', 22, 5),
('Nyck', 'De Vries', '1995-02-06', 'Uitwellingerga, Netherlands', 'Netherlands', 21, 5),
('Pierre', 'Gasly', '1996-02-07', 'Rouen, France', 'France', 10, 6),
('Esteban', 'Ocon', '1996-09-17', 'Évreux, Normandy', 'France', 31, 6),
('Valtteri', 'Bottas', '1989-08-28', 'Nastola, Finland', 'Finland', 77, 7),
('Zhou', 'Guanyu', '1999-05-30', 'Shanghai, China', 'China', 24, 7),
('Max', 'Verstappen', '1997-09-30', 'Hasselt, Belgium', 'Netherlands', 1, 8),
('Sergio', 'Perez', '1990-01-26', 'Guadalajara, Mexico', 'Mexico', 11, 8),
('Kevin', 'Magnussen', '1992-10-05', 'Roskilde, Denmark', 'Denmark', 20, 9),
('Nico', 'Hulkenberg', '1987-08-19', 'Emmerich am Rhein, Germany', 'Germany', 27, 9),
('Fernando', 'Alonso', '1981-07-29', 'Oviedo, Spain', 'Spain', 14, 10),
('Lance', 'Stroll', '1998-10-29', 'Montreal, Canada', 'Canada', 18, 10);



insert into konstruktorski_naslov (godina_osvajanja, ekipa)
values 
(1961, 1), (1964, 1), (1974, 2), (1975, 1), (1976, 1), (1977, 1), (1979, 1), (1980, 4), (1981, 4), (1982, 1),
(1983, 1), (1984, 2), (1985, 2), (1986, 4), (1987, 4), (1988, 2), (1989, 2), (1990, 2), (1991, 2), (1992, 4),
(1993, 4), (1994, 4), (1996, 4), (1997, 4), (1998, 2), (1998, 3), (1999, 1), (2000, 1), (2001, 1), (2002, 1),
(2003, 1), (2004, 1), (2005, 6), (2007, 1), (2008, 1), (2009, 3), (2010, 8), (2011, 8), (2012, 8), (2013, 8),
(2014, 3), (2015, 3), (2016, 3), (2017, 3), (2018, 3), (2019, 3), (2020, 3), (2021, 3), (2022, 8);



insert into vozacki_naslov (godina_osvajanja, vozac)
values
(2005, 19), (2006, 19), (2008, 5), (2014, 5), (2015, 5), (2017, 5), (2018, 5), (2019, 5), (2020, 5), (2021, 15), (2022, 15);



-- Ostao je još opis za riješiti putem update naredbe.