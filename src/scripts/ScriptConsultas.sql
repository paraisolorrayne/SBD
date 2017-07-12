-- SCRIPT AGENCIA BANCARIA.

-- CONSULTAS SQL

--> 1)Liste as operacoes Bancarias realizadas que geraram Cupom de Sorteio.Informe id da operacao bancaria o 
--valor da operacao,o numero do cupom e sua validade.

SELECT OPB.num_seq AS ID_OPB,OPB.valor,CU.num AS ID_Cupom,CU.validade
	FROM Operacao_Bancaria OPB INNER JOIN Cupom CU
		ON OPB.num_seq=CU.OPB_num_seq  AND OPB.CRid=CU.OPB_CR_ID AND OPB.CRAGID=CU.OPB_CR_AG_ID;


--> 2)Listar o nome do Dependente e Nome do seu responsavel.Renomeando o nome do 
--dependente para Nome_Dependente e o nome do responsavel para Nome_Responsavel

SELECT D.nome AS Nome_Dependente,F.nome AS Nome_Responsavel 
	FROM Dependente D INNER JOIN Funcionario F
		ON D.funcionario_numf=F.numf ;

			
--> 3) Informe os funcionarios que trabalham em Uberlandia junto com suas respectivas agencias e telefone.

SELECT F.nome,A.id AS Agencia,F.telefone
	FROM Funcionario F INNER JOIN Agencia A
		ON F.agencia_id=A.id
			WHERE A.cidade='Uberlandia';


--> 4) Listar os Clientes que Realizaram Emprestimo. Mostrar na tela o nome e o cfp

SELECT C.nome ,C.cpf 
	FROM Cliente C INNER JOIN Realizar_Emprestimo RE
		ON C.id=RE.cliente_id
			INNER JOIN Emprestimo E ON E.id=RE.emprestimo_id 
				INNER JOIN Agencia A ON E.agencia_id=A.id;
					

--> 5) Liste os clientes que realizaram empréstimo e que tem mais de 50 anos.Informe na consulta o seu id,nome e idade em anos.

SELECT DISTINCT c.id,c.nome,(current_date - c.datanasc)/365 AS Idade
	FROM cliente C INNER JOIN realizAR_Emprestimo RE ON C.id=RE.cliente_id
		INNER JOIN Emprestimo E ON RE.emprestimo_id=E.id
			WHERE (current_date - c.datanasc)/365 >50;		


--> 6) Liste o nome dos clientes e a quantidade de empréstimo realizado por cada um

SELECT c.nome, COUNT (*) 
	FROM cliente C INNER JOIN Realizar_Emprestimo RE
		ON C.id=RE.cliente_id
			INNER JOIN Emprestimo E ON E.id=RE.emprestimo_id
					GROUP BY c.nome;

--7) Liste o numero de agencias por cidade e estado.Mostre na Consulta a cidade,estado e o numero de agencias.
-- Ordernando pelo estade que mais possui agências.

SELECT cidade,estado,COUNT(*) AS QtdeAgencia
	FROM Agencia  
		GROUP BY cidade,estado 
			ORDER BY QtdeAgencia DESC; 

--> 8) Liste o(s) Cliente(s) que possuem poupança e que nasceram nos ultimos 40 anos.Mostre seu nome e sua idade.
-- Ordenando a idade de forma crescente.

SELECT C.nome,MAX((current_date-C.datanasc)/365) AS Idade
   FROM Cliente C INNER JOIN Possui_Poupanca PP 
      ON C.id=PP.cliente_id
	   GROUP BY C.nome
	    HAVING MAX(current_date-C.datanasc)/365  <=40
	      ORDER BY Idade;

-->> 9) Liste o nome do(S) funcionário(S) que não tem filho unico.

SELECT f.nome, COUNT(*) AS Qtde_Filhos 
	FROM funcionario f INNER JOIN dependente d
		ON f.numf = d.Funcionario_numf
			GROUP BY f.numf 
				HAVING COUNT(f.numF) > 1;

--> 10) Listar o numero de emprestimos realizados no estado de MG e SP.Mostre o Estado e o numero de emprestimos

SELECT A.estado,count(*)
	FROM  Emprestimo E INNER JOIN Agencia A 
	   		ON A.id=E.agencia_id
	   			GROUP BY A.estado
	   			    HAVING A.estado='MG' OR A.estado='SP';

