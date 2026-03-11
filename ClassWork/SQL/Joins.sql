-- Display details of employee who is earning minimum salary
-- SELECT *
-- FROM emp
-- WHERE sal = (
--     SELECT MIN(sal)
--     FROM emp
-- );

-- SELECT * FROM dept;

-- Display department details of employee who is earning maximum salary
-- SELECT *
-- FROM dept
-- WHERE deptno = (
--     SELECT deptno
--     FROM emp
--     WHERE sal = (
--         SELECT MAX(sal)
--         FROM emp
--     )
-- );

-- WAQTD name, salary, job , hiredate of the employee working in sales dept and hired before king.
-- SELECT ename, sal, job, hiredate
-- FROM emp
-- WHERE deptno = (
--     SELECT deptno
--     FROM dept
--     WHERE dname = 'SALES'
-- )
-- AND hiredate < (
--     SELECT hiredate
--     FROM emp
--     WHERE ename = 'KING'
-- );

-- WAQTD dname name with at least 4 employees
-- SELECT dname
-- FROM dept
-- WHERE deptno IN (
--     SELECT deptno
--     FROM emp
--     GROUP BY deptno
--     HAVING COUNT(*) >= 4
-- );

-- UPDATE emp
-- SET sal = 3000
-- WHERE ename = 'ALLEN';

-- Display the details of employees getting same salary in the same department
-- SELECT *
-- FROM emp
-- WHERE (deptno, sal) IN (
--     SELECT deptno, sal
--     FROM emp
--     GROUP BY deptno, sal
--     HAVING COUNT(*) > 1
-- );

-- Display 5th, 6th, 7th record
-- SELECT *
-- FROM emp 
-- LIMIT 3 OFFSET 4;

-- Display last record
-- SELECT *
-- FROM emp
-- ORDER BY empno
-- OFFSET (SELECT COUNT(*) - 1 FROM emp)
-- LIMIT 1;

-- DISPLAY 4th maximum salary 
-- SELECT DISTINCT sal
-- FROM emp
-- ORDER BY sal DESC
-- LIMIT 1
-- OFFSET 3

-- DISPLAY DETAIL OF EMPLOYEE WHO IS EARNING 3RD AND 4TH MINIMUM SALARY
-- SELECT * 
-- FROM emp 
-- WHERE sal IN(
-- 			SELECT DISTINCT sal
-- 			FROM emp
-- 			ORDER BY sal ASC
-- 			OFFSET 2
-- 			LIMIT 2);

-- SELECT * 
-- FROM (SELECT *
-- 	  FROM dept);

------------------------------------------------------------------------------------------------------------------------------------
-- ==========================================
-- DROP TABLES (Safe Re-run)
-- ==========================================
DROP TABLE IF EXISTS loans CASCADE;
DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS authors CASCADE;
DROP TABLE IF EXISTS genres CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- ==========================================
-- AUTHORS TABLE
-- ==========================================
CREATE TABLE authors (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL,
    state VARCHAR(50)
);

-- ==========================================
-- GENRES TABLE
-- ==========================================
CREATE TABLE genres (
    genre_id INT PRIMARY KEY,
    genre_name VARCHAR(100) NOT NULL
);

-- ==========================================
-- USERS TABLE
-- ==========================================
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    phno VARCHAR(15),
    email VARCHAR(100) UNIQUE
);

-- ==========================================
-- BOOKS TABLE
-- ==========================================
CREATE TABLE books (
    book_id INT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author_id INT REFERENCES authors(author_id),
    genre_id INT REFERENCES genres(genre_id)
);

-- ==========================================
-- LOANS TABLE
-- ==========================================
CREATE TABLE loans (
    loan_id INT PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    book_id INT REFERENCES books(book_id),
    borrowed_date DATE NOT NULL,
    return_date DATE
);

