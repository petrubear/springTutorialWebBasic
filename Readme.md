Java Spring Demos
===================

Basic WebApp Demo

* Use MySQL (db.sql script)
* Set user in [Server]/context.xml
```xml
<Resource name="jdbc/spring" auth="Container" type="javax.sql.DataSource"
		maxActive="100" maxIdle="30" maxWait="10000" username="user"
		password="password" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/springtutorial" />
```