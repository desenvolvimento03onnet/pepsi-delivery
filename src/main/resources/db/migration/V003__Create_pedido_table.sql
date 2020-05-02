CREATE TABLE pedido (
	id_pedido		SERIAL				PRIMARY KEY,
	data_pedido		Date				NOT NULL,
	hora_pedido		Time				NOT NULL,
	finalizado  	boolean 			NOT NULL,
	id_cliente		bigint				NOT NULL,
	CONSTRAINT fk_pedido_cliente FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)
);