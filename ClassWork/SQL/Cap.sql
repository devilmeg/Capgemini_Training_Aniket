--  CREATE DATABASE db;
--   /*CREATE TABLE emp (
--   empno decimal(4,0) NOT NULL,
--   ename varchar(10) default NULL,
--   job varchar(9) default NULL,
--   mgr decimal(4,0) default NULL,
--   hiredate date default NULL,
--   sal decimal(7,2) default NULL,
--   comm decimal(7,2) default NULL,
--   deptno decimal(2,0) default NULL
-- );*/
-- DROP TABLE IF EXISTS dept;




-- -- CREATE TABLE dept (
-- --   deptno decimal(2,0) default NULL,
-- --   dname varchar(14) default NULL,
-- --   loc varchar(13) default NULL
-- -- );

-- -- INSERT INTO emp VALUES ('7369','SMITH','CLERK','7902','1980-12-17','800.00',NULL,'20');
-- -- INSERT INTO emp VALUES ('7499','ALLEN','SALESMAN','7698','1981-02-20','1600.00','300.00','30');
-- -- INSERT INTO emp VALUES ('7521','WARD','SALESMAN','7698','1981-02-22','1250.00','500.00','30');
-- -- INSERT INTO emp VALUES ('7566','JONES','MANAGER','7839','1981-04-02','2975.00',NULL,'20');
-- -- INSERT INTO emp VALUES ('7654','MARTIN','SALESMAN','7698','1981-09-28','1250.00','1400.00','30');
-- -- INSERT INTO emp VALUES ('7698','BLAKE','MANAGER','7839','1981-05-01','2850.00',NULL,'30');
-- -- INSERT INTO emp VALUES ('7782','CLARK','MANAGER','7839','1981-06-09','2450.00',NULL,'10');
-- -- INSERT INTO emp VALUES ('7788','SCOTT','ANALYST','7566','1982-12-09','3000.00',NULL,'20');
-- -- INSERT INTO emp VALUES ('7839','KING','PRESIDENT',NULL,'1981-11-17','5000.00',NULL,'10');
-- -- INSERT INTO emp VALUES ('7844','TURNER','SALESMAN','7698','1981-09-08','1500.00','0.00','30');
-- -- INSERT INTO emp VALUES ('7876','ADAMS','CLERK','7788','1983-01-12','1100.00',NULL,'20');
-- -- INSERT INTO emp VALUES ('7900','JAMES','CLERK','7698','1981-12-03','950.00',NULL,'30');
-- -- INSERT INTO emp VALUES ('7902','FORD','ANALYST','7566','1981-12-03','3000.00',NULL,'20');
-- -- INSERT INTO emp VALUES ('7934','MILLER','CLERK','7782','1982-01-23','1300.00',NULL,'10');

-- -- INSERT INTO dept VALUES ('10','ACCOUNTING','NEW YORK');
-- -- INSERT INTO dept VALUES ('20','RESEARCH','DALLAS');
-- -- INSERT INTO dept VALUES ('30','SALES','CHICAGO');
-- -- INSERT INTO dept VALUES ('40','OPERATIONS','BOSTON');
-- -- SELECT * FROM dept;
-- -- SELECT * FROM emp;



-- -- write a query to retrieve employee names from emp table
-- select distinct ename;



-- --display emp name and emp id
-- select ename, empno
-- from emp;

-- --display salary of employe without duplicates
-- select distinct sal as salary 
-- from emp;

-- --display emp name, salary without duplicates
-- select distinct ename, sal 
-- from emp;

-- --display salary of emp with bnus of 1000
-- select ename, sal , sal + 1000
-- from emp;

-- --display ename, sal, and annual salary of emp
-- select ename, sal, sal * 12
-- from emp;

-- --display ename, sal with hike of 10 percent
-- select ename, sal , sal + sal * 0.1
-- from emp;

-- --display ename, sal with deduction of 10 percent
-- select ename, sal , sal - sal * 0.1
-- from emp;

-- -- display sal as salary and comm as commission
-- select ename as "Employee Name", sal salary , comm commission 
-- from emp;

