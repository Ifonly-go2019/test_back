#创建索引的几种方式
CREATE INDEX  first_index ON int_demo(id) ;
CREATE UNIQUE INDEX firstChange_index ON int_demo (id);

ALTER TABLE int_demo ADD INDEX second_index(b);
ALTER TABLE int_demo ADD UNIQUE (d);/* 唯一索引，此外还有主键索引*/



/* 创建表时就创建索引*/
CREATE TABLE mytable(  
 
ID INT NOT NULL,   
 
username VARCHAR(16) NOT NULL,  
 
INDEX  third_index (id)  
 
);
  
  
#查看索引
SHOW INDEX FROM int_demo;
SHOW KEYS FROM int_demo;  
  
#删除索引的方式
 ALTER TABLE int_demo DROP INDEX first_index;
 DROP INDEX firstChange_index ON int_demo;
 
 #索引的工作原理
 1.索引是对记录集的多个字段进行排序的方法。在一张表中为一个字段创建一个索引，
 将创建另外一个数据结构，包含字段数值以及指向相关记录的指针，
 然后对这个索引结构进行排序，允许在该数据上进行二分法排序。
 2.索引的作用相当于图书的目录，可以根据目录中的页码快速找到所需的内容
#什么时候需要索引()
1.在经常需要搜索的列上,可以加快索引的速度
2.主键列上可以确保列的唯一性
3.在表与表的而连接条件上加上索引,可以加快连接查询的速度
4.在经常需要排序(ORDER BY),分组(GROUP BY)和的DISTINCT 列上加索引 可以加快排序查询的时间,  (单独ORDER BY 用不了索引，索引考虑加WHERE 或加LIMIT)
5.在一些WHERE 之后的 < <= > >= BETWEEN IN 以及某个情况下的LIKE 建立字段的索引(B-TREE)

6.like语句的 如果你对nickname字段建立了一个索引.当查询的时候的语句是 nickname lick '%ABC%' 那么这个索引讲不会起到作用.而nickname lick 'ABC%' 那么将可以用到索引

7.索引不会包含NULL列,如果列中包含NULL值都将不会被包含在索引中,复合索引中如果有一列含有NULL值那么这个组合索引都将失效,一般需要给默认值0或者 ' '字符串

8.使用短索引,如果你的一个字段是CHAR(32)或者INT(32),在创建索引的时候指定前缀长度 比如前10个字符 (前提是多数值是唯一的..)
那么短索引可以提高查询速度,并且可以减少磁盘的空间,也可以减少I/0操作.

9.不要在列上进行运算,这样会使得mysql索引失效,也会进行全表扫描

10.选择越小的数据类型越好,因为通常越小的数据类型通常在磁盘,内存,cpu,缓存中 占用的空间很少,处理起来更快 

#什么情况下不需要索引
1.查询中很少使用到的列 不应该创建索引,如果建立了索引然而还会降低mysql的性能和增大了空间需求.
2.很少数据的列也不应该建立索引,比如 一个性别字段 0或者1,在查询中,结果集的数据占了表中数据行的比例比较大,mysql需要扫描的行数很多,增加索引,并不能提高效率
3.定义为TEXT和image和BIT数据类型的列不应该增加索引,
4.当表的修改(UPDATE,INSERT,DELETE)操作远远大于检索(SELECT)操作时不应该创建索引,这两个操作是互斥的关系
 
 
 
 SELECT * FROM elogs
 #拓展任务
 #	查看同时选修了《C语言》、《计算机基础》这两门课程学生的学号及姓名
 SELECT sname,sid FROM students INNER JOIN elogs ON sno=sid INNER JOIN courses ON cno=cid WHERE cName="c语言"OR cname="计算机网络"
 GROUP BY sname,sid
 
 
 #	查看年龄最大老师的信息
 SELECT * FROM  teachers WHERE tAge IN (SELECT MAX(tAge) FROM teachers)
 
 #	将《C++》这门课程的老师更改为王华（学校叫王华的老师只有一位）
 SELECT * FROM courses

 UPDATE courses JOIN teachers ON tno=tid SET tid=tno WHERE tname="王华"
 
 #	统计每门课程的选修人数，并按照选修人数从多到少排序
 
 SELECT  * FROM  elogs
 SELECT cid AS '课程编号',COUNT(sid) AS  '选修人数' FROM elogs  GROUP BY cid  ORDER BY 选修人数 DESC
 
 
 
 
 