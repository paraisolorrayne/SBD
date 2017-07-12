--SCRIPT Trigger para Operacao_Bancaria

SET search_path TO agenciaBancaria;

-- STORE PROCEDURE PARA A TRIGGUER

CREATE OR REPLACE FUNCTION verificaCupom() 
RETURNS trigger AS
$$
BEGIN
 IF (NEW.valor > 5000.00) THEN
 INSERT INTO Cupom 
 VALUES (DEFAULT,NEW.dataopb+30,NEW.num_seq,
  NEW.crid, NEW.cragid);
 RAISE NOTICE 'CUPOM DE SORTEIO GERADO';
 END IF; 

RETURN NULL;
END; 
$$ 
language plpgsql;

-- Trigguer
CREATE TRIGGER geraCupom AFTER
INSERT ON 
Operacao_Bancaria FOR EACH ROW
EXECUTE PROCEDURE verificaCupom();