-- ==========================================
-- INSERT AUTHORS (10)
-- ==========================================
INSERT INTO authors VALUES
(1, 'Robert Martin', 'Texas'),
(2, 'J.K. Rowling', 'UK'),
(3, 'Chetan Bhagat', 'Delhi'),
(4, 'R.K. Narayan', 'Tamil Nadu'),
(5, 'George Orwell', 'UK'),
(6, 'Dan Brown', 'USA'),
(7, 'Paulo Coelho', 'Brazil'),
(8, 'Agatha Christie', 'UK'),
(9, 'Stephen King', 'USA'),
(10, 'New Author', 'Unknown');  -- No Books

-- ==========================================
-- INSERT GENRES (10)
-- ==========================================
INSERT INTO genres VALUES
(1, 'Programming'),
(2, 'Fantasy'),
(3, 'Fiction'),
(4, 'Classic'),
(5, 'Thriller'),
(6, 'Mystery'),
(7, 'Romance'),
(8, 'Horror'),
(9, 'Drama'),
(10, 'Biography');

-- ==========================================
-- INSERT USERS (10)
-- ==========================================
INSERT INTO users VALUES
(1, 'Aniket', '9876543210', 'aniket@gmail.com'),
(2, 'Rahul', '9876501234', 'rahul@gmail.com'),
(3, 'Priya', '9123456789', 'priya@gmail.com'),
(4, 'Amit', '9012345678', 'amit@gmail.com'),
(5, 'Neha', '9988776655', 'neha@gmail.com'),
(6, 'Rohit', '9090909090', 'rohit@gmail.com'),
(7, 'Kiran', '9871234567', 'kiran@gmail.com'),
(8, 'Meena', '9123987654', 'meena@gmail.com'),
(9, 'Vikas', '9898989898', 'vikas@gmail.com'),
(10, 'Unused User', '9000000000', 'unused@gmail.com'); -- No Loans

-- ==========================================
-- INSERT BOOKS (10)
-- ==========================================
INSERT INTO books VALUES
(1, 'SQL', 1, 1),
(2, 'Clean Code', 1, 1),           -- Robert Martin (Multiple Books)
(3, 'Harry Potter 1', 2, 2),
(4, 'Harry Potter 2', 2, 2),       -- Rowling (Multiple Books)
(5, '2 States', 3, 3),
(6, 'Malgudi Days', 4, 4),
(7, '1984', 5, 3),
(8, 'Da Vinci Code', 6, 5),
(9, 'The Alchemist', 7, 3),
(10, 'Murder on Orient Express', 8, 6);

-- Authors 9 and 10 have NO books

-- ==========================================
-- INSERT LOANS (10)
-- ==========================================
INSERT INTO loans VALUES
(1, 1, 1, '2025-01-10', '2025-01-20'),
(2, 1, 2, '2025-02-01', NULL),          -- Aniket (Multiple Loans)
(3, 2, 3, '2025-02-05', NULL),
(4, 3, 4, '2025-02-07', '2025-02-15'),
(5, 4, 5, '2025-02-10', NULL),
(6, 5, 6, '2025-02-11', NULL),
(7, 6, 7, '2025-02-12', NULL),
(8, 7, 8, '2025-02-13', NULL),
(9, 8, 9, '2025-02-14', NULL),
(10, 9, 10, '2025-02-15', NULL);

-- User 10 has NO loans
-- User 1 has multiple loans

------------------------------------------------------------------------------------------------------------------------------------
-- JOIN
------------------------------------------------------------------------------------------------------------------------------------
-- 1. Cartesian Join / Cross Join
-- In this join each record of table 1 will be merged with all the records of table 2.

-- ANSI (American National Standard Institute)
-- SELECT *
-- FROM table1
-- CROSS JOIN table2;

-- SELECT *
-- FROM emp 
-- CROSS JOIN dept;

-- 2. Inner Join 
-- It matches record.

-- ANSI (Amarican National Standard Institute)
-- SELECT *
-- FROM table1
-- INNER JOIN table2
-- ON <join_condition>; // tn1 = tn2

-- SELECT ename, dname
-- FROM emp 
-- INNER JOIN dept
-- ON emp.deptno = dept.deptno;

