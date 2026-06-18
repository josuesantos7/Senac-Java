SET SQL_SAFE_UPDATES = 0;
-- DROP DATABASE IF EXISTS DBEXERCICIO22;
CREATE DATABASE DBEXERCICIO22;
USE DBEXERCICIO22;

CREATE TABLE CIDADE (
    IDCIDADE INT NOT NULL
    , NOME VARCHAR(100)
    , ESTADO VARCHAR(2)
    , PRIMARY KEY(IDCIDADE)
);

CREATE TABLE LOCALEVENTO (
    IDLOCALEVENTO INT NOT NULL AUTO_INCREMENT
    , NOME VARCHAR(100)
    , CAPACIDADE INT
    , IDCIDADE INT
    , PRIMARY KEY (IDLOCALEVENTO)
    , FOREIGN KEY (IDCIDADE) REFERENCES CIDADE(IDCIDADE)
);

CREATE TABLE EVENTO (
    IDEVENTO INT NOT NULL
    , NOME VARCHAR(100)
    , DATA_EVENTO DATE
    , IDLOCALEVENTO INT
    , PRIMARY KEY (IDEVENTO)
    , FOREIGN KEY (IDLOCALEVENTO) REFERENCES LOCALEVENTO(IDLOCALEVENTO)
);

CREATE TABLE CLIENTE (
    IDCLIENTE INT NOT NULL
    , NOME VARCHAR(100)
    , EMAIL VARCHAR(100)
    , PRIMARY KEY (IDCLIENTE)
);

CREATE TABLE PEDIDO (
    IDPEDIDO INT NOT NULL
    , DATA_PEDIDO DATE
    , IDCLIENTE INT
    , PRIMARY KEY (IDPEDIDO)
    , FOREIGN KEY (IDCLIENTE) REFERENCES CLIENTE(IDCLIENTE)
);

CREATE TABLE INGRESSO (
    IDINGRESSO INT NOT NULL
    , IDEVENTO INT NOT NULL
    , IDPEDIDO INT NOT NULL
    , TIPO VARCHAR(50) -- VIP, PISTA, CAMAROTE
    , VALOR DECIMAL(10,2)
    , FOREIGN KEY (IDEVENTO) REFERENCES EVENTO(IDEVENTO)
    , FOREIGN KEY (IDPEDIDO) REFERENCES PEDIDO(IDPEDIDO)
);


-- Cidades
INSERT INTO CIDADE VALUES (1, 'Florianopolis', 'SC');
INSERT INTO CIDADE VALUES (2, 'Curitiba', 'PR');
-- Locais
INSERT INTO LOCALEVENTO VALUES (1, 'Arena Sul', 5000, 1);
INSERT INTO LOCALEVENTO VALUES (2, 'Teatro Central', 800, 2);
-- Eventos
INSERT INTO EVENTO VALUES (1, 'Festival de Jazz', '2026-07-10', 1);
INSERT INTO EVENTO VALUES (2, 'Show de Rock', '2026-08-15', 1);
INSERT INTO EVENTO VALUES (3, 'Stand-up Comedy', '2026-09-01', 2);
-- Clientes
INSERT INTO CLIENTE VALUES (1, 'Ana Silva', 'ana@email.com');
INSERT INTO CLIENTE VALUES (2, 'Bruno Costa', 'bruno@email.com');
INSERT INTO CLIENTE VALUES (3, 'Carla Souza', 'carla@email.com');
-- Pedidos
INSERT INTO PEDIDO VALUES (1, '2026-05-01', 1);
INSERT INTO PEDIDO VALUES (2, '2026-05-02', 2);
INSERT INTO PEDIDO VALUES (3, '2026-05-03', 1);
INSERT INTO PEDIDO VALUES (4, '2026-05-05', 3);
-- Ingressos
INSERT INTO INGRESSO VALUES (1, 1, 1, 'VIP', 200);
INSERT INTO INGRESSO VALUES (2, 1, 1, 'PISTA', 100);
INSERT INTO INGRESSO VALUES (3, 2, 2, 'VIP', 250);
INSERT INTO INGRESSO VALUES (4, 2, 3, 'PISTA', 120);
INSERT INTO INGRESSO VALUES (5, 3, 4, 'CAMAROTE', 180);
INSERT INTO INGRESSO VALUES (6, 3, 4, 'PISTA', 90);
INSERT INTO INGRESSO VALUES (7, 1, 2, 'VIP', 200);


