# d:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < D:\JP28_F1ManagerProject\SQL\F1ManagerProject.sql

# d:\xampp\mysql\bin\mysqldump -uroot F1ManagerProject > D:\JP28_F1ManagerProject\backup_sql\F1ManagerProject_backup.sql



drop database if exists F1ManagerProject;
create database F1ManagerProject;
use F1ManagerProject;

create table vozaci (
    id INT not null AUTO_INCREMENT PRIMARY KEY,
    ime VARCHAR(50) not null,
    prezime VARCHAR(50) not null,
    nacionalnost VARCHAR(50) not null,
    datum_rodenja DATE not null,
    broj_pobjeda INT,
    broj_pole_positiona INT
);


create table timovi (
    id INT not null AUTO_INCREMENT PRIMARY KEY,
    ime_tima VARCHAR(100) not null,
    drzava_sjedista VARCHAR(50),
    godina_osnutka INT not null,
    vozac_id int not null,
    FOREIGN KEY (vozac_id) REFERENCES vozaci(id)
);


create table sezone (
    id INT not null AUTO_INCREMENT PRIMARY KEY,
    godina INT not null,
    vozac_id INT not null,
    FOREIGN KEY (vozac_id) REFERENCES vozaci(id)
);


create table staze (
    id INT not null AUTO_INCREMENT PRIMARY KEY,
    ime_staze VARCHAR(100) not null,
    duzina_staze DECIMAL(10, 2),
    lokacija VARCHAR(100),
    rekord_staze TIME,
    godina_postavljanja INT
);


create table utrke (
    id INT not null AUTO_INCREMENT PRIMARY KEY,
    staza_id INT not null,
    sezona_id INT not null,
    datum_i_vrijeme DATETIME not null,
    FOREIGN KEY (staza_id) REFERENCES staze(id),
    FOREIGN KEY (sezona_id) REFERENCES sezone(id)
);


create table rezultati_utrke (
    id INT not null AUTO_INCREMENT PRIMARY KEY,
    utrka_id INT not null,
    vozac_id INT not null,
    tim_id INT not null,
    pozicija INT not null,
    najbrzi_krug TIME,
    FOREIGN KEY (utrka_id) REFERENCES utrke(id),
    FOREIGN KEY (vozac_id) REFERENCES vozaci(id),
    FOREIGN KEY (tim_id) REFERENCES timovi(id)
);


