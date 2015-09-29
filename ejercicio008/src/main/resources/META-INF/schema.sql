CREATE TABLE 
	cine 
(
	idCine INT NOT NULL, 
	nombre VARCHAR(45) NOT NULL,
CONSTRAINT 
	PK_CINE PRIMARY KEY (idCine)
);
CREATE TABLE 
	sala 
(
	idSala INT NOT NULL, 
	version INT NOT NULL, 
	nombre VARCHAR(45) NOT NULL, 
	idCine INT NOT NULL, 
	aforo INT NOT NULL, 
	disponibles INT NOT NULL, 
CONSTRAINT 
	PK_SALA PRIMARY KEY (idSala)
);
CREATE TABLE 
	venta 
(
	idVenta INT NOT NULL,
	cantidad INT NOT NULL,
	importe FLOAT NOT NULL,
	idSala INT NOT NULL,	
CONSTRAINT
	PK_VENTA PRIMARY KEY (idVenta)
);
ALTER TABLE sala ADD CONSTRAINT idCine_fk FOREIGN KEY (idCine) REFERENCES cine (idCine) ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE venta ADD CONSTRAINT idSala_fk FOREIGN KEY (idSala) REFERENCES sala (idSala) ON UPDATE NO ACTION ON DELETE NO ACTION;
-- DROP TABLE venta;
-- DROP TABLE sala;
-- DROP TABLE cine;
INSERT INTO `cine` (`idCine`, `nombre`) VALUES(1, 'Capito');
INSERT INTO `sala` (`idSala`, `version`, `nombre`, `idCine`, `aforo`, `disponibles`) VALUES(1, 1, 'Groucho', 1, 7, 7);
INSERT INTO `sala` (`idSala`, `version`, `nombre`, `idCine`, `aforo`, `disponibles`) VALUES(2, 1, 'Harpo', 1, 100, 100);
INSERT INTO `sala` (`idSala`, `version`, `nombre`, `idCine`, `aforo`, `disponibles`) VALUES(3, 1, 'Chico', 1, 85, 85);
COMMIT;