-- SCRIPT 
--ALIMENTAÇÃO DO BANCO AGENCIA BANCARIA

SET search_path TO agenciaBancaria;
-- AGENCIA

INSERT INTO Agencia VALUES
('AG001','Uberlandia','MG'),
('AG002','Belo Horizonte','MG'),
('AG003','Sao Paulo','SP'),
('AG004','Niteroi','RJ'),
('AG005','Uberlandia','MG'),
('AG006','Uberlandia','MG'),
('AG007','Araguari','MG'),
('AG008','Campinas','SP'),
('AG009','Rio de Janeiro','RJ'),
('AG010','Maceio','AL');

-- FUNCIONARIO


INSERT INTO Funcionario VALUES
('F0001','Felipe','99199-0422','23/05/2015',NULL,'AG001'), --Felipe/Uberlandia
('F0002','Josefina','99293-2412','12/02/2017','F0001','AG001'), --Josefina/Felipe/Uberlandia
('F0004','Eudardo','99167-0281','06/05/2014',NULL,'AG009'),	--Eduardo/RJ
('F0003','Maxwell','98891-0352','22/01/2017',NULL,'AG010'), --Maxwell/Maceio
('F0005','Lorrayne','98891-0698','16/01/2016',NULL,'AG008'),--Lorrayne/Campinas
('F0006','Amadeu','99293-1499','20/03/2010',NULL,'AG003'), --Amadeu/Sp
('F0007','Antonio','99629-0172','12/09/2016','F0003','AG010'), --Antonio/Maxwell/Maceio
('F0008','Cleusa','98819-1222','17/04/2016',NULL,'AG007'), --Cleusa/Araguari
('F0009','Pedro','91195-6472','13/01/2012',NULL,'AG002'), --Pedro/BH
('F0010','Jeiza','98879-1492','11/05/2015','F0009','AG002'), --Jeiza/Pedro/BH
('F0011','Mateus','98871-1562','11/05/2015',NULL,'AG004'), -- Mateus/Niteroi
('F0012','Andreia','99871-1512','13/01/2017','F0006','AG003'), --Andreia/Amadeu/SP
('F0013','Marcelo','98171-2572','12/03/2014','F0001','AG005'), --Marcelo/Felipe/Uberlandia
('F0014','Gina','98271-2582','02/06/2015','F0001','AG006'); --Gina/Felipe/Uberlandia

-- DEPENDENTE

INSERT INTO Dependente VALUES
('Cecília','F0001'),
('Marina','F0001'),
('Frederico','F0003'),
('Murilo','F0010'),
('Leandro','F0014'),
('Bruno','F0005'),
('Joaquim','F0008');


-- CLIENTE


INSERT INTO Cliente VALUES
('C0001','85189750000','Carlos','09/04/1968','Uberlandia','MG','Rua A 256','F0001'),
('C0002','92272781411','Natália','02/02/1992','Uberlandia','MG','Rua B 123','F0014'),
('C0003','68702776642','Alexander','21/07/1992','Uberlandia','MG','Rua B 123','F0002'),
('C0004','63199139752','Fernanda','23/05/1954','Sao Paulo','SP','Rua Onze 567','F0012'),
('C0005','61293255688','Sabrina','19/11/1974','Maceio','AL','Rua Treze 1987','F0003'),
('C0006','33726471901','Diego','	06/11/1976','Campinas','SP','Rua Nove 34','F0005'),
('C0007','06597480457','Victor','21/02/1990','Belo Horizonte','MG','Rua A 1860','F0010'),
('C0008','62972714962','Alessandra','01/06/1989','Uberlandia','MG','Rua E 12','F0001'),
('C0009','40424563673','Vicente','09/07/1928','Araguari','MG','Rua Cinco 1240','F0008'),
('C0010','12122206845','Melissa','25/06/1987','Campinas','SP','Rua W 431','F0005'),
('C0011','24068434328','Luana','20/05/1970','Uberlandia','MG','Rua Y 221','F0001'),
('C0012','89065305521','Abraão','04/08/1926','Araguari','MG','Rua Sete 976','F0008');


-- EMPRESTIMO

INSERT INTO Emprestimo VALUES
('E0001',2340.00,10,'AG001'), --Uberlandia
('E0003',10412.25,12,'AG007'), -- Araguari
('E0004',8745.10,5,'AG007'), --Araguari
('E0005',15000.00,15,'AG008'), -- Campinas
('E0006',4568.65,10,'AG003'); -- Sp

