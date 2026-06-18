SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS DBEXERCICIO03;

CREATE DATABASE DBEXERCICIO03;

USE DBEXERCICIO03;

CREATE TABLE NOTA (
	ID_NOTA INT NOT NULL auto_increment,
    NOME VARCHAR(100) NOT NULL,
    CIDADE VARCHAR(100),
    IDADE INT,
    NOTA decimal(3,1) NOT NULL,
    primary key(ID_NOTA)
);

-- 3. Inserir dados 
insert into NOTA(NOME, CIDADE, IDADE, NOTA) values ('PEDRO', "SÃO PAULO", 34, 83.0);
insert into NOTA(NOME, CIDADE, IDADE, NOTA) values ('MARIA', "SÃO PAULO", 23, 59.0);
insert into NOTA(NOME, CIDADE, IDADE, NOTA) values ('JANAINA', "RIO DE JANEIRO", 32, 86.0);
insert into NOTA(NOME, CIDADE, IDADE, NOTA) values ('WONG', "BRASILÍA", 43, 89.0);
insert into NOTA(NOME, CIDADE, IDADE, NOTA) values ('ROBERTO', "SALVADOR", 38, 98.0);
insert into NOTA(NOME, CIDADE, IDADE, NOTA) values ('MARCO', "CURITIBA", 31, 61.0);
insert into NOTA(NOME, CIDADE, IDADE, NOTA) values ('PAULA', "BELO HORIZONTE", 34, 44.0);

-- 4. Listar os dados
SELECT * FROM NOTA;

-- 5 Alterar a idade do aluno Roberto
update NOTA set IDADE = 28 where NOME = "ROBERTO";
SELECT * FROM NOTA;

-- 6. Alterar nota da aluna Maria. 
update NOTA set NOTA = 69.2, CIDADE = "FLORIANÓPOLIS" where NOME = "MARIA";
SELECT * FROM NOTA;

-- 7. Deletar pessoa com mais de 40 anos.
delete FROM NOTA where IDADE > 40;
SELECT * FROM NOTA;