-- #################################################################
-- RESOLUÇÃO EXERCÍCIO:
-- Questão 01.
-- Liste todos os eventos (nome e data).
SELECT 
	EVENTO.NOME,
    EVENTO.DATA_EVENTO
FROM
	CIDADE
    INNER JOIN LOCALEVENTO ON
    CIDADE.IDCIDADE = LOCALEVENTO.IDLOCALEVENTO
    INNER JOIN EVENTO ON
    LOCALEVENTO.IDLOCALEVENTO = EVENTO.IDEVENTO;
    
    
-- Questão 02. ############################################
-- Liste o nome e email de todos os clientes.
SELECT 
	CLIENTE.NOME,
    CLIENTE.EMAIL
FROM
	CLIENTE;
    
-- Questão 03. ############################################
-- Liste todos os ingressos com valor maior que 150.
SELECT
	INGRESSO.IDINGRESSO,
    INGRESSO.VALOR
FROM
	INGRESSO
WHERE
	INGRESSO.VALOR > 150;
    
    
-- Questão 04. ############################################
-- Liste os nomes dos locais com capacidade maior que 1000.
SELECT
	LOCALEVENTO.NOME,
    LOCALEVENTO.CAPACIDADE
FROM
	LOCALEVENTO
WHERE
	CAPACIDADE > 1000;

-- Questão 05. ############################################
--   Liste os eventos ordenados pela data (mais recente primeiro).
SELECT
	EVENTO.NOME,
    EVENTO.DATA_EVENTO
FROM
	EVENTO
order by
	EVENTO.DATA_EVENTO DESC;
    
    
-- Questão 06. ############################################
-- Liste os ingressos do tipo "VIP".
SELECT
	CLIENTE.NOME,
    INGRESSO.TIPO AS INGRESSO
FROM
	CLIENTE
    INNER JOIN PEDIDO ON
    CLIENTE.IDCLIENTE = PEDIDO.IDPEDIDO
    INNER JOIN INGRESSO ON
    PEDIDO.IDPEDIDO = INGRESSO.IDINGRESSO
WHERE
	TIPO = "VIP";
    
-- Questão 07. ############################################
--  Liste os pedidos feitos após '2026-05-02'.
SELECT 
	PEDIDO.DATA_PEDIDO
FROM
	CIDADE
    INNER JOIN LOCALEVENTO ON
    CIDADE.IDCIDADE = LOCALEVENTO.IDLOCALEVENTO
    INNER JOIN EVENTO ON
    LOCALEVENTO.IDLOCALEVENTO = EVENTO.IDEVENTO
    INNER JOIN CLIENTE ON
    EVENTO.IDEVENTO = CLIENTE.IDCLIENTE
    INNER JOIN PEDIDO ON
    CLIENTE.IDCLIENTE = PEDIDO.IDPEDIDO
    INNER JOIN INGRESSO ON
    PEDIDO.IDPEDIDO = INGRESSO.IDINGRESSO
WHERE
	PEDIDO.DATA_PEDIDO > "2026-05-02";
    
    
-- Questão 08. ############################################
-- Liste o nome do evento e o nome do local onde ele acontece.
SELECT 
	EVENTO.NOME AS NOME_EVENTO,
    LOCALEVENTO.NOME AS LOCAL_EVENTO
FROM
	LOCALEVENTO
    INNER JOIN EVENTO ON
    LOCALEVENTO.IDLOCALEVENTO = EVENTO.IDEVENTO;
    

-- Questão 09. ############################################
-- Liste o nome do cliente e a data dos seus pedidos.
SELECT 
	CLIENTE.NOME,
    PEDIDO.DATA_PEDIDO
FROM
	CLIENTE
    INNER JOIN PEDIDO ON
    CLIENTE.IDCLIENTE = PEDIDO.IDPEDIDO;
    
    
-- Questão 10. ############################################
--  Liste o tipo do ingresso e o nome do evento correspondente,
-- mostre apenas uma ocorrencia usando distinct ou group by (mesmo sem função de agregação).
SELECT 
	EVENTO.NOME,
	INGRESSO.TIPO
    
