CREATE SCHEMA `transporte_abc` ;
USE transporte_abc;

CREATE TABLE ABC_LANGUAGE(
	idLanguage INT PRIMARY KEY AUTO_INCREMENT,
    dLanguage VARCHAR(50)
);

CREATE TABLE PROVIDER(
	idProvider INT PRIMARY KEY AUTO_INCREMENT,
    providerName VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255),
    numVehicles INT
);

CREATE TABLE DRIVER(
	idDriver INT PRIMARY KEY AUTO_INCREMENT,
    driverName VARCHAR(50)
);

CREATE TABLE VEHICLE(
	idVehicle INT PRIMARY KEY AUTO_INCREMENT,
    vehiclePlate VARCHAR(15),
    brandName VARCHAR(50),
    model VARCHAR(50),
    idDriver INT,
    state VARCHAR(30),
    
    FOREIGN KEY (idDriver) REFERENCES DRIVER(idDriver)
);


INSERT INTO ABC_LANGUAGE (dLanguage) VALUES('Spanish'), ('English');
INSERT INTO DRIVER (driverName) VALUES('Andrés Parra'), ('Eric Fonseca'), ('Anderson Puentes');
INSERT INTO VEHICLE (vehiclePlate, brandName, model, idDriver, state) 
VALUES ('ABC-123', 'Abarth', 'Spider 124', 1, 'ACTIVO'), ('DEF-456', 'Alfa Romeo', 'Giulia', 1, 'ACTIVO'),
('GHI-789', 'Alphine', 'A110', 1, 'ACTIVO'), ('JKL-101', 'Aston Martin', 'DB11', 1, 'ACTIVO');
INSERT INTO PROVIDER (providerName, address, email, numVehicles) 
VALUES ('Proveedor A', 'Calle 15 #11A-10', 'provA@gmail.com', 122), ('Proveedor B', 'KR 150 #112B-12', 'provB@gmail.com', 94);