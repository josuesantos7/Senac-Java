SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS DBEXERCICIO04;

CREATE DATABASE DBEXERCICIO04;

USE DBEXERCICIO04;

CREATE TABLE PRODUTO (
	ID_PRODUTO INT NOT NULL auto_increment,
    DT_PRODUTO date NOT NULL,
    TIPO VARCHAR(10) NOT NULL,
    PRODUTO varchar(80) NOT NULL,
    QUANTIDADE INT NOT NULL,
    primary key(ID_PRODUTO)
);


-- 3. Questão do exercício.
insert into PRODUTO set DT_PRODUTO = '2020-01-01', TIPO = "Entrada", PRODUTO = "Coxinha", QUANTIDADE = 5;
insert into PRODUTO set DT_PRODUTO = '2020-01-02', TIPO = "Saída", PRODUTO = "Mini Pizza", QUANTIDADE = 3;
insert into PRODUTO set DT_PRODUTO = '2020-01-03', TIPO = "Entrada", PRODUTO = "Croissant", QUANTIDADE = 7;
insert into PRODUTO set DT_PRODUTO = '2020-01-04', TIPO = "Saída", PRODUTO = "Joelho", QUANTIDADE = 10;
insert into PRODUTO set DT_PRODUTO = '2020-01-05', TIPO = "Entrada", PRODUTO = "Misto Quente", QUANTIDADE = 2;
insert into PRODUTO set DT_PRODUTO = '2020-01-06', TIPO = "Saída", PRODUTO = "Pão de Queijo", QUANTIDADE = 3;
insert into PRODUTO set DT_PRODUTO = '2020-01-07', TIPO = "Entrada", PRODUTO = "Coxinha", QUANTIDADE = 1;
insert into PRODUTO set DT_PRODUTO = '2020-01-08', TIPO = "Saída", PRODUTO = "Croissant", QUANTIDADE = 5;
insert into PRODUTO set DT_PRODUTO = '2020-01-09', TIPO = "Entrada", PRODUTO = "Joelho", QUANTIDADE = 4;

-- 4. Questão do exercício.
select * from PRODUTO;

-- 5. Questão do exercício.
Update PRODUTO SET TIPO = 'Entrada'
where PRODUTO = 'Mini Pizza' and DT_PRODUTO = '2020-01-02';
select * from PRODUTO;

-- 6. Questão do exercício.
Update PRODUTO SET QUANTIDADE = 2
where PRODUTO = 'Coxinha' and DT_PRODUTO = '2020-01-07';
select * from PRODUTO;

-- 7. Questão do exercício.
delete from PRODUTO where DT_PRODUTO = '2020-01-06';
select * from PRODUTO;
