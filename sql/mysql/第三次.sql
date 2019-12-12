#创建选修课平台数据库
CREATE  DATABASE  ElectivesDB;

#使用选修课平台数据库
USE ElectivesDB;

#创建学生信息表
CREATE  TABLE  Students(
    sNo CHAR(8) NOT NULL PRIMARY KEY,
    sPassword  VARCHAR(12) NOT NULL,
    sName VARCHAR(10) NOT NULL,
    sCard CHAR(18) NOT NULL,
    sMobile CHAR(11)
);
#在空表基础上新增非空字段，且位置在学生姓名之后
ALTER TABLE Students ADD sMajor VARCHAR(20) NOT NULL AFTER sName;

INSERT INTO Students VALUES('20180001','19901225','张三','计算机科学与技术','512527199012252693','12345678998');
INSERT INTO Students VALUES('20180002','19901015','李四','软件工程','512527199010152693',NULL);
INSERT INTO Students(sNo,sPassword,sName,sMajor,sCard) VALUES('20180003','19900101','王五','计算机科学与技术','512527199001012693');

SELECT * FROM Students;
#在已有数据的表中新增字段，须允许为空
#alter table Students add sNewMajor varchar(20);


#创建教师信息表
CREATE  TABLE  Teachers(
    tNo CHAR(4) NOT NULL PRIMARY KEY,
    tName  VARCHAR(10) NOT NULL,
    tGender CHAR(1) NOT NULL,
    tAge TINYINT UNSIGNED NOT NULL
);
#一条语句插入两条数据
INSERT INTO Teachers VALUES('0001','老张','男',24),('0002','老李' ,'女',25);
SELECT * FROM Teachers;


#创建课程信息表
CREATE  TABLE  Courses(
    cNo CHAR(5) NOT NULL PRIMARY KEY,
    cName VARCHAR(20) NOT NULL,
    tID CHAR(4),
    cCredit TINYINT UNSIGNED NOT NULL,
    cDescription VARCHAR(100)
);

INSERT INTO Courses VALUES('00001','计算机网络','0001',3,NULL);
INSERT INTO Courses(cNO,cName,cCredit,cDescription) VALUES('00002','C语言',4,'使用谭浩强的最新版教材');


#创建选修记录信息表
CREATE  TABLE  ELogs(
    elNo BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sID CHAR(8) NOT NULL,#学生学号
    cID CHAR(5) NOT NULL,#课程编号
    elScore FLOAT,
    elDate DATETIME DEFAULT NOW()
);
INSERT INTO ELogs(sID,cID,elScore,elDate) VALUES('20180001','00001',NULL,NOW());
INSERT INTO ELogs VALUES(2,'20180001','00002',90,NOW());
INSERT INTO ELogs(sID,cID) VALUES('20180001','00002');

SELECT * FROM ELogs;
SELECT * FROM courses

INSERT INTO teachers
VALUES(1000,'I’m','男',35);

UPDATE students SET sPassword='000000';
UPDATE teachers SET tAge=tAge+1;
UPDATE Courses SET cCredit=0 WHERE tID IS NULL;

DELETE FROM elogs  WHERE  Eldate < '2018-10-20 00:00:00';
DELETE FROM Courses WHERE cName='Visual FoxPro'	;
DELETE FROM students  WHERE sNo='20182101';
#多表联合查询的用法
UPDATE elogs JOIN Courses SET elScore=0.0 WHERE cName='计算机应用基础' ;

ALTER TABLE Courses ADD UNIQUE(cName);

ALTER TABLE Elogs ADD CONSTRAINT FK_ID FOREIGN KEY(sID) REFERENCES students(sNo);
ALTER TABLE Elogs ADD CONSTRAINT FK_ID1 FOREIGN KEY(cID) REFERENCES Courses(cNo);
#删除信息
DROP  TABLE courses,students,teachers,Elogs;