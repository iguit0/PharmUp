CREATE TABLE cliente (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `cpf` varchar(15) NOT NULL unique,
  `email` varchar(40) NOT NULL UNIQUE,
  `rua` varchar(40) ,
  `numero` int(11) ,
  `cidade` varchar(20) ,
  `estado` char(2) ,
  `cep` varchar(9) ,
   primary key (id_cliente)
  );

INSERT INTO `cliente` (`id_cliente`, `nome`, `telefone`, `cpf`, `email`, `rua`, `numero`, `cidade`, `estado`, `cep`) VALUES
(1, 'Lívio Caixeta', '(37)99545-6578', '133.369.095-97', 'liviocaixeta@gmail.com', 'Av. Beira Mar', 1256, 'Florianopolis', 'SC', '30077-500'),
(2, 'José Neto', '(33)91506-6988', '566.925.114-88', 'jose.neto@hotmail.com', 'Rua Y', 50, 'Brasilia', 'DF', '22841-650'),
(3, 'Susana Guimaraes', '(31)92847-6479', '130.455.562-30', 'susana.gui.1245@yahoo.com.br', 'Rua Lopes Mendes', 12, 'Niterói', 'RJ', '30046-500'),
(4, 'Renato Teixeira', '(41)99544-2577', '120.974.642-54', 'renato.teixeira.adv@uol.com.br', 'Rua Meireles ', 123, 'Sao Paulo', 'SP', '30225-900'),
(5, 'Josenildo Pereira' ,'(33)99433-1232','867.206.597-40','josenildo.pereira123@terra.com.br','Avenida Brasil',1200,'Patos de Minas','MG','38700-000');


CREATE TABLE fornecedor (
  `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `telefone` varchar(15) ,
  `cnpj` varchar(40) NOT NULL,
  `email` varchar(40),
  primary key (id_fornecedor)
);

INSERT INTO fornecedor (`id_fornecedor`,`nome`,`telefone`,`cnpj`,`email`) values 
(1,'JKM Pills','(31)94479-5114','98.231.923/1101-54','jkmpills@jkm.com'),
(2,'Laboratorio IAS','(31)99478-2145','87.536.953/0001-57','iaslabs@iascorporate.com');

CREATE TABLE funcionario (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) ,
  `telefone` varchar(15) ,
  `usuario` varchar(20) NOT NULL unique,
  `senha` varchar(10) NOT NULL,
  `permissao` int(11) NOT NULL,
  primary key (id_funcionario)
);

INSERT INTO funcionario (`id_funcionario`, `nome`, `telefone`, `usuario`, `senha`, `permissao`) VALUES
(1, 'Igor Lucio', '(34)99163-4307', 'igor.lucio', '147258', 99),
(2, 'Antonio Rocha', '(09)98123-4567', 'antonio.rocha', '159357', 1),
(3, 'Joaquina Pasqualini', '(09)98765-5555', 'joaquina.pasqualini', '359154', 2),
(4, 'Alice Bagual', '(10)92938-4756', 'alice.bagual', '6524789', 3),
(5, 'Maria Kovalac', '(09)99228-4517', 'maria.kovalac', '326451897', 3);


CREATE TABLE produto (
   `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `descricao` varchar(40) DEFAULT NULL,
  `precounitario` double NOT NULL,
  `categoria` varchar(20) DEFAULT NULL,
  `qntd_estoque` int(11) NOT NULL,
  `cod_fornecedor` int(11) NOT NULL,
  PRIMARY KEY (`id_produto`),
  FOREIGN KEY (`cod_fornecedor`) REFERENCES `fornecedor` (`id_fornecedor`)
);

INSERT INTO produto (`id_produto`, `nome`, `descricao`, `precounitario`, `categoria`,`qntd_estoque`, `cod_fornecedor`) VALUES
(1, 'Tylenol', 'Analgesico e anti termico', 20.99, 'Medicamentos',55, 1),
(2, 'Dorflex', 'Analgesico', 10.75, 'Medicamentos',40, 1),
(3,'Sabonete Lux','Limpeza e higienizacao',18.75,'Higiene Pessoal',22, 2);


CREATE TABLE venda (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `qntd_venda` int(11) NOT NULL,
  `valortotal` double NOT NULL,
  `cod_funcionario` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_venda`),
  FOREIGN KEY (`cod_funcionario`) REFERENCES `funcionario`(`id_funcionario`),
  FOREIGN KEY (`cod_cliente`) REFERENCES `cliente`(`id_cliente`)
);

CREATE USER 'pharmupdba'@'localhost' IDENTIFIED BY 'EJpKovPSKsM6m9Wl';
GRANT ALL PRIVILEGES ON pharmup_bd . * TO 'pharmupdba'@'localhost';
FLUSH PRIVILEGES;

create view listarMedicamentos (nome,precounitario) as 
select nome,precounitario
from produto
where categoria = 'Medicamentos';
 
create view listarClientesPaulistas (nome,cpf,email,rua,numero,cidade,estado) as 
select nome,cpf,email,rua,numero,cidade,estado
from cliente
where estado = 'SP';
 
DELIMITER $$
CREATE PROCEDURE produtosBaratos(valor double)
begin 
	select nome,precounitario,categoria
	from produto
	where precounitario < valor;
end$$
 
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE listarClientes()
BEGIN
	select *
	from cliente;
END $$
DELIMITER ;
 
DELIMITER $$
CREATE PROCEDURE listarProdutos()
BEGIN
	select *
	from produto;
END $$
DELIMITER ;