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
(1992, 6), (1993, 4), (1993, 6), (1994, 4), (1994, 6), (1995, 6), (1996, 4), (1996, 6), (1997, 4), (1997, 6),
(1998, 2), (1998, 3), (1999, 1), (2000, 1), (2001, 1), (2002, 1), (2003, 1), (2004, 1), (2005, 6), (2006, 6),
(2007, 1), (2008, 1), (2009, 3), (2010, 6), (2010, 8), (2011, 6), (2011, 8), (2012, 6), (2012, 8), (2013, 6),
(2013, 8), (2014, 3), (2015, 3), (2016, 3), (2017, 3), (2018, 3), (2019, 3), (2020, 3), (2021, 3), (2022, 8);



insert into vozacki_naslov (godina_osvajanja, vozac)
values
(2005, 19), (2006, 19), (2008, 5), (2014, 5), (2015, 5), (2017, 5), (2018, 5), (2019, 5), (2020, 5), (2021, 15), (2022, 15);



update konstruktorski_naslov set opis=
'12. sezona u prvenstvu Formule 1 (računavši od 1950. godine otkada je počelo dodjeljivanje nagrada vozačkih i konstruktorskih naslova
na temelju bodovnog sustava, a ako se računa od samih početaka, onda bi ovo bila 15. sezona). Bilo je 8 utrka, 14 momčadi i 53 vozača. 
To je bila prva godina korištenja 1.5 litrenih motora u kojemu je dominirao odlično pripremljen Ferrari i njihov V6 motor koji je bio 
najjači dio bolida. Novi bolid je nosio oznaku 156, poznat kao "Sharknose" ("morski pas") zbog specifičnog izgleda prednjeg kraja. 
Povećan je kut između cilindara, sa 65 na 120 stupnjeva, što je omogućilo da cijeli bolid bude niži i ima niže težište. 
Povećana je i snaga na 190 KS, što je značilo da je Ferrari imao oko 30 KS snažniji motor od britanske konkurencije.
Ferrarijevi vozači Phill Hill (USA) i Wolfgang von Trips (GER) su prevladavali u borbi za vozački naslov sve do teške tragedije
gdje su se von Trips i Jim Clark (UK) sudarili u Monzi te je von Trips poginuo, a u naletu bolida i 15 gledatelja te još mnogo ozlijeđenih.
Phill Hill je na kraju sezone odnio vozački naslov, prvi Amerikanac koji je to napravio, a Ferrari je osvojio konstruktorski naslov.'
where godina_osvajanja=1961;

update konstruktorski_naslov set opis=
'15. sezona u prvenstvu Formule 1. Bilo je 10 utrka, 14 momčadi i 42 vozača. Sezona se sastojala od uzbudljive završnice u Mexicu, gdje su 
3 vozača vodila borbu za vozački naslov, ali u igri je bila borba i za konstruktorski naslov između Lotusa i Ferrarija. Jim Clark (UK) u 
bolidu Lotusa je vodio utrku, ali u predzadnjem krugu je bolid počeo gubiti ulje, nakon čega su se pojavili problemi i na motoru te je 
parkirao bolid kraj staze. John Surtees (UK) u Ferrarijevom bolidu oznake 158 je završio 2. te je Ferrari osvojio konstruktorski naslov, a 
Surtees vozački naslov. U slučaju Clarkove pobjede, konstruktorski naslov bi pripao Lotusu, a vrlo vjerojatno bi i Clarku pripao vozački 
naslov. Tako je John Surtees ušao u povijest, i do danas ostao, kao prvi i jedini vozač koji je osvojio naslove prvaka na dva (četverostruki 
prvak u klasi 500cc) i na četiri kotača.'
where godina_osvajanja=1964;

update konstruktorski_naslov set opis=
'25. sezona u prvenstvu Formule 1. Bilo je 15 utrka, 20 momčadi i 62 vozača. McLaren-Ford s bolidom oznake M23 osvaja svoj prvi konstruktorski 
naslov, a njihov vozač Emerson Fittipaldi (BRA) osvaja svoj drugi i posljednji naslov prvaka. Jackie Stewart (UK), trostruki prvak F1, nije 
branio prošlogodišnji naslov prvaka jer se umirovio na kraju prošle sezone. Emerson Fittipaldi (BRA) i Clay Regazzoni (CH) su ušli u zadnju 
utrku prvenstva F1 s istim brojem bodova, ali u utrci je Regazzoni imao problem s upravljivošću, padao je u poretku tijekom utrke i tako je
Fittipaldi s 4. mjestom u utrci imao 3 boda više i osvojio drugi (i posljednji) naslov prvaka. Utrku je zasjenila smrt mladog Austrijanca
Helmuta Koinigga kada se njegov bolid zabio u zid nakon puknuća gume u 10. krugu. Pregrada u koju je bolid udario raspala se pri udaru, a 
Koinigg je ostao bez glave.'
where godina_osvajanja=1974;

update konstruktorski_naslov set opis=
'26. sezona u prvenstvu Formule 1. Bilo je 14 utrka, 21 momčad i 54 vozača. Ferrari osvaja svoj 3. konstruktorski naslov, a njihov vozač 
Niki Lauda (AUT) je osvojio prvi naslov svjetskog prvaka F1 s bolidom oznake 312T koji je tehnički bio superiorniji od svih ostalih, a 
također je imao veliku prednost od drugog mjesta na prvenstvu. Nažalost, i ova sezona je obilježena smrću. U 4. utrci koja se održala u 
Španjolskoj, bolid Rolfa Stommelena (GER) je u 26. krugu zbog slomljenog zadnjeg krila preletio ogradu te usmrtio 5 gledatelja uz još 
ozlijeđenih.'
where godina_osvajanja=1975;

update konstruktorski_naslov set opis=
'27. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 21 momčad i 55 vozača. Ferrari s bolidom oznake 312 T2 osvaja 4. konstruktorski naslov, 
a svoj prvi i jedini vozački naslov osvaja James Hunt (UK) u Mclaren-Ford bolidu oznake M23. Sezonu je obilježilo suparništvo Laude i Hunta 
koji su to bili i prije F1, a koje se u međuvremenu razvilo u prijateljstvo, ali i velika nesreća koja je među poznatijima. Ferrarijev vozač
Niki Lauda je bio vodeći vozač u ukupnom poretku sve do 10. utrke kada je na VN Njemačke doživio tešku nesreću tijekom 2. kruga utrke gdje 
je u pokušaju izbjegavanja direktnog sudara izletio sa staze i udario u zaštitnu ogradu nakon čega se njegov bolid zapalio, a on je ostao 
zaglavljen 55 sekundi na temperaturi od 800 °C. Dok se borio za život, propustio je dvije utrke, a vratio se nakon 6 tjedana na 13. utrku 
VN Italije gdje je uz velike bolove od svježih rana završio na 4. mjestu, na opće oduševljenje svih. VN Japan je prvi puta bila dio 
kalendara F1, a ujedno i zadnja utrka u sezoni. Lauda je imao 3 boda prednosti ispred Hunta, a utrku je obilježila jaka kiša, zbog čega je 
Lauda u 2. krugu ušao u boks i odustao od utrke navodeći da su uvjeti na stazi preopasni za nastavak vožnje (što i jesu bili i trebalo se 
otkazati, ali zbog politike i gledanosti se zanemarila sigurnost vozača i uvjeta na stazi). Pobjednik turbulentne utrke je bio Mario Andretti 
(ITA-USA), dok je Hunt završio na 3. mjestu, osvojio 4 boda te postao prvak.'
where godina_osvajanja=1976;

update konstruktorski_naslov set opis=
'28. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 21 momčad i 61 vozač. Ferrari s istim bolidom od prethodne sezone (312 T2) osvaja 5. 
konstruktorski naslov, ujedno i 3. uzastopni, a Ferrarijev vozač Niki Lauda je drugi puta postao svjetski prvak. Imao je toliku prednost da 
na zadnje dvije utrke nije ni nastupao. To je bila zadnja sezona u bolidu Ferrarija za Laudu, kojeg je loš odnos s Enzom Ferrarijem natjerao 
na odlazak iz ekipe. Ova sezona obilježena je i nesrećama u kojoj su živote izgubila tri vozača. Velšanin Tom Pryce kao i sudac na stazi 
poginuli su u bizarnoj nesreći na Kyalamiju na VN Južne Afrike koja se dogodila 5. ožujka. Pryce nije uspio izbjeći udar u 19-godišnjeg suca 
utrke Frederika Jansena van Vuurena koji je pokušao prijeći stazu. Sudac je poginuo u sudaru, a njegov aparat za gašenje požara udario je i 
ubio Prycea čiji je bolid nastavio do kraja pravca gdje se sudario s drugim bolidom. Nekoliko tjedana nakon te nesreće Brazilac Carlos Pace 
poginuo je u padu privatnog zrakopolova nedaleko od Sao Paola. Sezona je bila tragična i za Australca Briana McGuirea koji je poginuo 
prilikom testiranja svog bolida na Brands Hatchu, kao i za dvojicu gledatelja na Fujiju kada je bolid Gillesa Villeneuvea u sudaru s 
Ronnijem Petersonom, katapultiran u zrak, "preskočio" zaštitnu ogradu i pao među gledatelje.'
where godina_osvajanja=1977;

update konstruktorski_naslov set opis=
'30. sezona u prvenstvu Formule 1. Bilo je 15 utrka, 19 momčadi i 36 vozača. Ferrari je donio bolid oznake 312 T4 koji je imao bokserski 
motor (Flat-12) s kubikažom od 2991.80 cc, 5-stupanjski mjenjač i težio je svega 590 kg (s tekućinama). Osvojili su 6. konstruktorski naslov, 
a naslov svjetskog prvaka osvojio je njihov vozač Jody Scheckter (JAR), a ujedno je bio i zadnji vozački naslov za Ferrari čija je suša 
trajala 21 godinu sve do dolaska Michaela Schumachera (GER).'
where godina_osvajanja=1979;

update konstruktorski_naslov set opis=
'31. sezona u prvenstvu Formule 1. Bilo je 14 utrka, 15 momčadi i 41 vozač. Williams-Ford je prvi puta osvojio konstruktorski naslov s 
bolidom oznake FW07B koji je težio 585 kg, a njihov 3.0 V8 motor razvijao 500-510 konja na 11 400 obrtaja. Njihov vozač Alan Jones (AUS) je 
osvojio vozački naslov. Patrick Depailler (FRA) je izgubio život prilikom testiranja na Hockenheimu.'
where godina_osvajanja=1980;

