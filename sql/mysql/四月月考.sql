SELECT * FROM elogs
SELECT * FROM students

SELECT sName FROM students WHERE NOT EXISTS(SELECT * FROM elogs WHERE sid=sno)
SELECT gName FROM Goods WHERE NOT EXISTS(SELECT * FROM Favorites WHERE gNo=gId)

SELECT DISTINCT(sName) FROM students INNER JOIN  elogs ON sid=sno
SELECT DISTINCT(gname) FROM goods INNER JOIN Favorites ON gno=gid

SELECT * FROM goods WHERE gprice<(SELECT AVG(gprice)FROM goods)
SELECT * FROM elogs WHERE elScore<(SELECT AVG(elScore) FROM elogs)

CREATE VIEW vtest 
AS 
  SELECT sname FROM  students EXISTS((SELECT COUNT(sName) FROM students INNER JOIN  elogs ON sid=sno GROUP BY sid)<5)


SELECT * FROM elogs LIMIT 2,3
SELECT * FROM (SELECT * FROM goods ) WHERE gno>6 AND gno <10;
SELECT * FROM (SELECT elno AS a FROM elogs ) WHERE a>1 AND a<3;



DROP TABLE goods
CREATE TABLE Goods
(
  gno BIGINT PRIMARY KEY AUTO_INCREMENT,
  gname VARCHAR(30) NOT NULL,
  gprice FLOAT NOT NULL,
  gnumber SMALLINT UNSIGNED NOT NULL,
  gdate DATETIME DEFAULT NOW(),
  INDEX numberIndex(gnumber)
  
)


UPDATE  goods SET gprice=gprice*0.8 WHERE gdate>='2018-06' AND  gdate<='2018.12'