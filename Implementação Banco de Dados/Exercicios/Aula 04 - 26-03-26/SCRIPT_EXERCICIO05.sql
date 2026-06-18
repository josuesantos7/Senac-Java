SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS DBEXERCICIO05;

CREATE DATABASE DBEXERCICIO05;

USE DBEXERCICIO05;

CREATE TABLE PRAIA (
	ID_PRAIA INT NOT NULL auto_increment,
    BALNEARIO VARCHAR(100) NOT NULL,
    DT_COLETA VARCHAR(50) NOT NULL,
    SITUACAO varchar(50) NOT NULL,
    primary key(ID_PRAIA)
);


-- 3. Insira pelo menor 4 linhas de dados da imagem na tabela (Insert).
insert into PRAIA set BALNEARIO = 'PRAIA DA BARRA DA LAGOA (PONTO32)', DT_COLETA = "2024-01-30", SITUACAO = "PROPRIA";
insert into PRAIA set BALNEARIO = 'PRAIA DA BARRA DA LAGOA (PONTO88)', DT_COLETA = "2024-01-30", SITUACAO = "PROPRIA";
insert into PRAIA set BALNEARIO = 'PRAIA DA BASE AEREA (PONTO49)', DT_COLETA = "2024-01-29", SITUACAO = "PROPRIA";
insert into PRAIA set BALNEARIO = 'PRAIA DA BEIRA MAR NORTE (PONTO11)', DT_COLETA = "2024-01-29", SITUACAO = "IMPROPRIA";



-- 4. Liste os dados da tabela e verifique se ficou conforme a imagem (Select).
select * from PRAIA;


-- 5. Altere a situação de todos os registros para próprio.
Update PRAIA SET SITUACAO = 'PROPRIA'
where SITUACAO = 'IMPROPRIA';

-- 06. Altere a data de todos os registros para a data de hoje
Update PRAIA SET DT_COLETA = "2026-03-26";

-- 07. Liste todos os dados e veja se estão OK.
select * from PRAIA;


