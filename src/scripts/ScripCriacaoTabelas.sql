-- TRABALHO SBD

-- GRUPO 06
	-- Felipe H Gomes
	-- José Maxwell 
	-- Lorrayne Paraiso Flor

-- SCRIPT SQL  AGENCIA BANCARIA.
-- CRIAÇÃO TABELAS 


 
-- CRIANDO E ACESSANDO O ESQUEMA.

--DROP SCHEMA agenciaBancaria CASCADE;
CREATE SCHEMA agenciaBancaria;
SET search_path TO agenciaBancaria;


-- CRIAÇÃO SEQUENCIA
-- USADA PARA GERAR O NUM SEQUENCIAL DA OPERAÇÃO BANCARIA

CREATE SEQUENCE Seq_Opb
START WITH 10002
INCREMENT BY 2 


-- SEQUENCIA PARA GERAR O CUPOM AUTOMATICAMENTE
CREATE  SEQUENCE Seq_Cupom
START WITH 10000
INCREMENT 1



-- CRIAÇÃO DAS TABELAS.

CREATE TABLE Agencia(

id CHAR(5),
cidade VARCHAR(30) NOT NULL,
estado VARCHAR(20) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Agencia PRIMARY KEY(id)	);

--------------------------------------------------------------------------------

CREATE TABLE Funcionario(

numf CHAR(5),
nome VARCHAR(40) NOT NULL UNIQUE,
telefone VARCHAR(20) NOT NULL,
data_admissao DATE NOT NULL,
supervisor CHAR(5),
agencia_id CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Funcionario PRIMARY KEY(numf),
CONSTRAINT FK1_Funcionario FOREIGN KEY(supervisor) REFERENCES Funcionario(numf)
ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT FK2_Funcionario FOREIGN KEY(agencia_id) REFERENCES Agencia(id)
ON DELETE CASCADE ON UPDATE CASCADE); 

--------------------------------------------------------------------------------

CREATE TABLE Dependente(

nome VARCHAR(40),
Funcionario_numf CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Dependente PRIMARY KEY(nome,Funcionario_numf),
CONSTRAINT FK_Dependente FOREIGN KEY(Funcionario_numf) REFERENCES Funcionario(numf)	
ON DELETE CASCADE ON UPDATE CASCADE );


--------------------------------------------------------------------------------
CREATE TABLE Cliente(

id CHAR(5), 
cpf VARCHAR(11) NOT NULL UNIQUE,
nome VARCHAR(25) NOT NULL UNIQUE, 
datanasc DATE NOT NULL,
cidade VARCHAR(30) NOT NULL,
estado VARCHAR(20) NOT NULL,
endereco VARCHAR(35) NOT NULL,
GerNumf CHAR(5) NOT NULL DEFAULT 'F0001',

--RESTRIÇÕES
CONSTRAINT PK_Cliente PRIMARY KEY(id),
CONSTRAINT FK1_Cliente FOREIGN KEY(GerNumf) REFERENCES Funcionario(numf)
ON DELETE SET DEFAULT ON UPDATE CASCADE );

--------------------------------------------------------------------------------

CREATE TABLE Emprestimo(

id CHAR(5),
valor numeric(10,2) NOT NULL CHECK(valor>0.00),
QtdParcerlas INTEGER NOT NULL,
agencia_id CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Emprestimo PRIMARY KEY(id),
CONSTRAINT FK_Emprestimo FOREIGN KEY(agencia_id) REFERENCES Agencia(id)	
ON DELETE CASCADE ON UPDATE CASCADE);

--------------------------------------------------------------------------------
CREATE TABLE Conta_Corrente(

id CHAR(5),
saldo numeric(10,2) NOT NULL,
data_criacao DATE NOT NULL,
ultimo_acesso DATE NOT NULL,
tarifa_mensal REAL NOT NULL,
agencia_id CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Conta_Corrente PRIMARY KEY(id,agencia_id),
CONSTRAINT FK_Conta_Corrente FOREIGN KEY(agencia_id) REFERENCES Agencia(id)
ON DELETE CASCADE ON UPDATE CASCADE	);

