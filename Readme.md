Java Spring Demos
===================

Basic WebApp Demo

* Create MySQL Database (db.sql script)
* Configure Server Resources: 

Tomcat 7 - Context.xml
```xml
<Resource name="jdbc/spring" auth="Container" type="javax.sql.DataSource"
		maxActive="100" maxIdle="30" maxWait="10000" username="user"
		password="password" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/springtutorial" />
```

Glassfish 4 - domain.xml
```xml
<resources>
	<jdbc-connection-pool datasource-classname="com.mysql.jdbc.jdbc2.optional.MysqlDataSource" res-type="javax.sql.DataSource" name="MySQLConnPool">
  		<property name="portNumber" value="3306"></property>
  		<property name="databaseName" value="springtutorial"></property>
  		<property name="serverName" value="localhost"></property>
  		<property name="user" value="edison"></property>
  		<property name="password" value="edison"></property>
  		<property name="URL" value="jdbc:mysql://localhost:3306/springtutorial"></property>
	</jdbc-connection-pool>
	<jdbc-resource pool-name="MySQLConnPool" jndi-name="jdbc/spring"></jdbc-resource>
  </resources>
```