update konstruktorski_naslov set opis=
'32. sezona u prvenstvu Formule 1. Bilo je 15 utrka, 17 momčadi i 40 vozača. Williams-Ford drugi puta osvaja konstruktorski naslov s bolidom 
oznake FW07C, a svjetski prvak po prvi puta postao je Nelson Piquet (BRA) u Brabham-Ford bolidu oznake BT49C. To je bilo prvo prvenstvo koje 
je održano pod imenom FIA svjetsko prvenstvo Formule 1 (FIA Formula One World Championship). Nažalost, ni ova sezona nije prošla bez smrtnog
slučaja gdje je u 5. utrci na VN Belgije jedan mehaničar poginuo, a drugi pregažen i ozlijeđen tijekom kaotičnog starta utrke.'
where godina_osvajanja=1981;

update konstruktorski_naslov set opis=
'33. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 18 momčadi i 40 vozača. Konstruktorski naslov po 7. puta osvaja Ferrari s bolidom oznake 
126 C2, a svjetski prvak je bio Keke Rosberg (FIN) u Williams-Ford bolidu oznake W08. Rosberg je također i prvi prvak iz Finske. Sezona je 
poznata 
po tri vožene utrke u samo jednoj državi (SAD); VN SAD Zapad, VN SAD Istok, VN SAD Las Vegas. Također je zanimljivo to što je Rosberg
pobijedio samo jednu utrku tijekom sezone, ali konzistentnošću je izvukao vozački naslov (drugi vozač koji je to napravio). Sezona je dobila
tragičan zaokret koje su obilježile dvije smrti vozača. Gilles Villeneuve (CDN/CAN) se na 5. utrci na VN Belgije tokom kvalifikacija zabio u
bolid ispred sebe te je umro od slomljenog vrata te večeri u bolnici. Riccardo Paletti je na 10. utrci na VN Kanade prilikom starta utrke umro 
kao posljedica nemogućnosti izbjegavanja bolida koji je stojao na mjestu zbog kvara, a na kojeg je Paletti naletio brzinom od cca 180 km/h.
Vozač Didier Pironi (FRA) je na 12. utrci na VN Njemačke tokom kvalifikacija pretrpio teške ozljede koje su mu okončale karijeru. Niz nesreća
je dovelo do pojačanja sigurnosti za iduću sezonu. Zanimljivo je da je ova sezona bila zadnja koja je počinjala rano (u siječnju) i završila
rano (u rujnu), nakon toga su se sezone otvarale kasnije (ožujak ili travanj) i zatvarale kasnije (listopad ili studeni).'
where godina_osvajanja=1982;

update konstruktorski_naslov set opis=
'34. sezona u prvenstvu Formule 1. Bilo je 15 utrka, 20 momčadi i 35 vozača. Ferrari je osvojio svoj 8. konstruktorski naziv s bolidom oznake 
126 C4, a Nelson Piquet (BRA) je po drugi puta postao svjetski prvak u Brabham-BMW bolidu oznake BT53. Vozački naslov se razvio u 
četverosmjernu bitku između Brabham-BMW vozača Nelsona Piqueta (BRA), Renault vozača Alaina Prosta (FRA) i Ferrarijevog dvojca Renéa 
Arnouxa (FRA) i Patricka Tambaya (FRA) u kojoj je Prost morao odustati zbog kvara na bolidu te je tako Piquetu omogućeno da ugrabi vozački 
naslov. Ferrari je osvojio konstruktorski naslov unatoč svom boljem vozaču, Arnouxu, koji je završio tek treći u ukupnom poretku - jedinstven 
podvig u povijesti F1.'
where godina_osvajanja=1983;

update konstruktorski_naslov set opis=
'35. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 17 momčadi i 35 vozača. Konstruktorski naslov po drugi puta osvaja McLaren-TAG s bolidom 
oznake MP4/2, a njihov vozač Niki Lauda (AUT) je postao trostruki svjetski prvak. Sezonu je obilježio napeti dvoboj između momčadskih kolega 
Niki Laude (AUT) i Alaina Prosta (FRA) u kojemu je Prost pobijedio 7 utrka naspram Laudovih 5 pobjeda, ali na kraju je Lauda prevladao s 
pola boda prednosti - najmanja razlika u povijesti F1. Do danas je ovo posljednje prvenstvo koje je osvojio neki Austrijanac. Lauda je drugi 
vozač, i do danas također posljednji, koji je osvojio vozački naslov, a da nije osvojio nijedan pole position (1. mjesto u kvalifikacijama).'
where godina_osvajanja=1984;

update konstruktorski_naslov set opis=
'36. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 19 momčadi i 36 vozača. McLaren-TAG treći puta osvaja konstruktorski naslov s bolidom 
oznake MP/42B, a njihov vozač Alain Prost (FRA) je prvi puta postao svjetski prvak, a ujedno je to bila i Laudina zadnja sezona. Keke Rosberg 
je u Williamsu s Hondinim motorom postavio novi rekord staze u Silverstonu u kvalifikacijama na VN Britanije i postao prvi čovjek koji je 
vozio krug prosječnom brzinom većom od 257 km/h. 1.5-litreni motori s turbopunjačem postali su univerzalni tijekom 1985., najavljujući 
izumiranje 3.0-litrenih atmosferskih motora. Između 1985. i 1986. F1 motori su postigli najveću razinu snage ikada viđenu u sportu. Posebno 
izrađeni Renaultov motor za kvalifikacije je navodno isporučivao oko 1200 konja, možda i više. Michelin se povukao iz F1 za tu sezonu, 
ostavljajući Goodyear i Pirelli kao dobavljače guma.'
where godina_osvajanja=1985;

update konstruktorski_naslov set opis=
'37. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 15 momčadi i 32 vozača. Williams-Honda treći puta osvaja konstruktorski naslov s bolidom 
oznake FW11. Alain Prost (FRA) u bolidu Mclaren-TAG osvaja svoj drugi vozački naslov. Ovu sezonu ponajviše obilježava činjenica da su bolidi 
F1 bili najjači u povijesti. Nije bilo ograničenja na snagu motora pa su neki motori, uključujući najjači, ali nažalost i nepouzdan BMW M12/13
1.5 litreni četveroklipni motor s jednom turbopunjačem, mogli razvijati 1350+ konja tijekom kvalifikacija. Snaga je bila toliko jaka da se 
nije mogla izmjeriti precizno, sve dok godinama kasnije nisu usavršili tehnologiju dinamometra koja je bila dovoljno napredna da bi to mogla. 
Za kvalifikacije su se stavljali posebni kvalifikacijski motori s uklonjenim blokadama, kvalifikacijski mjenjač koji je bio dizajniran da 
izdrži dodatnu snagu motora i agresivnost. Te su komponente bile gurane do apsolutnih strukturalnih granica i mogli su izdržati 3-4 minute 
tijekom korištenja (2-3 kruga), a ako bi se predugo pritiskalo, jednostavno bi se raspale komponente (otuda i nadimak granate). Nakon 
kvalifikacija bi se izvadile kvalifikacijske komponente te stavile trkaće koje su imale svoje blokade i koje su podesili da budu dovoljno 
snažni izdržati utrku (obično oko 900-1000 konja). Cijeli bolid je težio oko 540 kg. Kraj sezone je ispratio 3 vozača u mirovinu, od kojih su 
dva svjetski prvaci, Alan Jones (AUS) i Keke Rosberg (FIN), a treći vozač je Patrick Tambay (FRA). Dobavljač guma Pirelli se također povukao, 
a nažalost tokom testiranja prije 4. utrke poginuo je vozač Elio de Angelis (ITA), te je to posljednji smrtni slučaj sve do 1994. godine.'
where godina_osvajanja=1986;

update konstruktorski_naslov set opis=
'38. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 16 momčadi i 32 vozača. Konstruktorski naslov 4. puta osvaja Williams-Honda s bolidom 
oznake FW11B. Njihov vozač Nelson Piquet (BRA) je osvojio svoj 3. vozački naslov. FIA (međunarodna automobilistička federacija) je uvela nova 
pravila za ovu sezonu gdje su ograničili motore s turbopunjačima da pritisak ne smije biti veći od 4.0 bara, a također su i zabranili 
super-mekane (i ljepljive) gume u kvalifikacijama koje su mogle izdržati najviše dva kruga u idealnim uvjetima, a što je otežavalo 
kvalifikacije jer je bilo teško naći čisti krug. Dobavljač guma je bio samo Goodyear, obzirom da se prethodne sezone Pirelli povukao.'
where godina_osvajanja=1987;

update konstruktorski_naslov set opis=
'39. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 18 momčadi i 36 vozača. Konstruktorski naslov 4. puta osvaja McLaren-Honda s bolidom 
oznake MP4/4. Njihov vozač Ayrton Senna (BRA) je prvi puta postao svjetski prvak. Senna i momčadski kolega Alain Prost (FRA) su pobijedli u 
15 od 16 utrka. Jedina utrka u kojoj nijedan nije pobijedio je 12. utrka VN Italije, tu pobjedu je odnio Ferrarijev vozač Gerhard Berger (AUT) 
koja je bila emotivna jer je to bilo na njihovoj domaćoj stazi, 4 tjedna nakon smrti osnivača Enza Ferrarija. Prost je imao 7 pobjeda i 7 
utrka na kojima je osvojio 2. mjesto, ali i dalje nije bilo dovoljno za vozački naslov. Senna je imao 8 pobjeda, a također je postavio rekord 
u osvajanju pole positiona u jednoj sezoni, gdje je čak na 13 utrka bio najbrži u kvalifikacijama. McLarenove pobjede su bile nadmašene ili 
izjednačene samo u sezonama koje su imale više od 16 utrka, a na kraju sezone su imali 199 bodova u ljestvici konstruktora, više nego 
trostruko više od bilo kojeg konstruktora (drugo mjesto su bili Ferrari koji su imali 65 bodova). Taj rekord je neoboren do 2002. godine.'
where godina_osvajanja=1988;

update konstruktorski_naslov set opis=
'40. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 20 momčadi i 47 vozača. Konstruktorski naslov 5. puta osvaja Mclaren-Honda s bolidom 
oznake MP4/5. Njihov vozač Alain Prost (FRA) je treći puta postao svjetski prvak. Prvenstvo vozača odlučeno je u kontroverznim okolnostima na 
pretposljednjoj utrci sezone u Japanu, kada su se Prost i timski kolega Ayrton Senna (BRA), koji je trebao pobijediti u utrci, sudarili u 
zadnjim krugovima. Prost se povukao dok se Senna vratio na stazu nakon gurajućeg starta i prvi prešao crtu, samo da bi bio diskvalificiran 
jer se nije ispravno vratio na stazu. Ovo je Prostu donijelo titulu, njegovu posljednju s McLarenom prije nego što se pridružio Ferrariju 
1990. godine. Sezona je također doživjela dosad neviđen broj prijava s 21 konstruktorom koji je prvobitno bio prijavljen, koji su prijavili 
ukupno 40 automobila. Međutim, FIRST Racing se povukao iz prvenstva prije otvaranja utrke, ostavljajući 20 konstruktora koji su sudjelovali 
s ukupno 39 automobila, što je i dalje najveći ulazak u moderno doba. Ova sezona je bila s motorima bez turbopunjača, koji su zabranjeni 
krajem prošle sezone jer je vladajuće tijelo smatralo da čine sport opasnim i skupim, a također je po prvi puta u povijesti zapremnima motora
svih sudionika F1 standardizirana na 3.5 litara (3500 cc). Udaljenosti utrka su bile standardizirane na 305 km, osim na sporijim uličnim
stazama kao što je Monaco, kako bi se utrke zadržale unutar vremenskog ograničenja od dva sata. Utrke su varirale od 292 km do 311 km uz
prethodno spomenute iznimke.'
where godina_osvajanja=1989;