-- --display name and salary with monthly hike of 50
-- select ename as "Employee Name" , sal + 50 as Salary_With_Hike
-- from emp;

-- --display name and annual salary with deduction of 10 percent
-- select ename as "Employee Name", (sal * 12) * (0.9) as salary
-- from emp;

-- --display total salary given to each employee(sal + commission)
-- SELECT 
--   ename AS "Employee Name",
--   sal + COALESCE(comm, 0) AS total_salary
-- FROM emp;


-- --display details of all employee along with annual salary
-- select *, sal * 12 as annual_salary
-- from emp;

-- --display name and designation along with 100 penality in salary
-- select ename, job as designation, sal - 100 penality
-- from emp;

-- --diplay name , deptno, of empoyees whose department id is 20
-- select ename, deptno 
-- from emp
-- where deptno = 20;

-- -- display name and salary of emp who are earning more then 2000
-- select ename, sal
-- from emp
-- where sal > 2000;

-- --display name of empoyees who are working as manager
-- SELECT ename
-- FROM emp
-- WHERE job = 'MANAGER'; 
-- -- double quotes means column name while single quote means string

-- --display name and hire date of employees who are hired after 1981
-- select ename, hiredate
-- from emp
-- where hiredate > '1981-12-31';

-- IS - It is used to compare with null values.
-- syntax : Col_name/Exp IS null;
-- Display detail


--Concat();
--Upper();
-- Lower();
-- select Lower('Vishal');
-- initcap();
-- select initcap('vishal');
-- Substr(): It is used to extract a part of string from the given original string.
-- Substr('OriginalString' , Postiion , [Length]);
-- select substr('Vishal' , 2 , 4); (indexing starts from 1.)
-- select right('Vishal' , -1);
-- select left('Vishal' , 2);
-- select position('a' IN 'Vishal');
-- select strpos('Salesman' , 'man');
-- select substr('vishaluser7651@gmail.com' , position('@' IN 'vishaluser7651@gmail.com')+1 , length('vishaluser7651@gmail.com'));
--round();
--ceil();
-- floor();
-- date functions : 
-- 1. select now();
-- 2. select current_date;
-- 3. select current_timestamp;
-- 4. SELECT EXTRACT(YEAR FROM NOW());
-- 5. SELECT EXTRACT(MONTH FROM NOW());
-- 6. SELECT EXTRACT(DAY FROM NOW());
-- 7. select extract(hour from now());
-- 8. select extract(minute from now());
-- 9. select extract(second from now());
-- 10. To_Char(coloumn_name , 'day') as day;
-- select emp.* ,To_Char(Hiredate ,  'day') as day from emp; 
-- select emp.* ,To_Char(Hiredate ,  'day') as day from emp where To_Char(Hiredate , 'dy') = 'fri'; 
-- select emp.* ,To_Char(Hiredate ,  'day') as day from emp where To_Char(Hiredate , 'd') = 5; 
-- select emp.* ,To_Char(Hiredate ,  'day') as day from emp where To_Char(Hiredate , 'day') = 'friday   '; 
-- select emp.* from emp where To_Char(Hiredate , 'yyyy') = '1981';
-- Formats of To_Char;
-- 1. month - December
--    mon - Dec
--    mn = 12;

-- 2. yyyy = 2026;
--    yy = 26; 

-- 3. hh12 = 11 hours;
--    hh24 = 15 hours;

-- 4. mi - 39
--    ss - 39

-- Display the details of employee who hired in a month of march, april, may.
-- select emp.* from emp where To_Char(Hiredate , 'mon') = 'mar' OR To_Char(Hiredate , 'mon') = 'apr' OR To_Char(Hiredate , 'mon') = 'may';

-- Display the details of employee who hired on 1981 in the month of feb , dec , apr on wednesday and friday.
-- select emp.* from emp
-- where To_Char(Hiredate , 'yyyy') = '1981' AND (To_Char(Hiredate , 'mon') = 'apr' OR To_Char(Hiredate , 'mon') = 'feb' OR To_Char(Hiredate , 'mon') = 'dec' ) AND (To_Char(Hiredate , 'dy') = 'wed' OR To_Char(Hiredate , 'dy') = 'fri');
-- select emp.* from emp 
-- where To_Char(Hiredate , 'yyyy') = '1981' AND To_Char(Hiredate , 'mon') in ('feb' , 'apr' , 'dec') AND To_Char(Hiredate , 'dy') in ('fri' , 'wed');

