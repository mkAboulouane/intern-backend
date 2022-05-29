add those to the app-dev.properties

spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB


and change the default seting in mysql database to support large file :
            $> mysqld --max_allowed_packet=512M
            Or
            max_allowed_packet=512M   in my.cnf and restart the server tomcat

for production mode change :
spring.jpa.hibernate.ddl-auto = update