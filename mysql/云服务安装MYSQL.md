# 云服务器安装MySQL

#### 环境配置
操作系统:Centos 7.4

MySQL版本: MySQL 5.7

### MySQL下载 

两种方式下载，需要了解更多请移步后面地址：https://repo.mysql.com//

- 第一种方式：

    > windows下载下来通过xftp上传至云服务器（速度快） 直接在浏览器地址栏回车即可：
    > https://repo.mysql.com//mysql57-community-release-el7-8.noarch.rpm

- 第二种：云服务器通过yum/wget下载（网络下载限制）
    - 1.先通过 wget 下载 命令如下
        > wget https://repo.mysql.com//mysql57-community-release-el7-8.noarch.rpm 
        
        安装rpm命令： 
        >rpm -ivh mysql57-community-release-el7-11.noarch.rpm

    - 2.或者安装MySQL源
        > 命令：yum -y install mysql57-community-release-el7-8.noarch.rpm
    
        输入以下命令查看MySQL安装情况：
        > yum repolist enabled | grep mysql.*

    以上操作完毕之后 /etc/yum.repos.d目录下新增了两个文件，mysql-community.repo和mysql-community-source.repo 

    ------

### MySQL 安装
>   yum install mysql-community-server
### 启动MySQL Server 
>systemctl start mysqld

### 查看MySQL状态及端口使用情况
>systemctl status mysqld

>netstat -apn|grep 3306

