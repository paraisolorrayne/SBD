-- SCRIPT ATUALIZAÇÃO DO BANCO

SET search_path TO agenciaBancaria;

-- INSERÇÃO 

INSERT INTO Dependente VALUES('Cleber','F0014'); -- Inserção no Banco do dependente 'Cleber' dO funcionario de numF='F0014'.

-- REMOÇÃO 

DELETE FROM Dependente WHERE Funcionario_numf='F0008' AND nome= 'Joaquim'; -- Apagando o dependente Joaquim do funcionario de numf='F0008(Cleusa)'

DELETE FROM Funcionario WHERE  numf='F0003';
 -- Apagando o funcionario de numF = 'F0003'(Maxwell) , afeta as tabelas Dependente,Cliente e Funcionario.
 -- No qual apagara o Dependente relacionado no banco, e deixar os campos de Gerente com 'F0001' definido por DEFAULT
 -- e Supervisor como NULL não apagando-os do banco..

DELETE FROM Emprestimo WHERE id='E0006'; -- Apagando o Emprestimo de id E0006.

-- UPDATE

UPDATE Funcionario SET telefone = '99245-6788' WHERE numf='F0013'; -- Atualizando o numero de telefone do funcionario de numf='F0013'

UPDATE Cliente SET endereco = 'Ruas D 966' WHERE id='C0002'; -- Atualizando o endereco do Cliente de id='C00002' 

UPDATE Emprestimo SET valor = (SELECT MAX(valor) FROM Emprestimo) WHERE id='E0001' ;
-- Atualizacao do valor do emprestimo a partir da consulta do maior valor de emprestimo já realizado.