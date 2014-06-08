Java Spring Demos
===================

Basic WebApp Demo

* Create MySQL Database (db.sql script)
* Configure Server Resources: 

###Tomcat 7 - Context.xml

```xml
<Resource name="jdbc/spring" auth="Container" type="javax.sql.DataSource"
		maxActive="100" maxIdle="30" maxWait="10000" username="user"
		password="password" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/springtutorial" />
```

###Glassfish 4 - domain.xml

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

###Jboss 7.1.1 (Create mysql module!!, add jboss-web.xml) - standalone.xml



```xml
<datasources>
	<datasource jta="true" jndi-name="java:jboss/datasources/springtutorial" pool-name="MySqlDS" enabled="true">
                    <connection-url>jdbc:mysql://localhost:3306/springtutorial</connection-url>
                    <driver>com.mysql</driver>
                    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                    <pool>
                        <min-pool-size>10</min-pool-size>
                        <max-pool-size>100</max-pool-size>
                        <prefill>true</prefill>
                    </pool>
                    <security>
                        <user-name>edison</user-name>
                        <password>edison</password>
                    </security>
                    <timeout>
                        <idle-timeout-minutes>0</idle-timeout-minutes>
                        <query-timeout>600</query-timeout>
                    </timeout>
                    <statement>
                        <prepared-statement-cache-size>100</prepared-statement-cache-size>
                        <share-prepared-statements>true</share-prepared-statements>
                    </statement>
	</datasource>
       	<drivers>
                    <driver name="com.mysql" module="com.mysql">
                        <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
                    </driver>
        </drivers>
</datasources>
```
