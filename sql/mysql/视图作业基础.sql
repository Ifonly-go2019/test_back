/** 创建视图*/
CREATE VIEW Vtest
AS 
SELECT * FROM students

CREATE VIEW VT(a,b,c,d,e,f)
AS 
SELECT * FROM students
/* 查看视图详情*/
DESC Vtest
DESC VT
SHOW FIELDS FROM Vtest
SHOW FIELDS FROM VT
/* 查看视图内容*/
SELECT * FROM Vtest
/** 修改视图*/
CREATE OR REPLACE VIEW Vtest
AS 
SELECT * FROM students

ALTER  VIEW  Vtest  AS  SELECT  sNo  FROM  students
/** 更新视图数据*/
INSERT INTO Vtest VALUES('20180004','000000','小小王','网络工程','512527199001012693','123456654');

/** 删除视图*/
DROP VIEW Vtest
/** 视图的约束条件*/
/** 1〉基础表中所有的NOT NULL列都必须在这个视图中。
2〉不能将一个值添加到包含算术表达式的列中,列不能是虚拟列
3〉在连接视图中不能有Order by排序语句。
4〉不能够具有分组函数。
5）删除基础对象不删除视图。建议采用与表明显不同的名字命名视图。
*/
/** 	统计教师不同姓氏的人数分别有多少？*/
SELECT LEFT(tName,1),COUNT(*) FROM teachers GROUP BY LEFT(tName,1)
/*查看课程描述中包含“计算机”或“电脑”字眼的课程名称及其编号*/
SELECT cName,cNo  FROM courses WHERE cDescription LIKE"%计算机%" OR  cDescription LIKE"%电脑%"
/*统计《C语言》这门课程选修成绩中最高成绩与最低成绩的分值差*/

/* 自己想的选取最大最小值的方法*/SELECT MIN(elScore)  AS minScore,MAX(elscore) AS maxScore FROM courses INNER JOIN  elogs ON cNo=cID WHERE cName="c语言"  

/** 参考过网络得到的结果*/
SELECT(maxScore - minScore) AS result 
FROM 
( SELECT MAX(elscore)  AS maxScore FROM courses LEFT JOIN elogs ON cno=cid WHERE cname="c语言" )a,
( SELECT MIN(elscore)  AS minScore FROM courses  LEFT JOIN elogs ON cno=cid WHERE cname="c语言" ) b
/*	查看王军老师所授课程的考试成绩属于良的同学有哪些（考试成绩在75与85之间，但不包含85为良）*/

SELECT * FROM students	INNER JOIN elogs ON sno=sid INNER JOIN courses ON cno=cid INNER JOIN teachers ON tid=tno WHERE tname="王军" AND elscore BETWEEN '75' AND '85'