update konstruktorski_naslov set opis=
'41. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 21 momčad i 40 vozača. Svoj 6. konstruktorski naslov osvaja McLaren-Honda s bolidom 
oznake MP4/5B. Njihov vozač Ayrton Senna (BRA) je po drugi puta postao svjetski prvak opet u kontroverznim okolnostima. Drugi puta zaredom je 
došlo do kontakta dva bolida, bolida Senne u MP4/5B s V10 motorom i bolida Alaina Prosta (FRA), njegovog bivšeg momčadskog kolege, u Ferrariju 
oznake 641 s V12 motorom, i to na istom mjestu, u pretposljednjoj utrci sezone na VN Japana. Senna je startao 1., s 9 bodova prednosti, ali 
je Prost startao na čistoj strani staze pa je odmah preuzeo vodstvo, a Senna bijesan što je Prost mogao startati na čistoj strani staze, 
odlučio je da neće dopustiti Prostu da prođe prvi zavoj te se namjerno sudario s njime i izbacio obojicu iz utrke, tako si osiguravši vozački 
naslov, što je i sam priznao sljedeće godine.'
where godina_osvajanja=1990;

update konstruktorski_naslov set opis=
'42. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 19 momčadi i 41 vozač. McLaren-Honda osvaja svoj 7. konstuktorski naslov s bolidom 
oznake MP4/6, a njihov vozač Ayrton Senna (BRA) je 3. puta postao svjetski prvak. Pobijedio je u 7 od 16 utrka, a glavni suparnik s 5 pobjeda 
mu je bio Nigel Mansell (UK) vozeći za Williams-Renault. Ovo je bila prva sezona za Michaela Schumachera (GER) i Miku Häkkinena (FIN), a 
posljednja za Nelsona Piqueta (BRA).'
where godina_osvajanja=1991;

update konstruktorski_naslov set opis=
'43. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 16 momčadi i 39 vozača. Williams-Renault osvojio je konstruktorski naslov (Williamsov 5., 
a Renaultov 1.) s bolidom oznake FW14B, a njihov vozač Nigel Mansell (UK) je postao svjetski prvak. Mansell je pobijedio u prvih 5 utrka 
sezone, a na kraju je postao prvi vozač koji je pobijedio 9 utrka u jednoj sezoni, a također je i prvi Britanac koji je osvojio vozački 
naslov još od Jamesa Hunta 1976. godine. Senna je pobijedio u 3 utrke, ali je na kraju završio 4. u poretku vozača, a mladi Michael 
Schumacher (GER), kojemu je ovo tek druga sezona, je završio 3. u poretku vozeći Benetton-Ford. To je bila i prva sezona za Damona Hilla (UK).'
where godina_osvajanja=1992;

update konstruktorski_naslov set opis=
'44. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 13 momčadi i 35 vozača. Williams-Renault osvojio je konstruktorski naslov (Williamsov 6., 
a Renaultov 2.) s bolidom oznake FW15C, a njihov vozač Alain Prost (FRA) je postao četverostruki svjetski prvak. Dodatak naslovu je bilo i to 
što je prvi vozač koji je imao 50 pobjeda u F1. Ovo je bila i prva sezona za Rubensa Barrichella (BRA) i Eddija Irvinea (UK), a posljednja za 
Alaina Prosta (FRA) i Riccarda Patresea (ITA). Ovu sezonu je označila vrhunac korištenja elektroničke tehnologije u Formuli 1, s možda 
najnaprednijim i najsofisticiranijim F1 bolidima ikad napravljenim. Williamsov bolid koji je osvojio prvenstvo, FW15C, imao je hidraulički i 
elektronički kontroliran aktivni ovjes, servo upravljač, antiblokirajuće kočnice, fly-by-wire kontrole, kontrolu proklizavanja, poluautomatski 
mjenjač koji se mogao prebaciti na potpuno automatski, visokosofisticirana ugrađena telemetrija, pneumatske opruge ventila u motoru, pa čak i 
sustav push-to-pass koji je, barem u teoriji, olakšavao pretjecanje. Williams je također testirao kontinuirano varijabilni mjenjač, dok je 
Benetton-Ford testirao sustav upravljanja na sva četiri kotača krajem sezone. Gotovo svi automobili u 1993. imali su sustav aktivnog ovjesa, 
koji je držao visinu automobila dosljednom tijekom cijelog kruga, čineći aerodinamiku automobila učinkovitijom i djelotvornijom. Svi ovi 
sustavi bit će zabranjeni 1994. godine, osim poluautomatskog mjenjača, ugrađene telemetrije, pneumatskih opruga ventila i servo upravljača.'
where godina_osvajanja=1993;

update konstruktorski_naslov set opis=
'45. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 14 momčadi i 46 vozača. Williams-Renault osvojio je treći uzastopni konstruktorski naslov 
(Williamsov 7., a Renaultov 3.) s bolidom oznake FW16 i FW16B. Michael Schumacher (GER) u Benetton-Ford bolidu oznake B194 postao je 
svjetski prvak. Ova sezona je bila jedna od najtragičnijih i najkontroverznijih sezona u povijesti sporta. Na VN San Marina poginuli su 
austrijski novak Roland Ratzenberger i brazilski trostruki svjetski prvak Ayrton Senna, dok je niz drugih incidenata tijekom sezone 
rezultirao ozljedama vozača, mehaničara, gledatelja i voditelja staze. FIA je nakon toga napravila velike promjene u pravilima i propisima 
F1 u nastojanju da poboljša sigurnost. Mercedes-Benz se vratio u sport po prvi put od 1955. godine, kao dobavljač motora za švicarski tim 
Sauber. U sezoni je također zabilježena prva pobjeda za Ferrari od 1990., dok je McLaren, nakon odlaska Senne, izdržao svoju prvu sezonu bez 
pobjede od 1980. 1994. je također bila posljednja sezona za originalni tim Lotus, jednog od najuspješnijih konstruktora u Formuli 1 povijest, 
kao i posljednja sezona Formule 1 za drugoplasiranog Michelea Alboreta (ITA) iz 1985. godine. Još jedna zanimljivost vrijedna spomena je ta 
da je Schumacher na VN Španjolske imao problem s bolidom, odnosno mjenjačem koji je ostao zaglavljen u 5. brzini većinu utrke te je uspio 
obaviti dva ulaska u boks, također je morao promijeniti način vožnje kako bi našao nove putanje i vrh zavoja (corner apex), a uz sve to je
uspio završiti na čvrstom 2. mjestu. Mnogi to smatraju njegovom najboljom vožnjom.'
where godina_osvajanja=1994;

update konstruktorski_naslov set opis=
'46. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 13 momčadi i 35 vozača. Benetton-Renault je osvojio konstruktorski naslov (prvi i 
posljednji za Benetton, 4. za Renault) s bolidom oznake B195. Njihov vozač Michael Schumacher (GER) je postao dvostruki uzastopni prvak. 
Pobijedio je u 9 utrka, izjednačavajući rekord koji je ostvario Nigel Mansell (UK) 1992. godine, a Mansellu je to ujedno bila i zadnja sezona. 
Kao Honda 1988. godine, Renault motori su pobijedli u svim utrkama osim jedne. Svi timovi natjecali su se s gumama koje je isporučio Goodyear.'
where godina_osvajanja=1995;

update konstruktorski_naslov set opis=
'47. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 11 momčadi i 24 vozača. Williams-Renault osvojio je konstruktorski naslov (8. za Williams 
i 5. za Renault) s bolidom oznake FW18. Svjetski prvak je postao njihov vozač Damon Hill (UK), što ga čini prvim sinom svjetskog prvaka koji 
je sam osvojio naslov (njegov otac Graham je osvojio vozački naslov 1962. i 1968. godine). Glavni suparnik mu je bio momčadski kolega Jacques
Villeneuve (CAN) kojemu je to bila prva sezona u F1. To je bilo posljednje prvenstvo koje je osvojio Britanac, sve do dolaska Lewisa 
Hamiltona i njegovog vozačkog naslova u 2008. godini.'
where godina_osvajanja=1996;

update konstruktorski_naslov set opis=
'48. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 12 momčadi i 28 vozača. Konstruktorski naslov osvojio je Williams-Renault (Williamsow 9., 
a Renaultov 6.) s bolidom oznake FW19, a njihov vozač Jacques Villeneuve (CAN) postao je svjetski prvak. U ovoj sezoni su po prvi put 
sudjelovale i tri nove momčadi: Prost (umjesto Ligiera), Stewart i MasterCard Lola. Prvenstvo je odlučeno pod vrlo kontroverznim okolnostima 
jer je vodeći u prvenstvu Michael Schumacher (GER) namjerno udario Villeneuvea dok je pokušavao obraniti svoje vodstvo u utrci u posljednjoj 
rundi prvenstva na VN Europe u Jerezu u Španjolskoj. Schumacher se zaustavio u šljunčanoj zamci i FIA ga je proglasila krivim za nesreću - 
kaznila ga je oduzimanjem drugog mjesta u prvenstvu. Villeneuve je završio treći u utrci unatoč kontaktu. Schumacher je i dalje zadržao 
svojih pet pobjeda u utrkama. Ova sezona također je vidjela umirovljenje Gerharda Bergera (AUT) nakon mnogo godina u sportu, kao i prvu 
pobjedu na utrci za Heinz-Harald Frentzena (GER) i Miku Häkkinena (FIN). Do danas je ovo posljednje prvenstvo za neeuropskog vozača, 
posljednje konstruktorsko i vozačko prvenstvo za Williams.'
where godina_osvajanja=1997;

