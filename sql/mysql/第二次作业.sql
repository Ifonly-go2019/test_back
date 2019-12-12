USE test1;
CREATE DATABASE course;
USE course;
DROP TABLE student
CREATE TABLE student (
 stuNumber INT(8) PRIMARY KEY,  
 stuPassword INT(8),
 stuName VARCHAR(50)  NOT NULL,
 stuKeyNumber INT ,
 stuPhoneNumber INT 
)

CREATE TABLE teacher(
 teaNumber INT(4) PRIMARY KEY,
 teaName VARCHAR(20),
 teaSex VARCHAR(8),
 teaAge INT(2)
)
CREATE TABLE course(
 corNumber INT(5) PRIMARY KEY,
 corName  VARCHAR(20),
 teaNumber INT(4),
 corIsWhat VARCHAR(80)
)
CREATE TABLE isLearing(
 id        INT(5) AUTO_INCREMENT PRIMARY KEY,
 stuNumber INT(8),
 corNumber INT(5),
 corGrade  INT(4),
 choiceTime VARCHAR(20)
)

ALTER  TABLE student ADD  (yourMajor VARCHAR(20))		
SELECT * FROM  student;
DELETE FROM student WHERE yourMajor='计算机'
INSERT INTO  student(stuNumber, stuPassword,stuName,stuKeyNumber,stuPhoneNumber,yourMajor) 
VALUES(12345678,12378456,'张三',230048,13808593571,'计算机');
INSERT INTO  student(stuNumber, stuPassword,stuName,stuKeyNumber,stuPhoneNumber,yourMajor) 
VALUES(87654321,12378456,'李四',230048,13808593971,'网络工程')

INSERT INTO teacher(teaNumber,teaName,teaSex,teaAge )
VALUES(001,'张老师','女',29);
INSERT INTO teacher(teaNumber,teaName,teaSex,teaAge )
VALUES(002,'李老师','男',35)

INSERT INTO course(corNumber,corNamE,teaNumber,corIsWhat)
VALUES(00001,'计算机网络',001,'关于计算机网络的详情');
INSERT INTO course(corNumber,corNamE,teaNumber,corIsWhat)
VALUES(00002,'计算机原理',002,'关于计算机原理的详情')

INSERT INTO isLearing (id,stuNumber, CORNUMBeR, CORGRADe,  choiceTimE)
VALUES(NULL,12345678,00001,85,'2018-01-24');
INSERT INTO isLearing (id,stuNumber, CORNUMBeR, CORGRADe,  choiceTimE)
VALUES(NULL,87654321,00002,90,'2018-01-24');

SELECT * FROM isLearing;

DROP TABLE student,course,teacher,isLearing