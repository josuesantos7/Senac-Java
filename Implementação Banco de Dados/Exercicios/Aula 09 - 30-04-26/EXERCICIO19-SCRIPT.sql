-- DESABILITANDO O MODE SEGURO
SET SQL_SAFE_UPDATES = 0;

-- APAGANDO O BANCO DE DADOS CASO EXISTA
DROP DATABASE IF EXISTS DBEXERCIO19;

-- CRIANDO O BANCO DE DADOS
CREATE DATABASE DBEXERCIO19;

-- CONECTANDO AO BANCO DE DADOS
USE DBEXERCIO19;

-- CRIANDO AS TABELAS
CREATE TABLE ALUNO (
	IDALUNO INT NOT NULL AUTO_INCREMENT
    , NOME VARCHAR(120) NOT NULL
    , TURMA VARCHAR(50) NOT NULL
    , PRIMARY KEY (IDALUNO)
);

CREATE TABLE LIVRO (
	IDLIVRO INT NOT NULL AUTO_INCREMENT
    , TITULO VARCHAR(120) NOT NULL
    , AUTOR VARCHAR(120) NOT NULL
    , PRIMARY KEY (IDLIVRO)
);

CREATE TABLE EMPRESTIMO (
	IDEMPRESTIMO INT NOT NULL AUTO_INCREMENT
    , IDALUNO INT NOT NULL
    , IDLIVRO INT NOT NULL
    , DT_EMPRESTIMO DATE NOT NULL
    , DT_DEVOLUCAO DATE
    , PRIMARY KEY (IDEMPRESTIMO)
    , FOREIGN KEY (IDALUNO) REFERENCES ALUNO(IDALUNO)
    , FOREIGN KEY (IDLIVRO) REFERENCES LIVRO(IDLIVRO)
);

INSERT INTO ALUNO VALUES
(1, 'Ana Souza', 'Turma A'),
(2, 'Bruno Lima', 'Turma A'),
(3, 'Carlos Silva', 'Turma B'),
(4, 'Daniela Costa', 'Turma B'),
(5, 'Eduardo Alves', 'Turma C'),
(6, 'Fernanda Rocha', 'Turma C');

INSERT INTO LIVRO VALUES
(1, 'Dom Casmurro', 'Machado de Assis'),
(2, 'O Hobbit', 'J.R.R. Tolkien'),
(3, '1984', 'George Orwell'),
(4, 'Capitaes da Areia', 'Jorge Amado'),
(5, 'Harry Potter', 'J.K. Rowling'),
(6, 'A Revolucao dos Bichos', 'George Orwell');

INSERT INTO EMPRESTIMO VALUES
(1, 1, 2, '2026-04-01', '2026-04-08'),
(2, 2, 1, '2026-04-02', '2026-04-09'),
(3, 3, 3, '2026-04-03', '2026-04-10'),
(4, 1, 5, '2026-04-05', '2026-04-12'),
(5, 4, 4, '2026-04-06', '2026-04-13'),
(6, 5, 6, '2026-04-07', '2026-04-14'),
(7, 6, 2, '2026-04-08', '2026-04-15'),
(8, 3, 1, '2026-04-10', '2026-04-17');


-- RESOLUÇÃO DA ATIVIDADE 19.
-- 01. Liste todos os alunos cadastrados.
SELECT * FROM ALUNO;

-- 02. Mostre apenas o nome e a turma de todos os alunos.
SELECT 
	NOME,
    TURMA
FROM
	ALUNO;
 
 -- 03. Liste todos os livros cadastrados em ordem alfabética pelo título.
 SELECT
	*
FROM
	LIVRO
ORDER BY TITULO;


--  04. Mostre os alunos da Turma A.
SELECT
	*
FROM
	ALUNO
where TURMA = "Turma A";

-- 05. Liste os livros do autor George Orwell.
SELECT
	*
FROM
	LIVRO
where
	AUTOR = "George Orwell";
    
    
--  06. Liste os alunos em ordem alfabética decrescente pelo nome.
SELECT
	*
FROM
	ALUNO
ORDER BY NOME DESC;


-- 07. Mostre os livros ordenados pelo autor e depois pelo título.
SELECT 
	AUTOR,
    TITULO
FROM
	LIVRO
order by AUTOR;


-- 08. Mostre o nome dos alunos e a data do empréstimo realizado.
SELECT
	NOME,
	DT_EMPRESTIMO
FROM 
	ALUNO INNER JOIN EMPRESTIMO ON
    EMPRESTIMO.IDALUNO = ALUNO.IDALUNO;
    

-- 09. Liste o título dos livros emprestados e a data de devolução.
SELECT 
	TITULO,
    DT_DEVOLUCAO
FROM
	ALUNO INNER JOIN EMPRESTIMO ON
    ALUNO.IDALUNO = EMPRESTIMO.IDALUNO
    INNER JOIN LIVRO ON
    LIVRO.IDLIVRO = EMPRESTIMO.IDLIVRO;

    
-- 10. Mostre o nome dos alunos e os títulos dos livros que pegaram emprestado.
SELECT 
	NOME,
	TITULO
FROM
	ALUNO INNER JOIN EMPRESTIMO ON
    ALUNO.IDALUNO = EMPRESTIMO.IDALUNO
    INNER JOIN LIVRO ON
    LIVRO.IDLIVRO = EMPRESTIMO.IDLIVRO;
    

-- 11. Liste nome do aluno, título do livro e data do empréstimo.
SELECT 
	NOME,
	TITULO,
    DT_EMPRESTIMO
FROM
	ALUNO INNER JOIN EMPRESTIMO ON
    ALUNO.IDALUNO = EMPRESTIMO.IDALUNO
    INNER JOIN LIVRO ON
    LIVRO.IDLIVRO = EMPRESTIMO.IDLIVRO;
    
    
-- 12. Mostre nome do aluno, turma e título do livro emprestado.
SELECT 
	NOME,
    TURMA,
	TITULO
FROM
	ALUNO INNER JOIN EMPRESTIMO ON
    ALUNO.IDALUNO = EMPRESTIMO.IDALUNO
    INNER JOIN LIVRO ON
    LIVRO.IDLIVRO = EMPRESTIMO.IDLIVRO;
    

-- 13. Liste nome do aluno, título do livro e autor do livro.
SELECT 
	NOME,
	TITULO,
    AUTOR
FROM
	ALUNO INNER JOIN EMPRESTIMO ON
    ALUNO.IDALUNO = EMPRESTIMO.IDALUNO
    INNER JOIN LIVRO ON
    LIVRO.IDLIVRO = EMPRESTIMO.IDLIVRO;
    
    
-- 14. Mostre os empréstimos realizados pelos alunos da Turma B.
SELECT 
	IDEMPRESTIMO,
    NOME,
    TITULO,
    TURMA
FROM
	ALUNO INNER JOIN EMPRESTIMO ON
    ALUNO.IDALUNO = EMPRESTIMO.IDALUNO
    INNER JOIN LIVRO ON
    LIVRO.IDLIVRO = EMPRESTIMO.IDLIVRO
WHERE TURMA = "Turma B";


-- 15. Liste nome do aluno e título do livro apenas dos empréstimos feitos após 2026-04-05
SELECT 
	NOME,
	TITULO,
    DT_EMPRESTIMO
FROM
	ALUNO INNER JOIN EMPRESTIMO ON
    ALUNO.IDALUNO = EMPRESTIMO.IDALUNO
    INNER JOIN LIVRO ON
    LIVRO.IDLIVRO = EMPRESTIMO.IDLIVRO
WHERE DT_EMPRESTIMO > "2026-04-05";