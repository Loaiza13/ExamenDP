CREATE DATABASE pruebas_dp

USE pruebas_dp

CREATE TABLE addresses(
calle varchar(30),
numero varchar(8),
colonia varchar(30),
id varchar(8)
);

CREATE TABLE distributors(
id varchar(8),
fecharegistro date
);

CREATE TABLE persons(
nombre varchar(30),
appaterno varchar(30),
apmaterno varchar(30),
id varchar(8)
);

DELIMITER //
CREATE PROCEDURE consultarDatosDistribuidor(cID varchar(8))
BEGIN
   SELECT concat_ws(' ', a.nombre, a.appaterno, a.apmaterno) as nombre_completo, b.calle as Calle, b.numero as Numero_de_casa, b.colonia as Colonia from persons as a inner join addresses as b on (a.id = b.id) inner join distributors as c on (b.id = c.id) where c.id = cID;
END //

DELIMITER //
CREATE PROCEDURE PROC_AGREGARDISTRIBUIDOR (id VARCHAR(8),fecharegistro date, nombre varchar(30), appaterno varchar(30), apmaterno varchar(30), calle varchar(50), numero varchar(7),colonia varchar(50))
AS    
BEGIN

    INSERT INTO addresses(calle, numero, colonia,id)
 VALUES(calle,numero, colonia, id );

    INSERT INTO distributors(id, fecharegistro)
    VALUES(id,fecharegistro);

    INSERT INTO persons(nombre,appaterno, apmaterno, id)
    VALUES(nombre, appaterno, apmaterno, id);
END;//

DELIMITER //
CREATE FUNCTION fnConsultarId(cId VARCHAR(8))
RETURNS INTEGER
BEGIN
    
    if exists(select id from addresses where id = cId)THEN
        return 1;
    else
        return 0;
    end if;
    
END //

INSERT INTO addresses(calle, numero, colonia,id)
 VALUES('Viena','5136', 'Villa Verde', '1' );

INSERT INTO distributors(id, fecharegistro)
VALUES('1',CURRENT_DATE);

INSERT INTO persons(nombre,appaterno, apmaterno, id)
VALUES('Jose Carlos', 'Loaiza', 'Almeida', '1');

INSERT INTO addresses(calle, numero, colonia,id)
 VALUES('Guillermo Frio','4114', 'Ferro', '2' );

INSERT INTO distributors(id, fecharegistro)
VALUES('2',CURRENT_DATE);

INSERT INTO persons(nombre,appaterno, apmaterno, id)
VALUES('Luis Jesus', 'Gonzalez', 'Samano', '2');

