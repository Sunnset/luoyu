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
- 将解压缩得到的文件改名，命令：`mv mysql-8.0.29-linux-glibc2.12-x86_64 mysql8`。

5. 检查其他版本MySQL

- 检查是否有其他版本的MySQL，命令：`rpm -qa|grep mysql`，如果没有信息输出，则表示未安装MySQL，否则需要卸载已安装的MySQL，命令为：`rpm -e --nodeps mysql文件名`。

6. 将MySQL添加到环境变量

- 修改profile文件，命令：`vi /etc/profile`，在文件结尾处追加内容：

```shell
export MYSQL_HOME=/usr/local/mysql8/bin
export PATH=$PATH:$MYSQL_HOME
```

- 使配置生效。执行命令：`source /etc/profile`。

7. 创建用户组和用户

- 创建用户组。执行命令：`groupadd mysql`。
- 创建用户。执行命令：`useradd -r -g mysql mysql`。`-r`创建系统该用户，`-g`指定用户组。

8. 创建数据目录

- 创建目录。执行命令：`mkdir -p /data/mysqldata`。
- 更改目录属主和用户组。执行命令：`chown -R mysql:mysql /data/mysqldata`。
- 更改目录的权限。执行命令：`chmod -R 750 /data/mysqldata`。

9. 创建my.cnf配置文件

- 创建配置文件。命令：`touch /usr/local/etc/my.cnf`。
- 配置文件内容：

```properties
[mysql]
# 默认字符集
default-character-set=utf8mb4
[client]
port       = 3306
socket     = /tmp/mysql.sock
[mysqld]
port       = 3306
server-id  = 3306
user       = mysql
socket     = /tmp/mysql.sock
# 安装目录
basedir    = /usr/local/mysql8
# 数据存放目录
datadir    = /data/mysqldata/mysql
log-bin    = /data/mysqldata/mysql/mysql-bin
innodb_data_home_dir      =/data/mysqldata/mysql
innodb_log_group_home_dir =/data/mysqldata/mysql
# 日志及进程数据的存放目录
log-error =/data/mysqldata/mysql/mysql.log
pid-file  =/data/mysqldata/mysql/mysql.pid
# 服务端字符集
character-set-server=utf8mb4
lower_case_table_names=1
autocommit =1
##### 以上涉及文件夹明，注意修改
skip-external-locking
key_buffer_size = 256M
max_allowed_packet = 1M
table_open_cache = 1024
sort_buffer_size = 4M
net_buffer_length = 8K
read_buffer_size = 4M
read_rnd_buffer_size = 512K
myisam_sort_buffer_size = 64M
thread_cache_size = 128
#query_cache_size = 128M
tmp_table_size = 128M
explicit_defaults_for_timestamp = true
max_connections = 500
max_connect_errors = 100
open_files_limit = 65535
binlog_format=mixed
binlog_expire_logs_seconds =864000
# 创建表时使用的默认存储引擎
default_storage_engine = InnoDB
innodb_data_file_path = ibdata1:10M:autoextend
innodb_buffer_pool_size = 1024M
innodb_log_file_size = 256M
innodb_log_buffer_size = 8M
innodb_flush_log_at_trx_commit = 1
innodb_lock_wait_timeout = 50
transaction-isolation=READ-COMMITTED
[mysqldump]
quick
max_allowed_packet = 16M
[myisamchk]
key_buffer_size = 256M
sort_buffer_size = 4M
read_buffer = 2M
write_buffer = 2M
[mysqlhotcopy]
interactive-timeout
```

10. 初始化MySQL

- 初始化数据目录。命令：`mysqld --defaults-file=/usr/local/etc/my.cnf --basedir=/usr/local/mysql8 --datadir=/data/mysqldata/mysql --user=mysql --initialize-insecure`。
- 命令参数说明

|         参数         |                  说明                   |
| :------------------: | :-------------------------------------: |
|   --defaults-file    | 指定配置文件（要放在--initialize 前面） |
|        --user        |                指定用户                 |
|      --basedir       |              指定安装目录               |
|      --datadir       |           指定初始化数据目录            |
| --intialize-insecure |    初始化无密码（否则生成随机密码）     |

11. 启动MySQL

- 以后台的形式启动MySQL。命令：`mysqld_safe --defaults-file=/usr/local/etc/my.cnf & `。
- 确认进程。命令：`ps -ef|grep mysql`，当有两个进程中包含MySQL，则启动成功。

12. 登录

- 无密码登录。当初始化时使用了` --intialize-insecure `参数，则首次登录可以使用命令`mysql -u root --skip-password`登录。
- 有密码登录。若初始化时设置了随机密码，在 `/data/mysql8_data/mysql/mysql.log` 查看 ，使用命令`mysql -u root -p`登录。

13. 修改密码

- 通过本地密码插件 `mysql_native_password` 方式修改。 

```mysql
# 修改密码
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '新密码';
# 刷新权限
FLUSH PRIVILEGES;
```

- 通过mysqladmin修改密码。命令：`mysqladmin -u用户名 -p旧密码 password 新密码`。
- 通过SQL修改密码。

```mysql
# 设置密码
SET PASSWORD FOR '用户名'@'主机' = PASSWORD(‘密码');
# 刷新权限
FLUSH PRIVILEGES;
```

14. 创建远程连接用户

- 查看是否可以远程连接的用户。

```mysql
USE mysql;
SELECT user,host,plugin,authentication_string FROM user;
```

若host列中内容为localhost，则表示仅可本地访问。

- 创建用户，可以任意远程访问。

```mysql
CREATE user 'root'@'%';
# 设置密码
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '密码';
# 授权用户所有权限，刷新权限
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%';
FLUSH PRIVILEGES;
```

15. 端口放行

- 放行端口。

```shell
 firewall-cmd --zone=public --add-port=80/tcp --permanent
 firewall-cmd --reload
```

16. 将MySQL添加到系统进程中

- 修改配置文件。修改`/usr/local/mysql8/support-files/mysql.server`文件。按照实际配置修改该文件内`basedir`和`datadir`内容。
- 注册服务。执行命令：`cp /usr/local/mysql8/support-files/mysql.server /etc/init.d/mysqld`。

17. 设置自启动。

```shell
chmod +x /etc/init.d/mysqld
systemctl enable mysqld
```

