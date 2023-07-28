create table clientes (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    primeiro_nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    idade INTEGER(2) NOT NULL,
    email VARCHAR(50) NULL
);