update konstruktorski_naslov set opis=
'49. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 11 momčadi i 23 vozača. Konstruktorski naslov je osvojio McLaren-Mercedes s bolidom 
oznake MP4/13, za McLaren je to bio 8. naslov i zadnji koji su osvojili do danas, a za Mercedes prvi. Njihov vozač Mika Häkkinen (FIN) je 
osvojio svoj prvi vozački naslov. Povlačenje Renaulta i odlazak dizajnera Adriana Neweya u McLaren, Williams i njihov prvak nisu bili u 
mogućnosti braniti naslove, te su pretrpjeli prvu sezonu bez pobjede još od 1988. godine. Dominacija MP4/13 prikazana je na prvoj utrci 1998. 
u Australiji, jer su Häkkinen i Coulthard završili krug ispred svih ostalih. Neweyev aerodinamični dizajn bio je daleko najučinkovitiji, a 
Mercedes je proizveo najsnažniji motor sezone. Ekipi je pomogao jedinstveni kočiono-upravljački sustav koji je vozaču omogućio da samostalno 
koristi bilo koju od kočnica automobila kako bi pomogao u skretanju, sustav koji je prvi put korišten 1997. godine. Ferrarijeva momčad je 
protestirala, navodeći da je kočiono-upravljački sustav kršenje tehničkih pravila kojima je zabranjeno upravljanje na sva četiri kotača. 
FIA je na kraju stala na stranu Ferrarija i sustav je zabranjen, iako je timu bilo dopušteno zadržati svoje rezultate do tog trenutka. 
Tijekom 1998. godine, Coulthardov MP4/13 imao je najveću brzinu od svih bolida F1 te godine kada je na staroj stazi Hockenheim imao brzinu 
od 353 km/h.'
where godina_osvajanja=1998;

update konstruktorski_naslov set opis=
'50. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 11 momčadi i 24 vozača. Ferrari osvaja svoj 9. konstruktorski naziv s bolidom oznake 
F399, njihov prvi nakon 1983. godine, dok Mika Häkkinen, vozač McLaren-Mercedes ekipe s bolidom oznake MP4/14, osvaja svoj drugi uzastopni i 
posljednji vozački naslov. Završnica prvenstva postavljena je u kontroverznim okolnostima. Na inauguralnoj VN Malezije, Ferrari je zauzeo 
prvo i drugo mjesto, ali je bio diskvalificiran zbog kršenja tehničkih propisa. Vraćeni su nakon žalbe, čime je Irvineu osigurano vodstvo u 
naslovu prije posljednje utrke u Japanu. Ako bi na VN Japana Schumacher pobijedio, 4. ili više mjesto bi zapečatio naslov za Irvinea. 
Schumacher je zauzeo pole poziciju, ali je izgubio start od Häkkinena koji se zatim odvezao naprijed te mu pozicija nije bila ugrožena, 
unatoč tome što je Schumacher cijelu utrku bio blizu i stvarao pritisak. Hipotetski, i da su Ferrarijevi vozači imali zamijenjene pozicije, 
Irvine bi još uvijek izgubio naslov u povratnom brojanju zbog Häkkinenovih pet pobjeda u usporedbi s Irvineove četiri. Na kraju je Irvine 
završio na dalekom trećem mjestu i pao u pokušaju za naslov prvaka.'
where godina_osvajanja=1999;

update konstruktorski_naslov set opis=
'51. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 11 momčadi i 23 vozača. 10. konstruktorski naslov osvaja Ferrari s bolidom oznake 
F1-2000, a njihov vozač Michael Schumacher (GER) nakon 5 uzastopnih godina pokušaja napokon osvaja svoj 3. vozački naslov i prvi za Ferrari. 
Sve ekipe su se natjecale s gumama koje je isporučio Bridgestone. Kako bi se smanjili troškovi, V10 konfiguracija motora postala je u 
potpunosti obavezna 2000. godine kako proizvođači motora ne bi razvijali i eksperimentirali s drugim konfiguracijama, ali je kut nagiba 
V motora ostao različit. Konfiguracija V10 bila je najpopularnija od zabrane motora s turbopunjačem 1989. godine, a nijedna druga 
konfiguracija nije korištena od 1998. godine. Ovo je bila posljednja puna sezona za automobile koji su se natjecali bez kontrole 
proklizavanja, kontrole pokretanja i potpuno automatskih mjenjača, do sezona 2004. i 2008.'
where godina_osvajanja=2000;

update konstruktorski_naslov set opis=
'52. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 11 momčadi i 26 vozača. 11. konstruktorski naslov osvaja Ferrari s bolidom oznake F12001, 
a njihov vozač Michael Schumacher (GER) osvaja 4. vozački naslov, drugi uzastopni za Ferrari, uz rekordnu prednost od 58 bodova razlike, 
nakon pobjede u 9 utrka i 5 utrka u kojima je završio na 2. mjestu. Schumacher je također oborio rekord u konačnim pobjedama u utrkama, pa je 
tako pobjedom na VN Belgije označio 52. pobjedu u karijeri. Budući svjetski prvaci Fernando Alonso (SPA) i Kimi Räikkönen (FIN) su imali svoje 
prve nastupe u ovoj sezoni, a debitiranju se pridružio i vozač Juan Pablo Montoya (COL). Na kraju sezone, dvostruki svjetski prvak Mika 
Häkkinen objavio je svoju namjeru da uzme jednogodišnji odmor u 2002.; na kraju je to postala puna mirovina. Bitno je naglasiti kako je on bio 
jedini ozbiljni suparnik i konkurent Schumacheru, ali je to često bilo previđeno zbog sjene veličine Schumachera, njegove dominacije i 
uštimanog bolida kao i kompletne ekipe, dok se Häkkinenov bolid mučio s pouzdanošću, ali na kraju je on bio jedini koji se mogao približiti 
Schumacheru i pružiti borbu, a također i zadržati poziciju ako se našao ispred njega, pothvat kojim se malo tko može pohvaliti protiv takvog 
kalibra vozača.'
where godina_osvajanja=2001;

update konstruktorski_naslov set opis=
'53. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 11 momčadi i 23 vozača. 12. konstruktorski naslov osvaja Ferrari s bolidom oznake F12001 
i F2002, a njihov vozač Michael Schumacher (GER) 5. puta postaje svjetski prvak. Bolid je bio odlično složen i podešen te je uz još boljeg 
vozača potpuna dominacija jednostavno bila neizbježna. U vozačkom prvenstvu, Schumacher je završio prvi ili drugi u svakoj utrci osim za 
VN Malezije, gdje je završio treći, čime je postigao mjesto na postolju u svakoj utrci. Osvojio je tada rekordnih 11 pobjeda, nadmašivši 
prethodni rekord od 9 pobjeda, koji su zajedno držali on (1995., 2000. i 2001.) i Nigel Mansell (1992.). Također je postavio rekord za 
najkraće vrijeme u kojemu je osvojeno svjetsko prvenstvo u vožnji, osiguravši naslov pobjedom na VN Francuske, sa 6 utrka do kraja sezone. 
Schumacher je osvojio vozački naslov s tada rekordnom razlikom od 67 bodova u odnosu na momčadskog kolegu Rubensa Barrichella, oborivši svoj 
prethodni rekord za sezonu 2001. (58 bodova u odnosu na Davida Coultharda), a također je postigao novi ukupni rekord u bodovima sa 144 boda, 
ponovno nadmašivši njegov prethodni rekord od 123 boda iz sezone 2001. Schumacher i Barrichello pomogli su Ferrariju da osigura prvenstvo 
konstruktora s ukupnim brojem bodova koji je jednak ukupnom zbroju bodova svih ostalih konstruktora zajedno. Za prvenstvo 2003. FIA je 
promijenila sustav bodovanja.'
where godina_osvajanja=2002;

update konstruktorski_naslov set opis=
'54. sezona u prvenstvu Formule 1. Bilo je 16 utrka, 10 momčadi i 24 vozača. 13. konstruktorski naslov, ujedno i 5. uzastopni, osvaja Ferrari 
s bolidom oznake F2002B i F2003-GA, a njihov vozač Michael Schumacher (GER) 6. puta postaje svjetski prvak, oborivši 46 godina star rekord 
Juana Manuela Fangia od pet naslova svjetskog prvaka. Ova sezona je također značajna po tome što je bila treća i posljednja sezona u kojoj su
potpuno automatski mjenjači i kontrola pokretanja dopušteni za korištenje u F1, otkako su ponovno uvedeni 2001. Oba elektronička pomagala 
vozaču korištena su od VN Španjolske 2001., a promjena pravila u tehničkim propisima dovela je do zabrane oba sustava od strane FIA-e za 2004.'
where godina_osvajanja=2003;

update konstruktorski_naslov set opis=
'55. sezona u prvenstvu Formule 1. Bilo je 18 utrka, 10 momčadi i 25 vozača. Ferrari osvaja rekordni 14. konstruktorski naslov s bolidom 
oznake F2004, dok je njihov vozač Michael Schumacher (GER) osvojio svoj 7. i posljednji vozački naslov, a 5. uzastopni za Ferrari. U ovoj 
sezoni je opet nekoliko rekorda oboreno. Schumacher je pobijedio u 13 utrka, oborivši prethodni rekord od 11 pobjeda u sezoni. Također je 
oborio rekord za najviše uzastopno osvojenih vozačkih naslova (5), a Ferrari je oborio rekord za najviše uzastopno osvojenih konstruktorskih 
naslova (6). To je bila i posljednja pobjeda njemačkog vozača sve do 2010. godine kada je Sebastian Vettel osvojio vozački naslov. Sezona je 
doživjela promjenu tehničkih propisa, uključujući zabranu potpuno automatskih mjenjača i kontrole pokretanja (launch control), koji su se 
koristili u posljednje tri sezone. 2004. je bio prvi put od početka 2001. (prije VN Španjolske) da su se bolidi natjecali bez ovih sustava. 
Međutim, FIA je još uvijek dopuštala korištenje kontrole proklizavanja i nastavila se koristiti tijekom sljedeće tri sezone, sve dok nije 
zabranjena za sezonu 2008. Jedna zanimljivost vrijedna spomena je ta da je na VN Francuske Schumacher, kako bi preuzeo vodstvo i ostao ispred 
Fernanda Alonsa (SPA), dobio prijedlog od ekipe da idu na 4 zaustavljanja, ali uvjet je bio da ekipa mora odraditi zaustavljanja brzo i bez 
greške, kao i drugih faktora, dok Schumacher mora voziti kvalifikacijske krugove, riskantna strategija koja se uvelike isplatila i nagradila 
njegovom pobjedom.'
where godina_osvajanja=2004;

update konstruktorski_naslov set opis=
'56. sezona u prvenstvu Formule 1. Bilo je 19 utrka, 10 momčadi i 27 vozača. Svoj 7. konstruktorski naslov je osvojio Renault (sadašnji 
Alpine) s bolidom oznake R25, dok je njihov vozač Fernando Alonso (SPA) prvi puta postao svjetski prvak, a ujedno i najmlađi u povijesti 
sporta, sve do dolaska Lewisa Hamiltona (UK) i njegovog vozačkog naslova 2008. godine. Bilo je dosta promjena u ovoj sezoni i promjena za 
narednu sezonu, kako tehničkih, tako i sportskih propisa. Među zanimljivijim se nalazi promjena o motorima F1 koji su morali izdržati dva 
trkaća vikenda, dvostruko više nego što su zahtijevali propisi iz 2004. godine. Vozač koji je trebao promijeniti motor bio je podvrgnut kazni 
od 10 mjesta za utrku. Osmišljena da ograniči broj okretaja i izlaznu snagu potrebne za veću pouzdanost, ova je uredba također bila mjera 
smanjenja troškova za proizvođače motora. Nakon prve utrke sezone, FIA je djelovala kako bi zatvorila rupu u ovoj novoj regulativi koju je 
otkrio BAR, koji je namjerno stavio svoje bolide u boksove umjesto da završe utrku. Ovo je bila zadnja sezona u kojoj su sve momčadi koristile
konfiguraciju 3.0-litrenog V10 motora.'
where godina_osvajanja=2005;

