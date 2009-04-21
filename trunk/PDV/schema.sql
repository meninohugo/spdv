CREATE TABLE Funcionario(
    idFuncionario   INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome            VARCHAR(45) NOT NULL 
);

CREATE TABLE OrdemDeCompra(
    idOrdemDeCompra INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    valor           DOUBLE NOT NULL,
    qtdeProdutos    TINYINT UNSIGNED NOT NULL,
    data            DATE NOT NULL,
    idFuncionario   INTEGER NOT NULL,    
    FOREIGN KEY(idFuncionario) REFERENCES Funcionario(idFuncionario)
);

CREATE TABLE Fornecedor(
    idFornecedor    INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome            VARCHAR(50) NOT NULL,
    endereco        VARCHAR(50) NOT NULL
);

CREATE TABLE TelefoneFornecedor(
    telefone        VARCHAR(12) NOT NULL,
    idFornecedor    INTEGER NOT NULL,
    FOREIGN KEY(idFornecedor) REFERENCES Fornecedor(idFornecedor));

CREATE TABLE Fabricante(
    idFabricante    INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome            VARCHAR(45) NOT NULL
);

CREATE TABLE Produto(
    idProduto       INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome            VARCHAR(45) NOT NULL,
    preco           DOUBLE NOT NULL,
    quantidade      INTEGER UNSIGNED NOT NULL,
    idFabricante    INTEGER NOT NULL,
    FOREIGN KEY(idFabricante) REFERENCES Fabricante(idFabricante)
);

CREATE TABLE OrdemDeCompraPossuiProduto(
    idOrdemDeCompra INTEGER NOT NULL,
    idProduto       INTEGER NOT NULL,
    FOREIGN KEY(idOrdemDeCompra) REFERENCES OrdemDeCompra(idOrdemDeCompra),
    FOREIGN KEY(idProduto) REFERENCES Produto(idProduto)
);

CREATE TABLE FornecedorForneceProduto(
    idProduto       INTEGER NOT NULL,
    idFornecedor    INTEGER NOT NULL,
    FOREIGN KEY(idProduto) REFERENCES Produto(idProduto),
    FOREIGN KEY(idFornecedor) REFERENCES Fornecedor(idFornecedor)
);

CREATE TABLE Conta(
    idConta         INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    debito          DOUBLE NOT NULL
);

CREATE TABLE Devedor(
    idDevedor       INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nome            VARCHAR(45) NOT NULL,
    endereco        VARCHAR(60) NOT NULL,
    idConta         INTEGER NOT NULL,
    FOREIGN KEY(idConta) REFERENCES Conta(idConta)
);

CREATE TABLE TelefoneDevedor(
    telefone        VARCHAR(12) NOT NULL,
    idDevedor       INTEGER NOT NULL,
    FOREIGN KEY(idDevedor) REFERENCES Devedor(idDevedor)
);

CREATE TABLE ContaPossuiProduto(
    idProduto       INTEGER NOT NULL,
    idConta         INTEGER NOT NULL,
    FOREIGN KEY(idProduto) REFERENCES Produto(idProduto),
    FOREIGN KEY(idConta)   REFERENCES Conta(idConta)
);

