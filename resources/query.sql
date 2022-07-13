CREATE DATABASE bfgbd;

CREATE TABLE clientes(
    CpfID bigint(11) NOT NULL,
    Nome varchar(50) NOT NULL,
    DataNascimento date NOT NULL,
    Telefone bigint(14),
    Email varchar(50),
    PRIMARY KEY (CpfID)
);

CREATE TABLE contas(
    ContaID bigint(8) NOT NULL,
    Saldo float NOT NULL,
    DataAbertura date NOT NULL,
    ClienteID bigint(11) NOT NULL,
    PRIMARY KEY (ContaID),
    FOREIGN KEY (ClienteID) REFERENCES clientes(CpfID)
)