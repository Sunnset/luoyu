--创建test表
create table test as
select *
from DBA_OBJECTS;

--查看test表owner列和object_id列的基数
select count(distinct OWNER), count(distinct OBJECT_ID), count(*)
from test;

--查看test表owner列的数据分布
select owner, count(*)
from test
group by owner
order by 2 desc;

--收集test表的统计信息
begin
    dbms_stats.GATHER_TABLE_STATS(ownname => 'SCOTT',
                                  tabname => 'test',
                                  estimate_percent => 100,
                                  method_opt => 'for all columns size 1',
                                  no_invalidate => FALSE,
                                  degree => 1,
                                  cascade => TRUE
        );
end;
/

--查看数据库表中每个列的基数与选择性，以scott用户下的test表为例
select a.column_name                               as "列明",
       b.num_rows                                  as "行数",
       a.num_distinct                              as "基数", --                          Cardinality,
       round(a.num_distinct / b.num_rows * 100, 2) as "选择性",--selectivity,
       a.histogram,
       a.num_buckets
from DBA_TAB_COL_STATISTICS a,
     DBA_TABLES b
where a.OWNER = b.OWNER
  and a.TABLE_NAME = b.TABLE_NAME
  and a.OWNER = 'SCOTT'
  and a.TABLE_NAME = 'TEST';



