[TOC]



## centos7软件安装和使用

> centos版本：CentOS Linux release 7.9.2009 (Core)

### 1.MySQL安装

1. 说明

> MariaDB是MySQL的一个分支，主要由开源社区维护。CentOS 7及以上版本已经不再使用MySQL数据库，而是使用MariaDB数据库；如果直接安装MySQL，会和MariaDB的文件冲突。

2. 卸载mariadb

- 查看软件版本：`rpm -qa|grep mariadb`。
- 卸载软件：`rpm -e --nodeps 文件名`。
- 查看是否卸载干净：`rpm -qa|grep mariadb`。

3. 下载mysql8安装包

- 使用wget命令下载安装包：`wget https://dev.mysql.com/get/Downloads/MySQL-8.0/mysql-8.0.29-linux-glibc2.12-x86_64.tar.xz`.

4. 解压缩安装包

- 将安装包移动到/usr/local路径。
- 将mysql安装包解压缩：`tar -Jxvf mysql-8.0.29-linux-glibc2.12-x86_64.tar.xz`。