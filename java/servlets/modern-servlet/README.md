
## Description
- Built with Maven
- Deployable trough Maven
- Includes dependency for:
    + Log4j2
    + Lombok

## How to configure deployment from Maven
### Maven configuration
In your ~/.m2/settings.xml you need to add a reference for the Tomcat server to use.
Make sure you add this after the </profiles> but before </settings>
The username and password are the ones that can be found in tomcat-users.xml for the server

<servers>
    <server>
        <id>TomcatServer</id>
        <username>aadmin</username>
        <password>admin</password>
    </server>
</servers>

### Tomcat configuration
server.xml must contain the port to listen to, in this example we've used 9090
<Connector port="9090" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" />

tomcat-users.xml must contain the following:
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<user username="aadmin" password="admin" roles="manager-script,manager-gui" />

## How to deploy from Maven
After you successfully build the project from maven start Tomcat and run:

> mvn tomcat7:undeploy
This has the purpose of removing any application that's deployed currently on that particular url

> mvn tomcat7:deploy
This deploys the application to the url that's configured in pom.xml (it was left to be deployed on ROOT '/')

## How to access

In case you've used the deployment from Maven
From browser access http://localhost:9090/demo

In case you've deployed it manually add the name of the generated war (without extension) before the binded path ("/demo"):
http://localhost:9090/modern-servlet-1.0-SNAPSHOT/demo

## WARNING
Log4j2, while set as a dependency, it's not configured (yet)
