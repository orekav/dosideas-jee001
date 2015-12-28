DROP TABLE IF EXISTS pais;
DROP TABLE IF EXISTS provincia;

CREATE TABLE pais (
    id BIGINT IDENTITY PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE provincia (
    id BIGINT IDENTITY PRIMARY KEY,
    id_pais BIGINT,
    nombre VARCHAR(50),
    FOREIGN KEY(id_pais) REFERENCES pais(id)
);


INSERT INTO pais VALUES (1, 'Argentina');
INSERT INTO pais VALUES (2, 'Brasil');

INSERT INTO provincia VALUES (1, 1, 'Buenos Aires');
INSERT INTO provincia VALUES (2, 1, 'Capital Federal');
INSERT INTO provincia VALUES (3, 1, 'Catamarca');
INSERT INTO provincia VALUES (4, 1, 'Chaco');
INSERT INTO provincia VALUES (5, 1, 'Chubut');
INSERT INTO provincia VALUES (6, 1, 'Cordoba');
INSERT INTO provincia VALUES (7, 1, 'Corrientes');
INSERT INTO provincia VALUES (8, 1, 'Entre Rios');
INSERT INTO provincia VALUES (9, 1, 'Formosa');
INSERT INTO provincia VALUES (10, 1, 'Jujuy');
INSERT INTO provincia VALUES (11, 1, 'La Pampa');
INSERT INTO provincia VALUES (12, 1, 'La Rioja');
INSERT INTO provincia VALUES (13, 1, 'Mendoza');
INSERT INTO provincia VALUES (14, 1, 'Misiones');
INSERT INTO provincia VALUES (15, 1, 'Neuquen');
INSERT INTO provincia VALUES (16, 1, 'Rio Negro');
INSERT INTO provincia VALUES (17, 1, 'Salta');
INSERT INTO provincia VALUES (18, 1, 'San Juan');
INSERT INTO provincia VALUES (19, 1, 'San Luis');
INSERT INTO provincia VALUES (20, 1, 'Santa Cruz');