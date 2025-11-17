CREATE DATABASE sistema;
USE sistema;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(20),
    endereco VARCHAR(150),
    telefone VARCHAR(20)
);
select * from  clientes;