update konstruktorski_naslov set opis=
'57. sezona u prvenstvu Formule 1. Bilo je 18 utrka, 11 momčadi i 27 vozača. Svoj 8. konstruktorski naslov je osvojio Renault (sadašnji 
Alpine) s bolidom oznake R26, dok je njihov vozač Fernando Alonso (SPA) po drugi puta u karijeri postao svjetski prvak. Ovo je ujedno bila i 
posljednja sezona sedmerostrukog svjetskog prvaka Michaela Schumachera (GER) koji se na kraju sezone oprostio od aktivne vozačke karijere u 
F1. Prvi puta od sezone 1956. niti jedan britanski konstruktor nije pobijedio niti u jednoj utrci i samo su tvorničke momčadi pobijedile na 
svim utrkama tijekom ove godine (kao i 1956. godine). Ova sezona označila je početak korištenja 2.4L V8 motora koji su se koristili do kraja 
sezone 2013. Ovo je posljednja sezona za Michelin kao dobavljača guma, posljednja sezona koja je imala dva dobavljača guma, a također zadnja 
sezona u cjelini kada je bilo više od jednog dobavljača guma, jer se francuska tvrtka za gume povukla iz F1 na kraju sezone. Vrijedno je 
spomenuti i neke zanimljivosti u promjeni tehničkog pravilnika. Neki su dobavljači motora rano naznačili da njihovi manji V8 mogu imati veći 
broj okretaja od 19 000 okretaja u minuti koji su bili normalni za V10 iz 2005. godine. Proizvođač motora Cosworth iz Northamptona imao je 
zavidan uspjeh s V8 motorima. Ušao je u daljnju povijest postavši prvi proizvođač koji je u prosincu 2005. godine probio granicu od 20.000 
okretaja u minuti. Svi bolidi i sudionici Formule 1 počeli su koristiti obaveznu konfiguraciju poluautomatskog mjenjača sa 7 brzina + 1 hod 
unazad od 2006. do 2013. godine. Kako bi se smanjili troškovi, kapacitet spremnika goriva svih bolida F1 obavezno je standardiziran na 150 
litara.'
where godina_osvajanja=2006;

update konstruktorski_naslov set opis=
'58. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 11 momčadi i 26 vozača. Konstruktorski naslov osvojio je Ferrari s bolidom oznake F2007, 
a njihov vozač Kimi Räikkönen (FIN) je osvojio vozački naslov, i to za jedan bod ispred drugoplasiranog vozača. On je postao treći Finac koji 
je postao svjetski prvak. Glavna točka razgovora u sezoni bila je kontroverza oko špijunaže koja je uključivala Ferrari i McLaren u kojoj je
McLaren kupovao podatke od Ferrarija, što je dovelo do isključenja McLarena iz prvenstva konstruktora. Kao rezultat toga, Ferrari je osvojio 
prvenstvo na VN Belgije. Ova sezona je također sedma i posljednja sezona, od ponovnog uvođenja 2001., u kojoj je uporaba kontrole 
proklizavanja bila dopuštena u F1. Standardizirane elektroničke kontrolne jedinice (ECU) bile su propisane od strane FIA-e od sezone 2008. 
nadalje, što je zabranilo timovima korištenje ove vrste tehnologije. U sezoni su također prve nastupe imali budući svjetski prvaci Lewis 
Hamilton (UK) i Sebastian Vettel (GER). Bridgestone je bio jedini dobavljač guma. Do danas je ovo posljednja pobjeda vozačkog prvenstva koju 
je osvojio vozač Ferrarija, a također je i posljednja pobjeda vozačkog prvenstva za finskog vozača.'
where godina_osvajanja=2007;

update konstruktorski_naslov set opis=
'59. sezona u prvenstvu Formule 1. Bilo je 18 utrka, 11 momčadi i 22 vozača. Svoj 16. i posljednji konstruktorski naslov osvojio je Ferrari
s bolidom oznake F2008, a Lewis Hamilton (UK) u bolidu McLaren-Mercedes je osvojio svoj prvi vozački naslov za jedan bod, pretekavši Tima
Glocka (GER) u posljednjem zavoju posljednjeg kruga VN Brazila jer je Glock jedini ostao na gumama za suho i tako je Hamilton završio na 5.
mjestu koje mu je bilo potrebno da postane svjetski prvak. Time je Hamilton postao najmlađi svjetski prvak (rekord koji će kasnije oboriti
budući svjetski prvak Sebastian Vettel 2010. godine), a ujedno i prvi crni vozač koji je to napravio. Također je bio prvi Britanac koji je
osvojio vozački naslov nakon Damona Hilla 1996. godine. Nova tehnička pravila za ovu sezonu uključivala su zabranu kontrole proklizavanja 
nakon što je ponovno uvedena 2001. na VN Španjolske. Mjenjači su morali trajati četiri utrke, inače je slijedila kazna od 5 mjesta za 
promjenu mjenjača. Ako vozač nije završio utrku, smio je promijeniti mjenjač za sljedeću utrku bez kazne. Poboljšana je zaštita kabine.
Bridgestone je službeni dobavljač guma za sezonu 2008.-2010. Nijedan natjecateljski tim nije smio obaviti više od 30 000 km testiranja 
tijekom kalendarske godine 2008. Fernando Alonso (SPA) pobijedio je na prvoj utrci održanoj u Singapuru, ali tek nakon što se timski kolega 
Piquet namjerno zabio u zid kako bi izazvao razdoblje sigurnosnog automobila što je pomoglo Alonsovoj strategiji. Kada je Piquet to priznao 
novinarima 2009. godine, šef Renaultove momčadi Briatore dao je ostavku. Afera je popularna pod nazivom Crashgate. Ovo je također bila 
posljednja sezona F1 koja se utrkivala s gumama s utorima, koje su se koristile od 1998. godine, prije nego što su se glatke gume vratile u 
F1 2009. godine. Zanimljivo je da su prvi puta u povijesti sve momčadi koristile ista dva vozača tijekom cijele sezone. Osim što je do danas 
ovo Ferrarijev zadnji konstruktorski naslov, i u McLarenu je ostvaren posljednji vozački naslov do danas.'
where godina_osvajanja=2008;

update konstruktorski_naslov set opis=
'60. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 10 momčadi i 25 vozača. Konstruktorski naslov osvojio je Brawn-Mercedes (prvi i jedini
za Brawn GP, a drugi za Mercedes) s bolidom oznake BGP001. Njihov vozač Jenson Button (UK) je osvojio vozački naslov. Za Buttona i Brawn GP 
je to bio prvi i jedini naslov, a Brawn GP je također prva momčad koja je osvojila konstruktorski naslov u svojoj debitanskoj sezoni. Button 
je 10. britanski vozač koji je osvojio naslov svjetskog prvaka F1, i nakon uspjeha Lewisa Hamiltona u F1 2008., prvi puta su dva engleska 
vozača osvojili dva uzastopna naslova. Također, to su i prvi uzastopni britanski naslovi nakon Grahama Hilla (1968. godine) i Jackiea 
Stewarta (1969. godine). S više izmjena pravila FIA je nastojala ograničiti troškove i umanjiti efekte svjetske financijske krize, i također, 
nastojalo se povećati atraktivnost utrka povratkom slick guma, promjenama u aerodinamici i uvođenjem sustava obnavljanja kinetičke energije 
(KERS), što su ukupno bile među najopsežnijim promjenama pravila u posljednjih nekoliko desetljeća. Brawn GP, nasljednik Honde, pobijedio je 
u šest od prvih sedam utrka, te je njihova sposobnost izvlačenja maksimuma iz novih pravila bila presudni faktor u prvenstvu prije drugog 
dijela sezone kada su se borbi za pobjede priključile ostale momčadi i iskopirale dvostruki difuzor. 2009. je bila prva sezona nakon 2005. 
u kojoj su sve ekipe osvajale bodove. Još neke promjene vrijedne spomena su te da je svaki vozač ograničen na maksimum od osam motora tijekom 
sezone, s dodatnih četiri motora za treninge i testiranja (premda su neki vozači iskoristili svih osam, niti jedan vozač nije prekoračio taj 
limit, a ako bi to učinili, dobili bi kaznu od 10 mjesta na startu za svako dodatno korištenje motora). Radi poticanja poboljšanja 
pouzdanosti, režim rotacije je smanjen s 19 000 RPM na 18 000 RPM. Ograničenje brzine u boksevima također je povećano s 80 na 100 km/h.'
where godina_osvajanja=2009;

update konstruktorski_naslov set opis=
'61. sezona u prvenstvu Formule 1. Bilo je 19 utrka, 12 momčadi i 27 vozača. Konstruktorski naslov osvaja Red Bull-Renault (1. za Red Bull,
9. za Renault) s bolidom oznake RB6, a njihov vozač Sebastian Vettel (GER) osvaja svoj prvi vozački naslov, i to kao najmlađi svjetski prvak
u povijesti F1. Broj proizvođača motora pao je na samo četiri (Mercedes, Ferrari, Renault, Cosworth), što je najmanje u posljednjih 30 godina.
Vrijedno je spomenuti i neke promjene. Nadolijevanje goriva tijekom utrke ukinuto je prvi puta nakon 1994. Ratkape kakve su momčadi koristile 
od 2006., ove sezone su zabranjene. Prednje gume sužene su s 270 mm na 245 mm radi poboljšanja balansa prianjanja između prednje i stražnje 
osovine. Odobren je za 2010. novi sustav bodovanja, kao odgovor većem broju natjecatelja. Od 2003., bodove su osvajali prvih osam u svakoj 
utrci, 10,8,6,5,4,3,2 i 1 bod od prvoplasiranog prema osmom. Sustav bodovanja 2010. nagrađuje prvih deset plasiranih, 25,18,15,12,10,8,6,4,2 
i 1 bod od prvog do desetog mjesta. Zanimljiva činjenica je da se Michael Schumacher (GER) vratio iz mirovine i počeo voziti za Mercedes.'
where godina_osvajanja=2010;

