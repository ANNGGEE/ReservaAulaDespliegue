# Usamos una imagen oficial de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Directorio dentro del contenedor
WORKDIR /app

# Copiar el pom.xml y el src (necesario para compilar)
COPY pom.xml mvnw ./
COPY .mvn .mvn
COPY src src

# Copiar el wrapper de Maven
COPY mvnw mvnw
RUN chmod +x mvnw

# Construir el proyecto
RUN ./mvnw clean package -DskipTests

# Copiar el jar generado al contenedor
RUN cp target/*.jar app.jar

# Puerto que va a exponer la app
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java","-jar","app.jar"]
