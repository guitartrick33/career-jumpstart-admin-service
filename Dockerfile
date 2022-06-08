FROM maven:3.8.4-jdk-11
WORKDIR /admin_ms
COPY . .
RUN mvn clean install -Dmaven.test.skip=true
CMD mvn spring-boot:run