update konstruktorski_naslov set opis=
'62. sezona u prvenstvu Formule 1. Bilo je 19 utrka, 12 momčadi i 25 vozača. Konstruktorski naslov osvaja Red Bull-Renault (2. za Red Bull,
10. za Renault) s bolidom oznake RB7, a njihov vozač Sebastian Vettel (GER) je drugi puta postao svjetski prvak. U prvenstvo se vratio
Pirelli koji zamjenjuje Bridgestone kao dobavljač guma za sve momčadi. Uveden je sustav podesivih stražnjih krila, dizajniran kao pomoć pri
pretjecanju. Vozači će ga moći koristiti samo kada su unutar jedne sekunde od vozila ispred, ali ne u prva dva kruga, osim u slučaju 
sigurnosnog automobila u ranim fazama utrke. Također, vozači će se podesivim krilima moći koristiti samo na određenim područjima staze koji
će imati posebne oznake u određenom području kruga, jedino mjesto gdje se podesivo krilo može koristiti. Puno je poznatiji pod nazivom DRS
(Drag Reduction System). Mjenjači sada moraju trajati pet utrka umjesto dosadašnjih četiri. Vozači će na raspolaganju imati jedan dodatni 
mjenjač koji može biti promijenjen bez kazne. FIA je pooštrila svoje vozačke standarde, kako bi se spriječile pretjerano agresivne vožnje i 
vožnje izvan ruba staze, primjenom strožih kazni kod vozača koji se budu tako ponašali. Uvedena je zabrana ostanka na stazi po noći između 
ponoći i 6 ujutro, da bi se spriječili cijelonoćni popravci bolida mehaničara koji cijeli idući dan moraju provesti u boksevima.'
where godina_osvajanja=2011;

update konstruktorski_naslov set opis=
'63. sezona u prvenstvu Formule 1. Bilo je 20 utrka, 12 momčadi i 25 vozača. Konstruktorski naslov osvaja Red Bull-Renault (3. za Red Bull,
11. za Renault) s bolidom oznake RB8, a njihov vozač Sebastian Vettel (GER) je treći puta postao svjetski prvak. Sezona je sadržavala 20 
utrka što je do tada bio rekord s najviše utrka u jednoj sezoni u povijesti F1. Sezonu je započelo šest svjetskih prvaka: Jenson Button, 
Lewis Hamilton, Kimi Räikkönen, Fernando Alonso, Michael Schumacher te Sebastian Vettel. Ovo je bila posljednja sezona u F1 za Michaela 
Schumachera.'
where godina_osvajanja=2012;

update konstruktorski_naslov set opis=
'64. sezona u prvenstvu Formule 1. Bilo je 19 utrka, 11 momčadi i 24 vozača. Konstruktorski naslov osvaja Red Bull-Renault (4. za Red Bull,
12. za Renault) s bolidom oznake RB9, a njihov vozač Sebastian Vettel (GER) je 4. puta postao svjetski prvak. Bila je to jedna od 
najdominantnijih pobjeda na prvenstvu u F1 s osvojenih rekordnih 155 bodova. Postao je 3. vozač u povijesti F1 koji je osvojio 4 uzastopna 
vozačka naslova. Također je postao 4. vozač koji je osvojio 4 vozačka naslova. Izjednačio je Schumacherov rekord od 13 pobjeda u utrkama u
jednoj sezoni i zatvorio je sezonu s 9 uzastopnih pobjeda. To će mu ostati posljednje osvojeni vozački naslov. Za ovu sezonu je minimalna
težina bolida narasla na 642 kg. Bila je zadnja sezona u kojoj se koristila konfiguraciju 2.4L V8 motora koji je uveden 2006. te je najavljen
1.6L V6 motor s turbopunjačem za sezonu 2014. Ovo je također zadnja sezona gdje je Renault osvojio konstruktorski naslov ili je pogonio bolid
kojim je vozač osvojio vozački naslov.'
where godina_osvajanja=2013;

update konstruktorski_naslov set opis=
'65. sezona u prvenstvu Formule 1. Bilo je 19 utrka, 11 momčadi i 25 vozača. 3. konstruktorski naslov osvaja Mercedes (kao samostalna momčad,
njihov prvi naslov) s bolidom oznake F1 W05 Hybrid, a njihov vozač Lewis Hamilton (UK) drugi puta postaje svjetski prvak. Ovu sezonu 
obilježava ulazak novih motora, 1.6L V6 s turbopunjačem s 8-stupanjskim poluatomatskim mjenjačem. Minimalna težina bolida se povećala sa 
642 kg na 691 kg kako bi se uzela u obzir povećana težina motora, jedinica za povrat energije i specifikacija guma. Ograničenje u boksovima 
je ponovno smanjeno sa 100 km/h na 80 km/h. Vozači su mogli koristiti samo pet motora tijekom ove sezone, što je pad naspram osam motora u 
prošloj sezoni. Pravila su nalagala korištenje motora s kutom od devedeset stupnjeva, s fiksnom radilicom i montažnim točkama za šasiju, dok 
su motori bili ograničeni na 15 000 okretaja u minuti. Pojedinačne jedinice motora prema specifikacijama iz 2014. morale su trajati najmanje 
4000 km prije zamjene, u usporedbi s motorima prije 2014. koji su morali trajati samo 2000 km. Motori, sada poznati kao "pogonske jedinice", 
podijeljeni su u šest zasebnih komponenti: motor s unutarnjim izgaranjem (ICE); turbopunjač (TC); Motor Generator Unit-Kinetic (MGU-K), koji 
skuplja energiju koja bi inače bila izgubljena pri kočenju; Motor Generator Unit-Heat (MGU-H), koji je skupljao energiju u obliku topline dok 
je bila izbačena kroz ispuh; Spremište energije (ES), koje je funkcioniralo kao baterije, čuvajući energiju prikupljenu od strane Motor 
Generator Units; i upravljačku elektroniku (CE), koja je uključivala elektroničku upravljačku jedinicu i softver koji se koristio za 
upravljanje cijelom pogonskom jedinicom. Sezonu je obilježila i velika tragedija sa smrtnim ishodom koja se nije desila još od 1994. godine.
Dana 5. listopada 2014. godine, na kišnoj VN Japan, za vrijeme dvostrukih žutih zastava zbog bolida zaglavljenog u šljunku, Jules Bianchi 
(FRA) je izgubio kontrolu nad bolidom te podletio pod traktorsku dizalicu koja je u tom trenutku micala bolid. FIA je objavila detalje 
nesreće u kojoj je Bianchi pretrpio najveće usporenje od 254 g (ekvivalent gravitacijske sile, g-force) u trenutku dok je udario u 6.8 tona 
tešku dizalicu - Francuz je sa staze izletio pri brzini od 198 km/h, a u dizalicu je udario 2,61 sekundi kasnije brzinom od 125 km/h. Nakon 
devetomjesečne borbe s posljedicama sudara na japanskoj Suzuki, Jules Bianchi je preminuo 17. srpnja 2015. godine. Mediji, a i mnogi navijači
su se pitali zašto je dizalica bila na stazi, umjesto iza barijera, te su pozivali na odgovornost vodećih u organizaciji od koje naravno nije
bilo ni traga.'
where godina_osvajanja=2014;

update konstruktorski_naslov set opis=
'66. sezona u prvenstvu Formule 1. Bilo je 19 utrka, 10 momčadi i 22 vozača. 4. konstruktorski naslov osvaja Mercedes s bolidom oznake 
F1 W06 Hybrid, a njihov vozač Lewis Hamilton (UK) treći puta postaje svjetski prvak. Mercedes je završio sezonu s rekordnih 703 boda. Ovo je 
bila prva sezona u F1 za Carlosa Sainza (SPA) i Maxa Verstappena (NLD). Ova sezona je također vidjela povratak VN Mexica, održana prvi puta 
nakon 1992. godine. Broj pogonskih jedinica koje vozač može koristiti smanjen je s pet na četiri, a minimalna težina bolida je porasla za 
11 kg, došavši tako na 702 kg.'
where godina_osvajanja=2015;

update konstruktorski_naslov set opis=
'67. sezona u prvenstvu Formule 1. Bilo je 21 utrka, 11 momčadi i 24 vozača. 5. konstruktorski naslov osvaja Mercedes s bolidom oznake 
F1 W07 Hybrid, a njihov vozač Nico Rosberg (GER) osvojio je vozački naslov s 5 bodova prednosti ispred momčadskog kolege. Tako je postao
drugi sin prvaka koji je i sam postao prvak, pothvat koji je prethodno postigao Damon Hill 1996. godine. Do danas je posljednji Nijemac koji
je osvojio vozački naslov. Mercedes je pobijedio na 19 od 21 utrka, osvojivši ukupno 765 bodova, čak 297 bodova ispred drugoplasiranog 
konstruktora. Sezonu je obilježila drama Mercedesovih vozača, gdje je Rosberg smatrao da je stalno zakinut i da se favorizira Hamilton,
odnosno da vozači nisu ravnopravni kako je po ugovoru dogovoreno, nego je Hamilton bio 1. vozač, a Rosberg 2. vozač (danas se često naziva
vodonoša). Dolazilo je do raznih okršaja na stazi, a išlo se toliko daleko da su zamijenili cijelu ekipu koja je vodila Hamiltona te su
prešli kod Rosberga, i obrnuto. Rosberg je koristio medijsku pažnju kako bi osigurao da oba vozača imaju jednake bolide i da smanji utjecaj
unutarmomčadskih politika i favoriziranja, što je to više moguće, te je naglašavao da je pobijedio Hamiltona u istoj mašineriji. 5 dana nakon
osvajanja naslova objavio je svoje umirovljenje.'
where godina_osvajanja=2016;

update konstruktorski_naslov set opis=
'68. sezona u prvenstvu Formule 1. Bilo je 20 utrka, 10 momčadi i 25 vozača. 6. konstruktorski naslov osvaja Mercedes s bolidom oznake 
F1 W08 EQ Power+, a njihov vozač Lewis Hamilton (UK) osvojio je 4. vozački naslov. Tehnički propisi koji reguliraju dizajn karoserije revidirani 
su, s ciljem poboljšanja vremena kruga za četiri do pet sekundi u odnosu na generaciju bolida prošle sezone. Ukupna širina bolida povećana 
je s 1800 na 2000 mm. Širina karoserije povećana je s 1400 na 1600 mm. Širina prednjeg krila povećana je s 1650 na 1800 mm. Stražnje krilo 
spušteno je za 150 mm, sa 950 na 800 mm i pomaknuto unazad za 200 mm. Visina stražnjeg difuzora povećana je sa 125 na 175 mm, a širina 
povećana s 1000 na 1050 mm, a vodeći rub pomaknut je sa središnje linije stražnjeg kotača 175 mm naprijed. Vodeći rub dasaka teglenice 
pomaknut je naprijed kako bi timovima omogućio više slobode u kontroli protoka zraka. Širina gume povećana je za 25% kako bi se bolidima 
omogućilo bolje mehaničko prianjanje. Širina prednje gume povećana je s 245 na 305 mm, a širina stražnje gume povećana je s 325 na 405 mm.
Promjer guma (prednji i stražnji) također je malo povećan sa 660 na 670 mm. Minimalna težina bolida, uključujući vozača, povećana je za 26 kg,
sa 702 na 728 kg. Maksimalna potrošnja goriva povećana je sa 100 na 105 kg kako bi se uzeli u obzir teži, širi i brži bolidi u zavojima.'
where godina_osvajanja=2017;

