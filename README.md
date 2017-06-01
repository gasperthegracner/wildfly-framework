# wildfly-framework
This is a framework for wildfly applications
***
## Wildfly eviroment setup
#### 1. How to start?
1. **Install latest Java:** [Link](https://java.com/en/download/)
2. **Install latest Java JDK:** [Link](http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html)
3. **Install latest Eclipse IDE for Java EE developers:** [Link](https://www.eclipse.org/users/)
4. **Install jboss tools in Eclipse:** [Tutorial](http://stackoverflow.com/questions/4057328/how-do-i-install-jboss-as-wildfly-server-in-eclipse-for-java-ee)
5. **Setup a management console:** [Tutorial](https://www.jumpingbean.co.za/blogs/mark/jboss-wildfly-domain-mode-set-up-configuration)
6. **"Hello world" application for beginig**, just to check if everything is working good.  [Tutorial](http://www.thejavageek.com/2015/12/16/jax-rs-hello-world-example-with-wildfly/)
7. **Install mysql database** 

#### 2. Project structure and setup
Project structure is based on this [YouTube tutorial](https://www.youtube.com/watch?v=X-BYerZziVE&list=PL6HqVe_RgWD4SmwwcW0hRNOscUyIkBali) with some modifications for our particural case.

##### 2.1 Creating Datasource
I folowed tutorial:  https://www.youtube.com/watch?v=X-BYerZziVE&t=3s
1. You need MySql and a new database (i named it wildfly_framework)
2. Add new datasource in wildfly admin panel (configuration/datasources) (Name:wildfly_framework | JNDI Name: java:jboss/datasources/wildfly_framework). If you set a different JNDI name, you have to change property `<jta-data-source>` in  FramewokfEJB->JPAContent->persitence.xml
3. Select a driver. If there is no Mysql driver please follow [this tutorial](https://lijianzhao.wordpress.com/2016/07/02/install-mysql-jdbc-driver-on-wildfly/)
4. Connection url: jdbc:mysql://localhost/wildfly_framework

##### 2.2 Creating Basic structrure
I folowed this tutorial: https://www.youtube.com/watch?v=Hw_5hpe0CAc&t=3s, steps are not described, because everything is in this repository.

##### 2.3 Adding a new JPA Entity and DAO (Data Access Object)
*  Entities are placed in package `com.fw.jpa.entity` .
*  DAOs are placed in package `com.fw.ejb.beans`
*  Local and remote DAO interface are placed in package `com.fw.ejb.beans.interfaces`

How to add a new entity:
1. Add a new JPA Entity to `com.fw.jpa.entity`,
2. Create a Local/Remote bean interface in `com.fw.ejb.beans.interfaces`
3. Implement a DAO with entity manager in `com.fw.ejb.beans`

[create a entity](https://www.youtube.com/watch?v=5bXtAim0O2I&list=PL6HqVe_RgWD4SmwwcW0hRNOscUyIkBali&index=3)
[Bean interface implementation](https://www.youtube.com/watch?v=LibDhGFs-Mg&list=PL6HqVe_RgWD4SmwwcW0hRNOscUyIkBali&index=4)

##### 2.4 Adding a new view (administrator view)
Administrator view are placed in project `FrameworkWeb/WebContent/`. Templates for administration pages are located in `FrameworkWeb/WebContent/templates/`

##### 2.5 Adding a new REST method
Sample of demo rest method is located in `FrameworkEJB/ejbModule/com.fw.rest/DemoRS.java`, for fouther methods please follow this example and place all your REST classes and methods inside `FrameworkEJB/ejbModule/com.fw.rest/` 


