1. 添加sqljdbc4的maven依赖
使用sqljdbc需要从微软的官方网站下载jar包：
http://www.microsoft.com/en-us/download/details.aspx?displaylang=en&id=11774
下载jar包之后可以通过下面的maven命令将jar包安装到自己的私服上
mvn install:install-file -Dfile=sqljdbc42.jar -Dpackaging=jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.2

2. 安装成功之后就可以在pom中引用sqljdbc依赖了

<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>sqljdbc4</artifactId>
    <version>4.2</version>
</dependency>

3. >mvn clean package spring-boot:run
3.1>jar包启动方式：>java -jar crawler-1.0.jar

4. >http://localhost:8181/crawler

5. >http://localhost:8181/crawler/start?user=huangzhengyu&password=GHadmin1234
   >http://localhost:8181/crawler/start?user=huangzhengyu&password=GHadmin1234&corpName=%E6%B5%99%E6%B1%9F%E5%AE%8F%E6%AD%A3%E5%BB%BA%E7%AD%91%E8%AE%BE%E8%AE%A1%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8
   
   
   
   # Mybatis Generator:
   1. mvn mybatis-generator:generate
   
  