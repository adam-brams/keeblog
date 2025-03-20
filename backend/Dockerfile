FROM openjdk:21-jdk-slim

WORKDIR /app

# copy maven files
COPY mvnw .
COPY .mvn .mvn

# copy backend
COPY . .

# give perms to maven
RUN chmod +x mvnw

# build spring boot app
RUN ./mvnw clean package -DskipTests

# run app
CMD ["java", "-jar", "target/backend-0.0.1-SNAPSHOT.jar"]

# expose port 8080
EXPOSE 8080
