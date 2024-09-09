CREATE TABLE Takimlar
(
id SERIAL PRIMARY KEY,
takım_ad varchar(50),
kurulus_tarihi date,
state integer DEFAULT 1,
createat int DEFAULT EXTRACT(epoch FROM now()),
updateat int DEFAULT EXTRACT(epoch FROM now())
)

CREATE TABLE Oyuncular
(
id serial PRIMARY KEY,
ad varchar(50),
soyad varchar(50),
dtarihi date,
takim_id INTEGER NOT NULL REFERENCES Takimlar(takim_id),
state integer DEFAULT 1,
createat int DEFAULT EXTRACT(epoch FROM now()),
updateat int DEFAULT EXTRACT(epoch FROM now())
)