-- OLD STYLE
-- SELECT *
-- FROM emp, dept
-- WHERE emp.deptno = dept.deptno;

--Display ename, sal , loc of all the employees working in CHICAGO
-- SELECT e.ename,
--        e.sal,
--        d.loc
-- FROM emp e
-- INNER JOIN dept d
-- ON e.deptno = d.deptno
-- WHERE d.loc = 'CHICAGO';

-----------------------------------------------------------------------------------------------------------------------------------

-- 1.Dname and Job for employees whose job AND department name starts with 'S'SELECT d.dname, e.job
-- FROM emp e
-- JOIN dept d
-- ON e.deptno = d.deptno
-- WHERE e.job LIKE 'S%'
-- AND d.dname LIKE 'S%';

-- 2.Dname and Mgrno for employees reporting to 7839
-- SELECT d.dname, e.mgr
-- FROM emp e
-- JOIN dept d
-- ON e.deptno = d.deptno
-- WHERE e.mgr = 7839;

-- 3.Dname and Hiredate for employees hired after 1983 in ACCOUNTING or RESEARCH dept
-- SELECT d.dname, e.hiredate
-- FROM emp e
-- JOIN dept d
-- ON e.deptno = d.deptno
-- WHERE e.hiredate > '1983-12-31'
-- AND d.dname IN ('ACCOUNTING', 'RESEARCH');

-- 4.Ename and Dname of employees getting commission in dept 10 or 30
-- SELECT e.ename, d.dname
-- FROM emp e
-- JOIN dept d
-- ON e.deptno = d.deptno
-- WHERE e.comm IS NOT NULL
-- AND e.deptno IN (10, 30);

-- 5.Dname and Empno for employees whose empno is (7839, 7902) and working in NEW YORK
-- SELECT d.dname, e.empno
-- FROM emp e
-- JOIN dept d
-- ON e.deptno = d.deptno
-- WHERE e.empno IN (7839, 7902)
-- AND d.loc = 'NEW YORK';

-----------------------------------------------------------------------------------------------------------------------------------
-- OUTER JOIN
-----------------------------------------------------------------------------------------------------------------------------------
-- 1. LEFT OUTER JOIN
-- IT GIVES MATCHED RECORD FROM BOTH THE TABLE AND UNMATCHED RECORD OF LEFT TABLES

-- SELECT *
-- FROM tb1 
-- LEFT JOIN tb2
-- ON t1.col = t2.col;

-- Display employee name and their department name
-- Even though they don’t work in any department.
-- SELECT e.ename,
--        d.dname
-- FROM emp e
-- LEFT JOIN dept d
-- ON e.deptno = d.deptno;


-- SELECT e.ename,
--        d.dname
-- FROM dept d
-- RIGHT JOIN emp e
-- ON d.deptno = e.deptno;

-- 2. RIGHT OUTER JOIN
-- IT GIVES MATCHED RECORD FROM BOTH THE TABLE AND UNMATCHED RECORD OF RIGHT TABLES

-- SELECT *
-- FROM tb1 
-- RIGHT JOIN tb2
-- ON t1.col = t2.col;

-- WAQTD employee name and their department name even though the no employees are working?
-- SELECT e.ename,
--        d.dname
-- FROM emp e
-- RIGHT JOIN dept d
-- ON e.deptno = d.deptno;

-- SELECT e.ename,
--        d.dname
-- FROM dept d
-- LEFT JOIN emp e
-- ON d.deptno = e.deptno;

-----------------------------------------------------------------------------------------------------------------------------------
-- 3. FULL OUTER JOIN
-----------------------------------------------------------------------------------------------------------------------------------
-- SELECT columns
-- FROM table1
-- FULL OUTER JOIN table2
-- ON table1.column = table2.column;

-- SELECT e.ename,
--        d.dname
-- FROM emp e
-- FULL OUTER JOIN dept d
-- ON e.deptno = d.deptno;

-- Display author name and their book name.
-- SELECT a.author_name,
--        b.title AS book_name
-- FROM authors a
-- JOIN books b
-- ON a.author_id = b.author_id;