-- select now() - Interval '1 day';
-- select now() - Interval '1 month';
-- select now() - Interval '1 year';
-- select now() - Interval '1 week';

-- select * from emp where hiredate > hiredate - interval '2 year';
-- select age(current_date , '2004-06-08');
-- timestampdiff(unit , datetime_expr1 , datetime_expr2);
-- retrive the employees who have 10 years of experience..
-- select * from emp where extract (year from age(current_date , hiredate)) >= 10;
-----------------------------------------------------------------------------------------------------------------

-- Group By
-- It is used to group the records
-- select Group Function/group_by_expression
-- from table_name
-- where <filter_condition>
-- group by Col_name/Exp
-- Group By statements group rows that have the same values in one or more coloumns.
-- The group By statement is used with aggregate functions
-- (count , max , min , avg , sum)

-- Order of Execution : 
-- 1. From clause
-- 2. Where clause [row-by-row]
-- 3. Group by clause [row-by-row]
-- 4. select clause [group by group]
-- display no of employees from different deptno.
select count(*) , deptno from emp group by deptno;
-- display no. of employees in each dept where salary > 2000.
select count(*) , deptno from emp where sal > 2000 group by deptno ;
-- display max salary given to an employee in each designation.
select max(sal), min(sal) , job from emp group by job;
-- Display no. of times salaries are repeated in emp table.
select count(*) no_of_sal, sal from emp group by sal;
-- Display avg salary given to employees in each job
select avg(sal) , job from emp group by job;
-- Display no. of employees earning commission in each dept.
select count(comm) , deptno from emp group by deptno;
-- any clause which executes after grouop by clause , it must execute grp-by-grp.

-------

-- Assignment ques:
-- 
---------------------------------------------------------------------------------------------------
-- Having clause
-- It is used to filter the groups.
-- select group_by exp
-- from table_name
-- group by col_name
-- having group_filter condition

-- Order of Execution
-- From
-- where 
-- grp by
-- having 
-- select

select count(*) , deptno from emp group by deptno having count(*) >= 4;

-- Display no. of employees in each dept ahving atleast 2 emp int it , and there name consist of char 'A' or 'S'.
select count(*) , deptno from emp where ename Like '%A%' OR ename like '%S%' group by deptno having count(*) >= 2;
-- Display the salary which are repated in emp table
select count(*) , sal from emp group by sal having count(*) >1;
-- display job and total salary of each job , if the total sal of each job is more than 9500.
select sum(sal) , job from emp group by job having sum(sal)>9500;
-- cal the avg sal of all emp and display it only if the avg exceeds 55000.
select avg(sal) from emp group by sal having avg(sal) > 55000;

-- display nuo. of emp earning sal more than 1200 in eah job
select count(*), job from emp where sal > 1200 group by job having sum(sal) > 3800 ;

-- display job and max sal of emp in each job if the max sal exceeds 2600
select job , max(sal) from emp group by job having max(sal) > 2600;

-- display the hiredate which are duplicated in emp table.
select hiredate , count(*) from emp group by hiredate having count(*) > 1;

-- display min and max sal of each job if min sal is more than 1000 and max is less than 5000.
select min(sal) min_sal, max(sal) max_sal , job from emp group by job having min(sal) > 1000 AND max(sal) < 5000;

-- display deptno and no. of emp working only if there are 2 emp working in each dept as manager .
select deptno , count(*) from emp where job = 'MANAGER' group by deptno having count(*) = 2;
---------------------------------------------------------------------------------------------------------------------------------

-- Order By
-- -- select group_by exp
-- from table_name
-- group by col_name
-- having group_filter condition
-- order By col_name/desc;

-- Order of Execution
-- From
-- where 
-- grp by
-- having 
-- select
-- Order By [row-by-row]
select count(*) as no_of_times , sal from emp group by sal order by no_of_times desc;