INSERT INTO Realizar_Emprestimo VALUES   
('C0002','E0001'),
('C0003','E0001'),
('C0010','E0005'),
('C0006','E0005'),
('C0004','E0006'),
('C0012','E0003'),
('C0012','E0004'),
('C0009','E0004');

-- CONTA CORRENTE

INSERT INTO Conta_Corrente VALUES
('CR001',8789.12,'20/02/2007','09/12/2016',20.00,'AG001'),
('CR002',5600.12,'20/02/2007','10/01/2017',20.00,'AG001'),
('CR003',19475.12,'01/10/2010','09/12/2016',32.00,'AG002'),
('CR004',876.22,'14/01/1998','21/11/2006',25.00,'AG006'),
('CR005',5600.12,'20/02/2007','09/12/2016',20.00,'AG005'),
('CR006',6789.43,'06/04/2014','02/07/2017',19.99,'AG009'),
('CR007',123.41,'12/08/1999','12/08/2011',5.99,'AG010'),
('CR008',899.21,'23/07/2003','09/12/2012',21.89,'AG008'),
('CR009',36627.98,'28/04/1967','01/06/2017',43.98,'AG003');

-- POSSUI CORRENTE

INSERT INTO Possui_Corrente VALUES
('C0001','CR001','AG001'),
('C0001','CR002','AG001'),
('C0002','CR009','AG003'),
('C0003','CR008','AG008'),
('C0004','CR004','AG006'),
('C0006','CR005','AG005'),
('C0007','CR006','AG009'),
('C0005','CR007','AG010'),
('C0008','CR009','AG003'),
('C0009','CR003','AG002');

-- OPERAÇÃO BANCARIA

INSERT INTO Operacao_Bancaria VALUES
(default,'CR001','AG001',123.22,'DEBITO','Pagamento de Luz','20/02/2017'),
(default,'CR001','AG001',879.05,'CREDITO','Pagamento de Boleto','12/06/2016'),
(default,'CR002','AG001',317.76,'DEBITO','Pagamento de Luz','14/01/2015'),
(default,'CR003','AG002',7769.12,'CREDITO','Deposito','03/10/2017'),
(default,'CR004','AG006',240.24,'DEBITO','Pagamento de Boleto','11/12/2015'),
(default,'CR005','AG005',10235.12,'CREDITO','Pagamento de Boleto','04/08/20'),
(default,'CR007','AG010',2679.90,'CREDITO','Deposito','21/11/2014'),
(default,'CR009','AG003',476.88,'DEBITO','Pagamento de Luz','17/01/2013'),
(default,'CR008','AG008',5687.92,'CREDITO','Deposito','10/07/2016');

-- POUPANCA

-- CONSIDERANDO TAXA DE JUROS COMO:
-- 5% = 0.05 ; 10% = 0.1 ; 20% = 0.2 ... 50% = 0.5
--[0.01,0.5]

INSERT INTO Poupanca VALUES
('P0001',678.12,'01/10/2016','02/08/2017',0.02,'AG001'),
('P0002',1456.24,'11/07/2011','01/04/2017',0.03,'AG001'),
('P0003',10890.45,'12/02/2003','02/07/2017',0.025,'AG003'),
('P0004',785.20,'14/08/2012','12/10/2016',0.01,'AG002'),
('P0005',23781.00,'14/03/1998','10/06/2017',0.036,'AG004'),
('P0006',123.12,'09/12/2012','01/04/2015',0.01,'AG005'),
('P0007',678.12,'01/10/2016','03/08/2017',0.5,'AG006'),
('P0008',19245.12,'16/07/2011','10/05/2015',0.046,'AG007'),
('P0009',78.22,'11/04/2002','01/07/2017',0.012,'AG008'),
('P0010',9878.12,'28/09/2008','10/05/2017',0.015,'AG009'),
('P0011',345.12,'17/02/2013','12/01/2017',0.014,'AG010');


-- POSSUI POUPANCA

INSERT INTO Possui_Poupanca VALUES
('C0001','P0001','AG001'),
('C0001','P0002','AG001'),
('C0002','P0003','AG003'),
('C0003','P0001','AG001'),
('C0004','P0006','AG005'),
('C0005','P0004','AG002'),
('C0006','P0005','AG004'),
('C0007','P0011','AG010'),
('C0008','P0009','AG008'),
('C0011','P0007','AG006'),
('C0010','P0008','AG007'),
('C0012','P0010','AG009');
