# Bookstore
A Spring-Boot based REST API with the following functions:  
•&nbsp;CRUD operations on Book entity  
•&nbsp;Checkout operation for single or multiple books which will return the total payable amount after calculating discount.  

# ERD



# Execute Unit Tests
:\bookstore> mvn clean test

# Package Application
:\bookstore> mvn clean package -DskipTests

# Run Application
:\bookstore> java -jar target/bookstore-0.0.1.jar

# Build Docker Image
:\bookstore> docker build -t bookstore .
or
:\bookstore> mvn compile jib:build

#Run MySQL Database Container
:\bookstore> docker run -d --name mysql -p 3306:3306 -v $pwd/data/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bookstore mysql:latest

# Run BookStore Docker Container
:\bookstore> docker run -d --name bookstore -p 8080:8080 -e DB_HOST=host.docker.internal -e DB_NAME=bookstore -e DB_USERNAME=root -e DB_PASSWORD=root -t bookstore:latest
or
:\bookstore> docker run -d --name bookstore -p 8080:8080 -e DB_HOST=host.docker.internal -e DB_NAME=bookstore -e DB_USERNAME=root -e DB_PASSWORD=root  registry.hub.docker.com/adeelrana/bookstore:latest

# Run Docker Compose with MySql and BookStore Services
:\bookstore> docker-compose up


# Access Swagger-UI
http://localhost:8080/bookstore/swagger-ui.html

# Access API-Docs
http://localhost:8080/bookstore/api-docs

# Access Performance Metrics
http://localhost:8080/bookstore/actuator

