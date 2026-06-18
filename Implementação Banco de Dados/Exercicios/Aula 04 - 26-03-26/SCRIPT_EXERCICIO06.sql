SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS DBEXERCICIO06;

CREATE DATABASE DBEXERCICIO06;

USE DBEXERCICIO06;

CREATE TABLE CLIENTE (
	ID_CLIENTE INT NOT NULL auto_increment,
    NOME VARCHAR(100) NOT NULL,
    CIDADE VARCHAR(50) NOT NULL,
    primary key(ID_CLIENTE)
);


-- 3. Insira pelo menos 4 registros.
insert into CLIENTE set NOME = 'João', CIDADE = "Santana";
insert into CLIENTE set NOME = 'Levy', CIDADE = "Florianópolis";
insert into CLIENTE set NOME = 'Arthur', CIDADE = "Florianópolis";
insert into CLIENTE set NOME = 'Joaquina', CIDADE = "São Paulo";



-- 4. Liste os dados da tabela.
select * from CLIENTE;


-- 5. Altere 2 registro usando alguma condição que não seja a PK (Update).
Update CLIENTE SET NOME = 'João Paulo'
where NOME = 'João';

Update CLIENTE SET NOME = 'Joaquina Brava'
where NOME = 'Joaquina';

select * from CLIENTE;

-- 6. Delete 1 registros usando alguma codição que não seja a PK (Delete).
delete from CLIENTE where NOME = 'João Paulo';
select * from CLIENTE;