update konstruktorski_naslov set opis=
'69. sezona u prvenstvu Formule 1. Bilo je 21 utrka, 10 momčadi i 20 vozača. 7. konstruktorski naslov osvaja Mercedes s bolidom oznake 
F1 W09 EQ Power+, a njihov vozač Lewis Hamilton (UK) osvojio je 5. vozački naslov. Sezonu je obilježila druga uzastopna godina borbe Mercedesa
i Ferrarija, kao i njihovih vozača Lewisa Hamiltona (UK) i Sebastiana Vettela (GER). Bilo je to prvi put u povijesti Formule 1 da se dva 
četverostruka svjetska prvaka natječu za peti naslov. Predstavljen je novi uređaj za zaštitu kokpita, poznat kao "halo" (oreol). Uvođenje 
haloa bila je prva faza planiranog predstavljanja prema kojem bi uređaj bio usvojen u svim serijama otvorenih kotača odobrenih od strane 
FIA-e do 2020. godine.'
where godina_osvajanja=2018;

update konstruktorski_naslov set opis=
'70. sezona u prvenstvu Formule 1. Bilo je 21 utrka, 10 momčadi i 20 vozača. 8. konstruktorski naslov osvaja Mercedes (kao samostalna ekipa
svoj 6. uzastopni) s bolidom oznake F1 W10 EQ Power+, a njihov vozač Lewis Hamilton (UK) osvojio je 6. vozački naslov. Uslijedile su i neke
tehničke promjene na bolidima, a od istaknutijih je da su maksimalne razine goriva podignute sa 105 na 110 kg kako bi se smanjila potreba
vozača da štede gorivo tijekom utrke. Težina vozača više se ne uzima u obzir pri mjerenju minimalne težine automobila. Vozači koji teže manje 
od 80 kg moraju ovu težinu nadoknaditi balastom koji se nalazi oko sjedala kako bi se smanjio mogući dobitak performansi. Propisi su uveli 
bonus bodove vozaču (i konstruktoru) koji odvozi najbrži krug u utrci. Bod se dodjeljuje samo ako je vozač klasificiran u prvih deset na 
kraju utrke. Ovo je prvi puta od 1959. godine da se bonus bod dodjeljuje za postizanje najbržeg kruga utrke.'
where godina_osvajanja=2019;

update konstruktorski_naslov set opis=
'71. sezona u prvenstvu Formule 1. Bilo je 17 utrka, 10 momčadi i 23 vozača. 9. konstruktorski naslov osvaja Mercedes s bolidom oznake 
F1 W11 EQ Performance, a njihov vozač Lewis Hamilton (UK) osvojio je 7. vozački naslov, izjednačivši rekord Michaela Schumachera (GER).
Također je oborio Schumacherov rekord od 91 pobjeda u karijeri. Mercedes kao samostalna ekipa je također osvojila svoj 7. uzastopni 
konstruktorski naslov i tako oborila Ferrarijev rekord koji je između 1999. i 2004. osvojio 6 uzastopnih konstruktorskih naslova. Kako bi se
smanjio rizik od puknuća, zadnjih 50 mm prednjeg krila više nije moglo sadržavati nikakav metal. Kočioni kanali se više ne mogu povjeravati 
vanjskim izvođačima i mora ih izraditi i dizajnirati tim. Količina goriva koja je mogla biti izvan spremnika smanjena je s 2 litre na 250
mililitara. Smanjenje elektroničkih pomagala vozaču značilo je da su vozači bili odgovorni za upravljanje većim okretnim momentom bolida 
tijekom startova utrke. Uoči otvaranja sezone za VN Austrije, Red Bull je pokrenuo prosvjed protiv upravljanja s dvije osovine (DAS - dual
axis steering) Mercedesa, sustava u kojem vozač može podesiti prednji dio automobila povlačenjem i guranjem upravljača. Utvrđeno je da je 
sustav legalan za ovu sezonu, ali da će biti zabranjen od iduće sezone.'
where godina_osvajanja=2020;

update konstruktorski_naslov set opis=
'72. sezona u prvenstvu Formule 1. Bilo je 22 utrke, 10 momčadi i 21 vozač. 10. konstruktorski naslov osvaja Mercedes s bolidom oznake
F1 W12 E Performance, a vozač Red Bulla Max Verstappen (NLD) postao je svjetski prvak. Ovu sezonu je obilježila kontroverzna završnica tokom 
razdoblja sigurnosnog automobila, gdje je u predzadnjem krugu propušteno 5 bolida između Hamiltona koji je vodio utrku i Verstappena
koji je bio iza njega. Problem leži u tome da je pravilo da se svi bolidi koji zaostaju puni krug propuste, ali u tom slučaju ne bi došlo do
borbe vozača jer ne bi bilo vremena da se bolidi dovoljno udalje za neometano utrkivanje, u kojem slučaju bi Hamilton odnio pobjedu i vozački
naslov. Mnogi smatraju to nepravdom i izvrtanjem pravila, kao i namještaljkama, što ne bi bio ni prvi, a nažalost vjerojatno ni zadnji slučaj.
Nakon istrage FIA-e, Michael Masi je smijenjen s uloge direktora utrke. Minimalna težina bolida opet je povećana, sa 746 na 749 kg. Uvodi se 
aerodinamički hendikep za uspješnije momčadi u smislu dopuštenog broja sati za aerodinamički razvoj ovisno o poziciji u konstruktorskom 
prvenstvu iz prošle sezone. Tako će konstruktorski prvaci iz 2020. imati 36 sati korištenja zračnoga tunela tjedno dok će deseta momčad u 
poretku imati 45 sati korištenja zračnoga tunela tjedno. Također su uvedene Sprint kvalifikacije i utrke. Ovo je bila posljednja sezona za 
svjetskog prvaka Kimija Räikkönena (FIN).'
where godina_osvajanja=2021;

update konstruktorski_naslov set opis=
'73. sezona u prvenstvu Formule 1. Bilo je 22 utrke, 10 momčadi i 22 vozača. 5. konstruktorski naslov osvaja Red Bull s bolidom oznake RB18,
a njihov vozač Max Verstappen (NLD) osvojio je svoj drugi vozački naslov. Ovo je bila posljednja sezona za četverostrukog svjetskog prvaka
Sebastiana Vettela (GER), a Lewis Hamilton (UK) je u Mercedesu imao jako tešku sezonu, gdje nije pobijedio ni u jednim kvalifikacijama ili
utrci. Tehnički propisi ponovno su uveli korištenje efekta tla (ground effect) po prvi put otkako su venturi tuneli ispod bolida zabranjeni 
1983. godine. Ovo se poklapa s pojednostavljenjem karoserije, čineći donji dio bolida primarnim izvorom aerodinamičkog prianjanja. Ovo ima za 
cilj smanjiti turbulentni zrak iza bolida kako bi vozači mogli bolje pratiti jedni druge, a da istovremeno zadrže sličnu razinu potisne sile 
u usporedbi s prethodnim godinama. Daljnje promjene aerodinamike imaju za cilj ograničiti sposobnost momčadi da kontroliraju protok zraka oko 
prednjih kotača i dodatno smanjiti aerodinamički trag bolida. To uključuje eliminaciju bargeboarda, složenih aerodinamičkih uređaja koji 
manipuliraju protokom zraka oko karoserije bolida. Prednje krilo i završne ploče su pojednostavljene, smanjujući broj i složenost 
aerodinamičkih elemenata. Prednje krilo se također mora izravno spojiti na nosni konus, za razliku od dizajna prije 2022. gdje se krilo moglo 
povezati s nosom preko nosača kako bi se stvorio prostor ispod monokoka, čime se potiče protok zraka ispod bolida putem veće površine krila i 
povećana visina nosa. Stražnja krila su šira i postavljena više nego prethodnih godina, s dodatnim ograničenjima koja ograničavaju mogućnost 
konstruktora da koriste ispušne plinove bolida za stvaranje potisne sile. Promjer kotača povećan je s 13 inča (33 cm) na 18 inča (46 cm). 
Kotači od 18 inča uvedeni su u prvenstvo Formule 2 2020. kako bi se testirale promjene u ponašanju guma. Ukinuto je pravilo koje je bilo na 
snazi od 2014. godine, prema kojem vozači koji napreduju u treći segment kvalifikacija moraju započeti utrku na gumama koje su koristili za 
postizanje svog najbržeg vremena u drugom segmentu kvalifikacija; svi vozači sada imaju slobodan izbor startne gume za utrku u nedjelju na 
svim utrkama.'
where godina_osvajanja=2022;



-- VOZAČKI NASLOV

update vozacki_naslov set opis=
'Svoj prvi vozački naslov osvojio je Fernando Alonso (SPA) za momčad Renault. Time je s 24 godine i 59 dana srušio tadašnji rekord Emersona 
Fittipaldija za najmlađeg svjetskog prvaka. Karijeru u Formuli 1 započeo je 2001. u Minardiju, nakon čega je 2002. prešao u Renault te postao 
njihov testni vozač. 2003. godine postao je najmlađi vozač koji je do tada ostvario prvo startno mjesto te najmlađi pobjednik u utrci F1. 
Alonso je prvi španjolski vozač Formule 1 koji je osvojio naslov prvaka. Vlasnik je momčadi FA Racing koja se natječe u kategoriji eSportova, 
Formuli Renault, Formuli 4 te kartingu. Osnivač je i ambasador modnog brenda Kimoa te UNICEF-ov ambasador dobre volje.'
where godina_osvajanja=2005;

update vozacki_naslov set opis=
'Svoj drugi vozački naslov osvojio je Fernando Alonso (SPA) za momčad Renault. Time je postao i najmlađi dvostruki svjetski prvak. Jedini je
vozač u povijesti koji je dva puta uvršten u FIA-inu Kuću slavnih. Dvostruki je pobjednik utrke 24 sata Le Mansa te pobjednik utrke 24 sata 
Daytone. Često ga se smatra jednim od najboljih i najkompletnijih vozača u Formuli 1. '
where godina_osvajanja=2006;

