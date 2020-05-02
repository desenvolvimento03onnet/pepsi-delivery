CREATE TABLE produto (
	id_produto		SERIAL				PRIMARY KEY,
	nome			VARCHAR(150)		NOT NULL,
	categoria		VARCHAR(50)			NOT NULL,
	valor			double precision	NOT NULL
);