FROM eclipse-temurin:25-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Build de Maven
RUN ./mvnw clean package -DskipTests

COPY target/ReservaAulasFinal2-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la app
CMD ["java", "-jar", "app.jar"]
