FROM maven:3.6.1-jdk-8-alpine AS dev
WORKDIR /var/www
COPY . .
EXPOSE 8080

ENTRYPOINT ["mvn","spring-boot:run"]