INSERT INTO vozaci (ime, prezime, nacionalnost, datum_rodenja)
VALUES
    ('Lewis', 'Hamilton', 'Britanac', '1985-01-07'),
    ('Valtteri', 'Bottas', 'Finac', '1989-08-28'),
    ('Max', 'Verstappen', 'Nizozemac', '1997-09-30'),
    ('Sergio', 'Perez', 'Meksikanac', '1990-01-26'),
    ('Charles', 'Leclerc', 'Monegašanin', '1997-10-16'),
    ('Carlos', 'Sainz', 'Španjolac', '1994-09-01'),
    ('Daniel', 'Ricciardo', 'Australac', '1989-07-01'),
    ('Lando', 'Norris', 'Britanac', '1999-11-13'),
    ('Sebastian', 'Vettel', 'Nijemac', '1987-07-03'),
    ('Lance', 'Stroll', 'Kanađanin', '1998-10-29'),
    ('Fernando', 'Alonso', 'Španjolac', '1981-07-29'),
    ('Esteban', 'Ocon', 'Francuz', '1996-09-17'),
    ('Pierre', 'Gasly', 'Francuz', '1996-02-07'),
    ('Yuki', 'Tsunoda', 'Japanac', '2000-05-11'),
    ('Kimi', 'Räikkönen', 'Finac', '1979-10-17'),
    ('Antonio', 'Giovinazzi', 'Talijan', '1993-12-14'),
    ('Mick', 'Schumacher', 'Nijemac', '1999-03-22'),
    ('Nikita', 'Mazepin', 'Rus', '1999-03-02'),
    ('Nicholas', 'Latifi', 'Kanađanin', '1995-06-29'),
    ('George', 'Russell', 'Britanac', '1998-02-15'),
    ('Alexander', 'Albon', 'Tajlanđanin', '1996-03-23'),
    ('Daniil', 'Kvyat', 'Rus', '1994-04-26'),
    ('Romain', 'Grosjean', 'Francuz', '1986-04-17'),
    ('Kevin', 'Magnussen', 'Danac', '1992-10-05'),
    ('Robert', 'Kubica', 'Poljak', '1984-12-07'),
    ('Nico', 'Hulkenberg', 'Nijemac', '1987-08-19'),
    ('Stoffel', 'Vandoorne', 'Belgijac', '1992-03-26'),
    ('Brendon', 'Hartley', 'Novozelanđanin', '1989-11-10'),
    ('Marcus', 'Ericsson', 'Šveđanin', '1990-09-02'),
    ('Sergey', 'Sirotkin', 'Rus', '1995-08-27'),
    ('Felipe', 'Massa', 'Brazilac', '1981-04-25'),
    ('Nico', 'Rosberg', 'Nijemac', '1985-06-27'),
    ('Jenson', 'Button', 'Britanac', '1980-01-19'),
    ('Esteban', 'Gutierrez', 'Meksikanac', '1991-08-05'),
    ('Jolyon', 'Palmer', 'Britanac', '1991-01-20'),
    ('Pascal', 'Wehrlein', 'Nijemac', '1994-10-18'),
    ('Pastor', 'Maldonado', 'Venezuelac', '1985-03-09'),
    ('Felipe', 'Nasr', 'Brazilac', '1992-08-21'),
    ('Will', 'Stevens', 'Britanac', '1991-06-28'),
    ('Roberto', 'Merhi', 'Španjolac', '1991-03-22'),
    ('Jean-Eric', 'Vergne', 'Francuz', '1990-04-25'),
    ('Adrian', 'Sutil', 'Nijemac', '1983-01-11'),
    ('Kamui', 'Kobayashi', 'Japanac', '1986-09-13'),
    ('Max', 'Chilton', 'Britanac', '1991-04-21'),
    ('Mark', 'Webber', 'Australac', '1976-08-27'),
    ('Paul', 'di Resta', 'Škot', '1986-04-16'),
    ('Charles', 'Pic', 'Francuz', '1990-02-15'),
    ('Giedo', 'van der Garde', 'Nizozemac', '1985-04-25'),
    ('Jules', 'Bianchi', 'Francuz', '1989-08-03'),
    ('Bruno', 'Senna', 'Brazilac', '1983-10-15'),
    ('Heikki', 'Kovalainen', 'Finac', '1981-10-19'),
    ('Vitaly', 'Petrov', 'Rus', '1984-09-08'),
    ('Timo', 'Glock', 'Nijemac', '1982-03-18'),
    ('Narain', 'Karthikeyan', 'Indijac', '1977-01-14'),
    ('Pedro', 'de la Rosa', 'Španjolac', '1971-02-24'),
    ('Michael', 'Schumacher', 'Nijemac', '1969-01-03'),
    ('Ralf', 'Schumacher', 'Nijemac', '1975-06-30'),
    ('Nick', 'Heidfeld', 'Nijemac', '1977-05-10'),
    ('Karun', 'Chandhok', 'Indijac', '1984-01-19'),
    ('Sebastien', 'Buemi', 'Švicarac', '1988-10-31'),
    ('Jaime', 'Alguersuari', 'Španjolac', '1990-03-23'),
    ('Rubens', 'Barrichello', 'Brazilac', '1972-05-23'),
    ('Jarno', 'Trulli', 'Talijan', '1974-07-13'),
    ('Vitantonio', 'Liuzzi', 'Talijan', '1981-08-06'),
    ('Lucas', 'di Grassi', 'Brazilac', '1984-08-11'),
    ('Nelson', 'Piquet', 'Brazilac', '1985-07-25'),
    ('Kazuki', 'Nakajima', 'Japanac', '1985-01-11'),
    ('Sebastien', 'Bourdais', 'Francuz', '1979-02-28'),
    ('Giancarlo', 'Fisichella', 'Talijan', '1973-01-14'),
    ('David', 'Coulthard', 'Britanac', '1971-03-27'),
    ('Alexander', 'Wurz', 'Austrijanac', '1974-02-15'),
    ('Takuma', 'Sato', 'Japanac', '1977-01-28'),
    ('Scott', 'Speed', 'Amerikanac', '1983-01-24'),
    ('Jacques', 'Villeneuve', 'Kanađanin', '1971-04-09'),
    ('Ricardo', 'Zonta', 'Brazilac', '1976-03-23'),
    ('Robert', 'Doornbos', 'Nizozemac', '1981-09-23'),
    ('Juan Pablo', 'Montoya', 'Kolumbijac', '1975-09-20'),
    ('Tiago', 'Monteiro', 'Portugalac', '1976-07-24'),
    ('Heinz-Harald', 'Frentzen', 'Nijemac', '1967-05-18'),
    ('Ralph', 'Firman', 'Britanac', '1975-05-20'),
    ('Olivier', 'Panis', 'Francuz', '1966-09-02'),
    ('Antonio', 'Pizzonia', 'Brazilac', '1980-03-11'),
    ('Justin', 'Wilson', 'Britanac', '1978-07-31'),
    ('Jos', 'Verstappen', 'Nizozemac', '1972-03-04'),
    ('Nicolas', 'Kiesa', 'Danac', '1978-12-01'),
    ('Eddie', 'Irvine', 'Britanac', '1965-11-10'),
    ('Mika', 'Saloranta', 'Finac', '1976-05-13'),
    ('Luciano', 'Burti', 'Brazilac', '1975-03-05'),
    ('Mika', 'Häkkinen', 'Finac', '1968-09-28'),
    ('Enrique', 'Bernoldi', 'Brazilac', '1978-10-19'),
    ('Jean', 'Alesi', 'Francuz', '1964-06-11'),
    ('Gaston', 'Mazzacane', 'Argentinac', '1975-09-08'),
    ('Johnny', 'Herbert', 'Britanac', '1964-06-25'),
    ('Damon', 'Hill', 'Britanac', '1960-09-17'),
    ('Luca', 'Badoer', 'Talijan', '1971-01-25'),
    ('Stéphane', 'Sarrazin', 'Francuz', '1975-11-02'),
    ('Esteban', 'Tuero', 'Argentinac', '1978-01-22'),
    ('Marc', 'Gené', 'Španjolac', '1974-03-29'),
    ('Ricardo', 'Rosset', 'Brazilac', '1968-07-27'),
    ('Pedro', 'Diniz', 'Brazilac', '1970-05-26'),
    ('Shinji', 'Nakano', 'Japanac', '1971-04-01'),
    ('Tora', 'Takagi', 'Japanac', '1974-04-12'),
    ('Gerhard', 'Berger', 'Austrijanac', '1959-08-27'),
    ('Jan', 'Magnussen', 'Danac', '1973-07-04'),
    ('Hans-Joachim', 'Stuck', 'Nijemac', '1951-01-01'),
    ('Pedro', 'Lamy', 'Portugalac', '1972-03-20'),
    ('Martin', 'Brundle', 'Britanac', '1959-06-01'),
    ('Karl', 'Wendlinger', 'Austrijanac', '1968-12-20'),
    ('Mark', 'Blundell', 'Britanac', '1966-04-08'),
    ('Michele', 'Alboreto', 'Talijan', '1956-12-23'),
    ('Ukyo', 'Katayama', 'Japanac', '1963-05-29'),
    ('Alain', 'Prost', 'Francuz', '1955-02-24'),
    ('Ayrton', 'Senna', 'Brazilac', '1960-03-21'),
    ('Riccardo', 'Patrese', 'Talijan', '1954-04-17'),
    ('Thierry', 'Boutsen', 'Belgijac', '1957-07-13'),
    ('Andrea', 'de Cesaris', 'Talijan', '1959-05-31'),
    ('Christian', 'Fittipaldi', 'Brazilac', '1971-01-18'),
    ('Nigel', 'Mansell', 'Britanac', '1953-08-08'),
    ('Mauricio', 'Gugelmin', 'Brazilac', '1963-04-20'),
    ('Ivan', 'Capelli', 'Talijan', '1963-05-24'),
    ('Olivier', 'Grouillard', 'Francuz', '1958-09-02'),
    ('Erik', 'Comas', 'Francuz', '1963-09-29'),
    ('Stefano', 'Modena', 'Talijan', '1963-05-12'),
    ('Satoru', 'Nakajima', 'Japanac', '1953-02-23'),
    ('Eric', 'Bernard', 'Francuz', '1964-08-23'),
    ('Aguri', 'Suzuki', 'Japanac', '1969-09-08'),
    ('JJ', 'Lehto', 'Finac', '1966-01-31'),
    ('Gianni', 'Morbidelli', 'Talijan', '1968-01-13'),
    ('Derek', 'Warwick', 'Britanac', '1954-08-27'),
    ('Eddie', 'Cheever', 'Amerikanac', '1958-01-10'),
    ('Philippe', 'Alliot', 'Francuz', '1954-07-27'),
    ('Yannick', 'Dalmas', 'Francuz', '1961-07-28'),
    ('Nannini', 'Alessandro', 'Talijan', '1959-07-07'),
    ('Philippe', 'Streiff', 'Francuz', '1955-06-26'),
    ('Alex', 'Caffi', 'Talijan', '1964-03-18'),
    ('Gabriele', 'Tarquini', 'Talijan', '1962-03-02'),
    ('René', 'Arnoux', 'Francuz', '1948-07-04'),
    ('Stefan', 'Johansson', 'Šveđanin', '1956-09-08'),
    ('Jonathan', 'Palmer', 'Britanac', '1956-11-07'),
    ('Adrian', 'Campos', 'Španjolac', '1960-06-17'),
    ('Patrick', 'Tambay', 'Francuz', '1959-06-25'),
    ('Elio', 'de Angelis', 'Talijan', '1958-03-26'),
    ('Jacques', 'Laffite', 'Francuz', '1943-11-21'),
    ('Johnny', 'Dumfries', 'Britanac', '1958-04-26'),
    ('Andrea', 'de Cesaris', 'Talijan', '1959-05-31'),
    ('Marc', 'Surer', 'Švicarac', '1951-09-18'),
    ('Pierluigi', 'Martini', 'Talijan', '1961-04-23'),
    ('Christian', 'Danner', 'Nijemac', '1958-04-04'),
    ('Niki', 'Lauda', 'Austrijanac', '1949-02-22'),
    ('Keke', 'Rosberg', 'Finac', '1948-12-06'),
    ('Stefan', 'Bellof', 'Nijemac', '1957-11-20'),
    ('Corrado', 'Fabi', 'Talijan', '1961-04-09'),
    ('John', 'Watson', 'Britanac', '1946-05-04'),
    ('Danny', 'Sullivan', 'Amerikanac', '1950-03-09'),
    ('Roberto', 'Guerrero', 'Kolumbijac', '1958-11-16'),
    ('Didier', 'Pironi', 'Francuz', '1952-03-26'),
    ('Derek', 'Daly', 'Irac', '1953-03-11'),
    ('Eliseo', 'Salazar', 'Čileanac', '1954-11-05'),
    ('Raul', 'Boesel', 'Brazilac', '1957-12-04'),
    ('Chico', 'Serra', 'Brazilac', '1957-02-03'),
    ('Carlos', 'Reutemann', 'Argentinac', '1942-04-12'),
    ('Alan', 'Jones', 'Australac', '1946-11-02'),
    ('Gilles', 'Villeneuve', 'Kanađanin', '1950-01-18'),
    ('Mario', 'Andretti', 'Amerikanac', '1940-02-28'),
    ('Hector', 'Rebaque', 'Meksikanac', '1956-02-05'),
    ('Patrick', 'Depailler', 'Francuz', '1944-08-09'),
    ('Jochen', 'Mass', 'Nijemac', '1946-09-30'),
    ('Jean-Pierre', 'Jarier', 'Francuz', '1946-07-10'),
    ('Jody', 'Scheckter', 'Južnoafrikanac', '1950-01-29'),
    ('Clay', 'Regazzoni', 'Švicarac', '1939-09-05'),
    ('Héctor', 'Rebaque', 'Meksikanac', '1956-02-05'),
    ('Ronnie', 'Peterson', 'Šveđanin', '1944-02-14'),
    ('Jacky', 'Ickx', 'Belgijac', '1945-01-01'),
    ('James', 'Hunt', 'Britanac', '1947-08-29'),
    ('Emerson', 'Fittipaldi', 'Brazilac', '1946-12-12'),
    ('Hans', 'Stuck', 'Nijemac', '1951-01-01'),
    ('Vittorio', 'Brambilla', 'Talijan', '1937-11-11'),
    ('Carlos', 'Pace', 'Brazilac', '1944-10-06'),
    ('Tom', 'Pryce', 'Britanac', '1949-06-11'),
    ('Chris', 'Amon', 'Novozelanđanin', '1943-07-20'),
    ('Mark', 'Donohue', 'Amerikanac', '1937-03-18'),
    ('Rolf', 'Stommelen', 'Nijemac', '1943-07-11'),
    ('Lella', 'Lombardi', 'Talijanka', '1941-03-26'),
    ('Graham', 'Hill', 'Britanac', '1929-02-15'),
    ('Denis', 'Hulme', 'Novozelanđanin', '1936-06-18'),
    ('François', 'Cevert', 'Francuz', '1944-02-25'),
    ('Henri', 'Pescarolo', 'Francuz', '1942-09-25'),
    ('Arturo', 'Merzario', 'Talijan', '1943-03-11'),
    ('Jackie', 'Stewart', 'Škot', '1939-06-11'),
    ('Peter', 'Revson', 'Amerikanac', '1939-02-27'),
    ('Mike', 'Hailwood', 'Britanac', '1940-04-02'),
    ('Howden', 'Ganley', 'Novozelanđanin', '1941-12-19'),
    ('Jean-Pierre', 'Beltoise', 'Francuz', '1937-04-26'),
    ('Wilson', 'Fittipaldi', 'Brazilac', '1943-12-25'),
    ('Nanni', 'Galli', 'Talijan', '1940-10-02'),
    ('Joseph',  'Siffert', 'Švicarac', '1936-07-07'),
    ('Peter', 'Gethin', 'Britanac', '1940-02-21'),
    ('John', 'Miles', 'Britanac', '1943-06-30'),
    ('Cliff', 'Allison', 'Britanac', '1942-02-08'),
    ('Joakim',  'Bonnier', 'Šveđanin', '1930-01-31'),
    ('Jochen', 'Rindt', 'Austrijanac', '1942-04-18'),
    ('John', 'Surtees', 'Britanac', '1934-02-11'),
    ('Bruce', 'McLaren', 'Novozelanđanin', '1937-08-30'),
    ('Pedro', 'Rodríguez', 'Meksikanac', '1940-01-18'),
    ('Jack', 'Brabham', 'Australac', '1926-04-02'),
    ('Piers', 'Courage', 'Britanac', '1942-05-27'),
    ('Silvio', 'Mosetti', 'Talijan', '1941-11-22'),
    ('Gerhard', 'Mitter', 'Nijemac', '1935-08-30'),
    ('Johnny', 'Servoz-Gavin', 'Francuz', '1942-01-05'),
    ('John', 'Love', 'Južnoafrikanac', '1924-06-04'),
    ('Frank', 'Gardner', 'Australac', '1924-01-01'),
    ('Ludovico', 'Scarfiotti', 'Talijan', '1933-10-18'),
    ('Jim', 'Clark', 'Škot', '1936-03-04'),
    ('Lorenzo', 'Bandini', 'Talijan', '1935-08-21'),
    ('Giancarlo', 'Baghetti', 'Talijan', '1934-12-25'),
    ('Guy', 'Ligier', 'Francuz', '1930-07-12'),
    ('Bob', 'Anderson', 'Britanac', '1931-05-19'),
    ('Mike', 'Spence', 'Britanac', '1936-12-30'),
    ('Bob', 'Bondurant', 'Amerikanac', '1933-04-27'),
    ('Richie', 'Ginther', 'Amerikanac', '1930-08-05'),
    ('Dan', 'Gurney', 'Amerikanac', '1931-04-13'),
    ('Innes', 'Ireland', 'Britanac', '1930-06-12'),
    ('Phil', 'Hill', 'Amerikanac', '1927-04-20'),
    ('Roberto', 'Bussinello', 'Talijan', '1926-03-12'),
    ('Walt', 'Hansgen', 'Amerikanac', '1919-04-28'),
    ('Peter', 'Broeker', 'Švicarac', '1932-06-03'),
    ('Tony', 'Settember', 'Amerikanac', '1926-05-12'),
    ('Maurice', 'Trintignant', 'Francuz', '1917-10-30'),
    ('Masten', 'Gregory', 'Amerikanac', '1923-02-29'),
    ('André', 'Pilette', 'Belgijac', '1921-06-06'),
    ('Tony', 'Maggs', 'Južnoafrikanac', '1937-03-28'),
    ('Trevor', 'Taylor', 'Britanac', '1936-12-08'),
    ('Willy', 'Mairesse', 'Belgijac', '1928-10-01'),
    ('Ricardo', 'Rodríguez', 'Meksikanac', '1942-02-14'),
    ('Olivier', 'Gendebien', 'Belgijac', '1924-01-12'),
    ('Wolfgang', 'von Trips', 'Nijemac', '1928-05-04'),
    ('Stirling', 'Moss', 'Britanac', '1929-09-17'),
    ('Roy', 'Salvadori', 'Britanac', '1922-05-12'),
    ('Jack', 'Lewis', 'Britanac', '1923-09-02'),
    ('Tony', 'Brooks', 'Britanac', '1932-02-25'),
    ('Giorgio', 'Scarlatti', 'Talijan', '1921-06-01'),
    ('Wolfgang', 'Seidel', 'Nijemac', '1926-12-13'),
    ('Lucien', 'Bianchi', 'Belgijac', '1934-11-10'),
    ('Harry', 'Schell', 'Amerikanac', '1921-06-29'),
    ('Stuart', 'Lewis-Evans', 'Britanac', '1930-04-20'),
    ('Maria Teresa', 'de Filippis', 'Talijanka', '1926-11-11'),
    ('Carlo', 'Abate', 'Talijan', '1932-07-10'),
    ('Ron', 'Flockhart', 'Britanac', '1923-06-16'),
    ('Mike', 'Hawthorn', 'Britanac', '1929-04-10'),
    ('Luigi', 'Musso', 'Talijan', '1924-07-28'),
    ('Luigi', 'Piotti', 'Talijan', '1905-07-29'),
    ('Ian', 'Burgess', 'Britanac', '1920-10-14'),
    ('Paul', 'Emery', 'Britanac', '1916-09-02'),
    ('Horace', 'Gould', 'Britanac', '1918-04-22'),
    ('Juan Manuel', 'Fangio', 'Argentinac', '1911-06-24'),
    ('Peter', 'Collins', 'Britanac', '1931-11-06'),
    ('Herman', 'Lang', 'Nijemac', '1909-04-06'),
    ('Alfred', 'Neubauer', 'Nijemac', '1891-03-22'),
    ('Rodger', 'Ward', 'Amerikanac', '1921-01-10'),
    ('Nino', 'Farina', 'Talijan', '1906-10-30'),
    ('Luigi', 'Villoresi', 'Talijan', '1909-05-16'),
    ('Eugenio', 'Castellotti', 'Talijan', '1930-10-10'),
    ('Piero', 'Taruffi', 'Talijan', '1906-12-12'),
    ('Karl', 'Kling', 'Nijemac', '1910-08-16'),
    ('Robert', 'Manzon', 'Francuz', '1917-04-12'),
    ('José', 'Froilán González', 'Argentinac', '1926-10-05'),
    ('André', 'Simon', 'Francuz', '1920-01-05'),
    ('Piero', 'Carini', 'Talijan', '1927-08-24'),
    ('Louis', 'Rosier', 'Francuz', '1905-11-05'),
    ('Pacífico', 'Rizzotto', 'Argentinac', '1923-03-14'),
    ('Robert', 'Nève', 'Belgijac', '1929-02-04'),
    ('Cesare', 'Perdisa', 'Talijan', '1923-11-09'),
    ('Jean', 'Behra', 'Francuz', '1921-02-16'),
    ('Paul', 'Frère', 'Belgijac', '1917-01-30'),
    ('Roberto', 'Mieres', 'Urugvajac', '1924-11-03'),
    ('Clemar', 'Bulté', 'Belgijac', '1925-06-03'),
    ('Horace', 'Gould', 'Britanac', '1918-04-22'),
    ('Johnny', 'Claes', 'Belgijac', '1916-08-11'),
    ('Onofre', 'Marimón', 'Argentinac', '1923-12-19'),
    ('Toulo', 'de Graffenried', 'Švicarac', '1914-05-18'),
    ('Felice', 'Bonetto', 'Talijan', '1903-06-09'),
    ('Alberto', 'Ascari', 'Talijan', '1918-07-13'),
    ('Harry', 'Scherl', 'Nijemac', '1921-06-29'),
    ('Prince', 'Bira', 'Belgijac', '1921-06-29'),
    ('Rudolf', 'Fischer', 'Švicarac', '1912-08-15'),
    ('Hans', 'Stuck', 'Nijemac', '1900-12-27'),
    ('Louis', 'Chiron', 'Monegašanin', '1909-08-03'),
    ('Giuseppe', 'Farina', 'Talijan', '1906-10-30'),
    ('Alberto', 'Crespo', 'Argentinac', '1920-06-19'),
    ('Franz', 'Gindorf', 'Nijemac', '1915-04-23'),
    ('Pablo', 'Birger', 'Argentinac', '1910-02-04'),
    ('Eduardo', 'Ribeiro', 'Brazilac', '1920-11-29'),
    ('John', 'Barraclough', 'Britanac', '1915-05-28'),
    ('Eugène', 'Chaboud', 'Francuz', '1907-12-23'),
    ('Philippe', 'Étancelin', 'Francuz', '1896-12-28'),
    ('Pierre', 'Levegh', 'Francuz', '1905-12-22'),
    ('Yves', 'Giraud-Cabantous', 'Francuz', '1904-11-08'),
    ('Reginald', 'Parnell', 'Britanac', '1911-07-02'),
    ('Luigi', 'Fagioli', 'Talijan', '1898-06-09'),
    ('Bobby', 'Alison', 'Britanac', '1925-02-26'),
    ('Achille', 'Varzi', 'Talijan', '1904-08-08'),
    ('Cuth', 'Harrison', 'Britanac', '1906-10-05'),
    ('Toni', 'Branda', 'Talijan', '1906-04-01'),
    ('David', 'Murray', 'Britanac', '1909-09-15'),
    ('Joe', 'Fry', 'Britanac', '1915-07-04'),
    ('Peter', 'Whitehead', 'Britanac', '1914-11-12'),
    ('Aldo', 'Gordini', 'Talijan', '1897-08-16'),
    ('Henk', 'de Hooge', 'Nizozemac', '1918-12-30');