FROM
	EVENTO
    INNER JOIN CLIENTE ON
    EVENTO.IDEVENTO = CLIENTE.IDCLIENTE
    INNER JOIN PEDIDO ON
    CLIENTE.IDCLIENTE = PEDIDO.IDPEDIDO
    INNER JOIN INGRESSO ON
    PEDIDO.IDPEDIDO = INGRESSO.IDINGRESSO
group by
	EVENTO.NOME, INGRESSO.TIPO;
    
    
-- Questão 11. ############################################
--  Liste o nome do cliente, o nome do evento e o valor do ingresso comprado.
SELECT 
	CLIENTE.NOME AS NOME_CLIENTE,
    EVENTO.NOME AS EVENTO,
    INGRESSO.VALOR
FROM
	EVENTO
    INNER JOIN CLIENTE ON
    EVENTO.IDEVENTO = CLIENTE.IDCLIENTE
    INNER JOIN PEDIDO ON
    CLIENTE.IDCLIENTE = PEDIDO.IDPEDIDO
    INNER JOIN INGRESSO ON
    PEDIDO.IDPEDIDO = INGRESSO.IDINGRESSO;


-- Questão 12. ############################################
-- Liste o nome do evento, cidade e local onde ocorre.
SELECT 
	EVENTO.NOME AS EVENTO,
    CIDADE.NOME AS CIDADE,
    LOCALEVENTO.NOME AS LOCAL
FROM
	CIDADE
    INNER JOIN LOCALEVENTO ON
    CIDADE.IDCIDADE = LOCALEVENTO.IDLOCALEVENTO
    INNER JOIN EVENTO ON
    LOCALEVENTO.IDLOCALEVENTO = EVENTO.IDEVENTO;
    

-- Questão 13. ############################################
-- Liste a quantidade de ingressos vendidos por tipo (VIP, PISTA, etc).
SELECT
	INGRESSO.TIPO,
    COUNT(INGRESSO.IDINGRESSO)
FROM
	INGRESSO
GROUP BY
	INGRESSO.TIPO;


-- Questão 14. ############################################
--  Liste o total arrecadado por evento (soma dos valores dos ingressos).
SELECT 
    EVENTO.NOME,
    SUM(INGRESSO.VALOR) AS VALOR_ARRECADADO
FROM
    EVENTO
    INNER JOIN CLIENTE ON
    EVENTO.IDEVENTO = CLIENTE.IDCLIENTE
    INNER JOIN PEDIDO ON
    CLIENTE.IDCLIENTE = PEDIDO.IDPEDIDO
    INNER JOIN INGRESSO ON
    PEDIDO.IDPEDIDO = INGRESSO.IDINGRESSO
GROUP BY 
	EVENTO.NOME;

    
-- Questão 15. ############################################
-- Liste o total gasto por cliente, ordenando do maior para o menor.
SELECT 
	CLIENTE.NOME,
    INGRESSO.VALOR
FROM
    EVENTO
    INNER JOIN CLIENTE ON
    EVENTO.IDEVENTO = CLIENTE.IDCLIENTE
    INNER JOIN PEDIDO ON
    CLIENTE.IDCLIENTE = PEDIDO.IDPEDIDO
    INNER JOIN INGRESSO ON
    PEDIDO.IDPEDIDO = INGRESSO.IDINGRESSO
ORDER BY 
	INGRESSO.VALOR DESC;
    
    
 -- Questão 16. ############################################ 
 -- Liste os tipos de ingresso que possuem mais de 2 vendas realizadas. Exiba: tipo do ingresso e quantidade de ingressos.
SELECT
	INGRESSO.TIPO,
    COUNT(INGRESSO.IDINGRESSO)
FROM
	INGRESSO
GROUP BY
	INGRESSO.TIPO
HAVING 
	COUNT(INGRESSO.IDINGRESSO) > 2;
	
    
 -- Questão 17. ############################################
 -- Liste os eventos que arrecadaram mais de R$ 300 em vendas de ingressos. Exiba: nome do evento e total arrecadado.
 SELECT 
	*
FROM
	INGRESSO;
    
SELECT
	EVENTO.NOME,
	SUM(INGRESSO.VALOR)
FROM
	EVENTO
    INNER JOIN INGRESSO ON
    EVENTO.IDEVENTO = INGRESSO.IDEVENTO
GROUP BY
	EVENTO.NOME
HAVING
	SUM(INGRESSO.VALOR) > 300;

    


		