--------------------------------------------------------------------------------

CREATE TABLE Operacao_Bancaria(

num_seq CHAR(5) NOT NULL DEFAULT NEXTVAL('Seq_Opb'),
CRid CHAR(5) NOT NULL,
CRAGID CHAR(5) NOT NULL,
valor numeric(10,2) NOT NULL CHECK(valor>0),
tipo VARCHAR(20) NOT NULL CHECK(tipo='DEBITO' OR tipo='CREDITO'),
descricao VARCHAR(20) NOT NULL,
dataOPB DATE NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Operacao_Bancaria PRIMARY KEY(num_seq,CRid,CRAGid),
CONSTRAINT FK_Operacao_Bancaria FOREIGN KEY(CRAGid,CRid) REFERENCES Conta_Corrente(agencia_id,id)
ON DELETE CASCADE ON UPDATE CASCADE );

--------------------------------------------------------------------------------

CREATE TABLE Possui_Corrente(

cliente_id CHAR(5) NOT NULL,
Corrente_id CHAR(5) NOT NULL,
Corrente_Agencia_ID CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Possui_Corrente PRIMARY KEY(cliente_id,Corrente_id,Corrente_Agencia_ID),
CONSTRAINT FK1_Possui_Corrente_Cliente FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK2_Possui_Corrente FOREIGN KEY(Corrente_id,Corrente_Agencia_ID) REFERENCES Conta_Corrente (id,agencia_id)
ON DELETE CASCADE ON UPDATE CASCADE );

--------------------------------------------------------------------------------

-- OPB: Operacao Bancaria
-- CR: Conta Corrente


CREATE TABLE Cupom(
	
num CHAR(5) DEFAULT NEXTVAL('Seq_Cupom'),
validade DATE NOT NULL,
OPB_num_seq CHAR(5) NOT NULL,
OPB_CR_ID CHAR(5) NOT NULL,
OPB_CR_AG_ID CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Cupom PRIMARY KEY(num),
CONSTRAINT FK_Cupom FOREIGN KEY(OPB_num_seq,OPB_CR_ID,OPB_CR_AG_ID) REFERENCES Operacao_Bancaria(num_seq,CRid,CRAGid)
ON DELETE CASCADE ON UPDATE CASCADE	);

--------------------------------------------------------------------------------


CREATE TABLE Poupanca(

id CHAR(5),
saldo numeric(10,2) NOT NULL CHECK(saldo>=0),
data_criacao DATE NOT NULL,
ultimo_acesso DATE NOT NULL,
taxa_juros REAL NOT NULL,
agencia_id CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Poupanca PRIMARY KEY(id,agencia_id),
CONSTRAINT FK_Poupanca FOREIGN KEY(agencia_id) REFERENCES Agencia(id)
ON DELETE CASCADE ON UPDATE CASCADE	); 

--------------------------------------------------------------------------------

CREATE TABLE Possui_Poupanca(

cliente_id CHAR(5) NOT NULL,
Pid CHAR(5) NOT NULL,
PAGid CHAR(5) NOT NULL,

--RESTRIÇÕES
CONSTRAINT PK_Possui_Popanca PRIMARY KEY(cliente_id,PID,PAGid),
CONSTRAINT FK_Possui_Poupanca_Cliente FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_Possui_Poupanca FOREIGN KEY(PAGid,Pid) REFERENCES Poupanca(agencia_id,id) 
ON DELETE CASCADE ON UPDATE CASCADE);

--------------------------------------------------------------------------------


CREATE TABLE Realizar_Emprestimo(

cliente_id CHAR(5),
emprestimo_id CHAR(5),

--RESTRIÇÕES
CONSTRAINT PK_Realizar_Emprestimo PRIMARY KEY(cliente_id,emprestimo_id),
CONSTRAINT FK_Realizar_Emprestimo_Cliente FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT FK_Realizar_Emprestimo_Emprestimo FOREIGN KEY(emprestimo_id) REFERENCES Emprestimo(id)
ON DELETE CASCADE ON UPDATE CASCADE	);

--------------------------------------------------------------------------------

