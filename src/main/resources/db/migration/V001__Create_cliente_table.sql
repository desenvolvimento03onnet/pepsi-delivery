CREATE TABLE cliente (
	id_cliente		SERIAL			PRIMARY KEY,
	nome			VARCHAR(150)	NOT NULL,
	sobrenome		VARCHAR(50)		NOT NULL,
	cpf				VARCHAR(14)		NOT NULL,
	email			VARCHAR(200)	NOT NULL,
	senha			VARCHAR(255)	NOT NULL
);