
SELECT cname FROM courses WHERE cno IN(SELECT DISTINCT cid FROM elogs);
SELECT sid,DISTINCT COUNT(cid) AS '选修课程数' FROM elogs 
SELECT sid,COUNT(DISTINCT Cid)  AS '选修课程数' FROM elogs
SELECT * FROM courses WHERE cName LIKE '%语言%';
ALTER TABLE Courses MODIFY cDescription VARCHAR(200);
SELECT COUNT(sNo) AS '人数' FROM students WHERE sMobile IS NULL;

UPDATE elogs SET elscore=80 WHERE sid='20180101' AND cid='00002';

SELECT * FROM elogs   ORDER BY eldate LIMIT 5 
SELECT tName,tNo FROM teachers WHERE tage BETWEEN 24 AND 35
ALTER TABLE courses ADD sNumber CHAR(4);

SELECT * FROM courses WHERE cCredit IN(3,4,5)
INSERT INTO courses VALUES('00005','删除课程','0005',5,NULL,'23')
DELETE FROM courses WHERE cDescription IS NULL