-- Display author name who has NOT written any book.
-- SELECT a.author_name
-- FROM authors a
-- LEFT JOIN books b
-- ON a.author_id = b.author_id
-- WHERE b.book_id IS NULL;

-- Display no. of books borrowed by each user with username.
select * from users;
select count(*) No_of_times_borrowed , L.User_id from loans L, users U where U.user_id = L.user_id group by L.user_id;

-- Display 'title' of the book and 'author name' from  the 'books' and the 'authors' tables.
select title , author_name from books Bo inner join Authors A on Bo.author_id = A.author_id;

-- WAQ to retreive book titles and their genres , filtering by genre "Science Fiction".
select title , genre_name from books Bo inner join genres G on Bo.genre_id = G.genre_id where Genre_name = 'Science Fiction';

-- WAQ to find all the users details who have borrowed the book with title "1984".
select users.* from users where user_id in (select user_id from loans where book_id in(select book_id from books where title = '1984'));
select u.* from users u  inner join loans l  on u.user_id = l.user_id inner join books bo on l.book_id = bo.book_id where bo.title = '1984'; 

-- WAQ to find users details who borrowed the maximum number of books.
select u.user_id as no_of_books , u.user_name from users u join loans l on u.user_id = l.user_id group by u.user_id order by no_of_books desc limit 1;
select u.user_id , u.user_name 
from loans l , users u
where u.user_id = l.user_id
group by u.user_id , u.user_name 
having count(*) in (select max(no_of_times_borrowed )
					from (select count(*) no_of_times_borrowed , u.user_id 
					from loans l , users u
					where u.user_id = l.user_id
					group by u.user_id) t1);

-- WAQ to show the most borrowed book title.
SELECT b.title
FROM books b
JOIN loans l ON b.book_id = l.book_id
GROUP BY b.book_id, b.title
HAVING COUNT(*) = (
    SELECT MAX(borrow_count)
    FROM (
        SELECT COUNT(*) AS borrow_count
        FROM loans
        GROUP BY book_id
    ) AS sub 
) ;

-- WAQ to list authors whose books have never been borrowed.
select * from authors where author_id in (select b.author_id from books b Inner join loans l on b.book_id = l.book_id where l.loan_id is null);


--------------------------------------------------------------------------------------------------------------------------------------------------------------
--Natural Join 
---------------------------------------------------------------------------------------------------------------------------------------------
-- Syntax : 
-- 			select col_name from tn1 Natural join tn2;
-- Inner Join
select * from emp Inner join dept on emp.deptno = dept.deptno;

-- Natural Join
select * from emp natural join dept;

-----------------------------------------------------------------------------------------------------------------------------------------------
-- Self Join
-------------------------------------------------------------------------------------------------------------------------------------
-- joining a table by it self
-- or 
-- oining same two tables is aka self join.

-- Syntax :
-- 		select col_name 
-- 		from tn1join tn2
-- 		on <Join condition>;

-- why or when we use self join ??
-- Display the name of employee and their manager.
select * from emp;
select e.ename , m.ename from emp e join emp m on e.mgr = m.empno;

-- Display emp name , manager name with their salary if manager is earning more sal.
select e.ename , m.ename , e.sal , m.sal from emp e join emp m on e.mgr = e.empno where m.sal > e.sal;

-- Display emp name , mgr name and their mgr's mgr name.
select e.ename employee , m.ename manage, mm.ename from emp m join emp mm on m.mgr = mm.empno join emp e on e.mgr = m.empno;

----------------------------------------------------------------------------------------------------------------------------------------
-- Set Operators
--------------------------------------------------------------------------------------------------------------------------------------------------------
Union
Intersect
Except



select deptno from dept
	Except
select deptno from emp;

-- Display first record from emp  table twice in the output.
(select * from emp limit 1)
	Union all
(select * from emp limit 1);

--Display third max salary and third min salary;
(select distinct sal from emp order by sal desc limit 1 offset 2) 
union all 
(select distinct sal from emp order by sal asc limit 1 offset 2) 

-- 
	