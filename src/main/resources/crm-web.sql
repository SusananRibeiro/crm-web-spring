-- CRM WEB
create table clientes (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    primeiro_nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    idade INTEGER(2) NOT NULL,
    email VARCHAR(50) NULL
);

INSERT INTO clientes (cpf, primeiro_nome, sobrenome, idade, email) VALUES ('12345678901', 'Carla Cristina', 'Silva', 25, 'carla@mail.com');
SELECT * FROM clientes;
DROP TABLE clientes;