update vozacki_naslov set opis=
'Svoj prvi vozački naslov osvojio je Lewis Hamilton (UK) za momčad McLaren, i to za jedan bod ispred viceprvaka Felipea Masse (BRA). Sezonu 
prije, odnosno prvu u kojoj je nastupao, završio je kao viceprvak, i to jedan bod iza svjetskog prvaka Kimija Räikkönena (FIN). Nakon 
osvajanja šest naslova u raznim karting natjecanjima od 1995. do 2000., Hamilton je debitirao u jednosjedu 2001. u Britanskoj Formuli Renault 
Winter Series. 2003. godine osvaja naslov prvaka u Britanskoj Formuli Renault 2.0 za momčad Manor Motorsport, a 2005. naslov prvaka u Euro 
Formula 3 prvenstvu za momčad ASM Formule 3. 2006. godine osvaja naslov prvaka u GP2 Series prvenstvu za momčad ART Grand Prix.'
where godina_osvajanja=2008;

update vozacki_naslov set opis=
'Svoj drugi vozački naslov osvojio je Lewis Hamilton (UK) za momčad Mercedes. Promjene propisa za sezonu 2014., koje su nalagale upotrebu 
turbo-hibridnih motora, odnosno novi 1.6L V6 motori, pridonijele su početku vrlo uspješne ere za Hamilton. Te je godine Mercedes osvojio 16 
od 19 utrka te sezone, 11 od onih koje je osigurao Hamilton dok je pobijedio u dvoboju za naslov koji je trajao cijelu sezonu protiv 
momčadskog kolege Rosberga. Osvojivši svoj drugi vozački naslov i zasjenivši zbroj pobjeda svih britanskih vozača prije njega, Hamilton je 
izjavio preko timskog radija nakon finalne utrke u Abu Dhabiju: "Ovo je najbolji dan u mom životu." Novi vozački broj propisi doneseni za 
2014. omogućili su vozačima da odaberu jedinstveni broj bolida koji će koristiti tijekom cijele karijere, pa je Hamilton odlučio voziti pod 
svojim starim karting brojem 44 do kraja karijere.'
where godina_osvajanja=2014;

update vozacki_naslov set opis=
'Svoj treći vozački naslov osvojio je Lewis Hamilton (UK) za momčad Mercedes. Hamilton je u obranu naslova krenuo pobjedom s pole positiona 
u Australiji, a nakon Vettelovog slavlja u Maleziji, Hamilton ostvaruje dvije pobjede u nizu. Rosberg ga je prvi put porazio na petoj utrci 
prvenstva u Španjolskoj, a Hamilton gubi sigurnu pobjedu u Monaku zbog krive procjene momčadi koja ga je nepotrebno pozvala u boks za vrijeme 
sigurnosnog automobila. U Kanadi, Lewis dolazi do četvrte pobjede u sezoni, a uslijedio je drugi poraz od momčadskog kolege u Austriji gdje 
je završio drugi. U Mađarskoj je Lewis još jednom startao s pole positiona, ali gubi vodstvo na startu i u utrci punoj grešaka dolazi do 
šestog mjesta. Uslijedile su pobjede u Belgiji i dominantna pobjeda u Italiji na novoj specifikaciji motora gdje je startao prvi, odvozio 
najbrži krug i vodio svaki krug utrke. Na tri utrke u Japanu, Rusiji i SAD-u, Hamilton je startao drugi, ali i upisao tri pobjede što mu je 
bilo dovoljno za treći naslov prvaka. Time je postao tek deseti vozač u povijesti Formule 1 s tri ili više naslova.'
where godina_osvajanja=2015;

update vozacki_naslov set opis=
'Svoj četvrti vozački naslov osvojio je Lewis Hamilton (UK) za momčad Mercedes. Nakon Rosbergova umirovljenja, Sebastian Vettel iz Ferrarija 
postao je Hamiltonov najbliži suparnik jer su njih dvojica izmjenjivali vodstvo u prvenstvu tijekom 2017. u napetoj borbi za naslov. Njegova 
dosljednost (završavanje svake utrke u bodovima), kao i nedostatak ozbiljnog izazova od strane njegovog novog momčadskog kolege Valtterija 
Bottasa (FIN), vidjeli su zabilježavanje devet pobjeda u utrkama te je time osigurao svoj četvrti naslov svjetskog vozača jer je poništio 
bodovni zaostatak za Vettelom u prvoj polovici sezone, naposljetku završivši naslov u Meksiku s dvije utrke viška.'
where godina_osvajanja=2017;

update vozacki_naslov set opis=
'Svoj peti vozački naslov osvojio je Lewis Hamilton (UK) za momčad Mercedes. Sezona 2018. bila je prvi put da će se dva četverostruka s
vjetska prvaka, Hamilton i Vettel, natjecati za peti naslov, a novinari i navijači su je nazvali "borbom za pet". Kao i prethodne sezone, 
činilo se da Ferrari i Vettel imaju prednost tijekom većeg dijela sezone, te su bili na vrhu poretka do polovine puta. Međutim, Vettelova 
sezona raspala se s nekim vozačkim i brojnim mehaničkim pogreškama, kao i još brojnijih pogrešaka momčadi Ferrari, dok je Hamiltonova serija 
šest pobjeda od sedam u drugoj polovici sezone dovela do toga da je Hamilton osvojio naslov u Meksiku drugu godinu za redom, postavivši novi 
rekord za najviše bodova osvojenih u sezoni (408). Tijekom sezone, Hamilton je potpisao dvogodišnji ugovor s Mercedesom, koji je navodno 
vrijedan do 40 milijuna funti godišnje, što ga čini najbolje plaćenim vozačem Formule 1 u povijesti.'
where godina_osvajanja=2018;

update vozacki_naslov set opis=
'Svoj šesti vozački naslov osvojio je Lewis Hamilton (UK) za momčad Mercedes. Nakon što je potpisao ugovor s Mercedesom koji je trajao do 
kraja 2020. godine, potvrđeno je da će Hamilton braniti svoj naslov 2019. godine. Hamilton je veći dio sezone vodio u poretku vozača, braneći 
izazove za naslov od momčadskog kolege Bottasa, Verstappenova Red Bulla s Hondom i Ferrarijevog nedavno promoviranog Leclerca, da bi osvojio 
svoju šestu vozačku krunu na VN SAD-a 2019. s dvije preostale utrke. Nakon što je u posljednjoj utrci sezone osvojio svoj šesti Grand Slam
(također poznat kao "Grand Chelem", nevjerojatno je teško postići. Zahtijeva da vozač zauzme pole position, vodi u svakom krugu utrke, 
pobijedi u utrci i postavi najbrži krug utrke.) u karijeri, Hamilton je završio sezonu s 11 pobjeda (poklapajući se s prethodnim najboljim 
rezultatom iz 2014. i 2018.) i 17 postolja (izjednačavajući četvrti put rekord svih vremena), kao i osvojivši 5 pole positiona. Njegovih 
ukupno 413 bodova u sezoni bio je novi rekord svih vremena, čime je završio s 87 bodova prednosti u odnosu na drugoplasiranog Bottasa.'
where godina_osvajanja=2019;

update vozacki_naslov set opis=
'Svoj sedmi vozački naslov osvojio je Lewis Hamilton (UK) za momčad Mercedes, kojemu je to bio 7. uzastopni konstruktorski naslov. Time 
je Hamilton izjednačio Schumacherov rekord te su do danas to jedina dva vozača koja imaju 7 osvojenih vozačkih naslova. Tijekom skraćene 
sezone od 17 utrka, Hamilton je odnio 11 pobjeda (izjednačivši svoj prethodni osobni rekord, ali u manje utrka), uključujući onu u Portugalu, 
čime je srušio Schumacherov rekord od 91 pobjede. Hamilton je osvojio naslov na VN Turske 2020. s tri utrke viška i završio sezonu sa 124 
bodova više od svog momčadskog kolege Bottasa, koji je završio drugi u poretku.'
where godina_osvajanja=2020;

update vozacki_naslov set opis=
'Svoj prvi vozački naslov osvojio je Max Verstappen (NLD) za momčad Red Bull. Vozački naslov je obilježen velikom kontroverzom. Verstappen i 
Hamilton imali su jednak broj bodova u prvenstvu vozača koji je ulazio u posljednju rundu, VN Abu Dhabija, s Verstappenom koji je vodio u 
odbrojavanju. Verstappen je prestigao Hamiltona u posljednjem krugu i osvojio utrku, te svoje prvo svjetsko prvenstvo u Formuli 1 za vozače.
Verstappen, koji se kvalificirao na pole positionu za gotovo četiri desetinke sekunde prednosti, imao je spor start izvan linije na početku 
utrke i pao na drugo mjesto. Verstappen je zaostajao za Hamiltonom više od deset sekundi sve dok je kasno u utrci, 7 krugova prije kraja, 
sigurnosni automobil pozvan zbog sudara u zavoju 14 u kojem je sudjelovao vozač Williamsa Nicholas Latifi (CAN). Povlačenje sigurnosnog 
automobila i nastavak utrke nakon razdoblja sigurnosnog automobila naišli su na kontroverze. Direktor utrke Michael Masi dopustio je prolaz 
samo određenom broju bolida u krugu (njih 5 koji su bili između vodećeg Hamiltona i drugoplasiranog Verstappena), koji su nakon utrke 
donijeli prosvjed Mercedesovog tima i izrazili namjeru žalbe na rezultat utrke, tvrdeći da bi svi bolidi u krugu koji zaostaju puni krug ili 
više trebali biti pušteni. Red Bull je kontraargumentima da to nije bilo određeno tekstom pravilnika. Prosvjed je odbijen, iako je kasnija 
istraga FIA-e zaključila da je Masi pogrešno protumačio pravilo, a tekst pravila je izmijenjen za sezonu 2022. kako bi se preciziralo da će 
se "svi" bolidi sami osloboditi kruga (po odluci direktora utrke), a ne "bilo koji". Verstappen je prestigao Hamiltona u petom zavoju 
posljednjeg kruga utrke i postao 34. svjetski prvak Formule 1, iako za mnoge s upitnim kredibilitetom.'
where godina_osvajanja=2021;

update vozacki_naslov set opis=
'Svoj drugi vozački naslov osvojio je Max Verstappen (NLD) za momčad Red Bull. U ožujku 2022. Verstappen je potpisao petogodišnje produljenje 
ugovora s Red Bull Racingom za sezone 2023. do 2028. Verstappen je pretrpio dva odustajanja zbog sustava goriva u prve tri utrke, nalazeći se 
46 bodova iza vodećeg u prvenstvu Charlesa Leclerca (MCO). Odgovorio je pobjedom u pet od sljedećih sedam utrka, što mu je omogućilo da 
preuzme vodstvo u prvenstvu i izgradi zaostatak od 37 bodova u odnosu na drugo mjesto, koje je do tada držao njegov timski kolega Sergio 
Pérez (MEX). Nastavit će dominirati većim dijelom sezone, pobijedivši u 15 utrka, time oborivši rekord za najviše pobjeda u sezoni Formule 1, 
koji su prethodno zajedno držali Michael Schumacher (GER) (2004.) i Sebastian Vettel (GER) (2013.) s 13 pobjeda u sezoni.'
where godina_osvajanja=2022;