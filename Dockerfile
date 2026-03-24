# ==========================================
# Etapa 1: Compilación (Build)
# ==========================================
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copiamos todos los archivos del proyecto
COPY . .

# Le damos permisos al wrapper de Gradle y construimos el proyecto
# (Omitimos los tests para que el despliegue sea mucho más rápido)
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# ==========================================
# Etapa 2: Ejecución (Run)
# ==========================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos solo el JAR generado desde la etapa anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Render inyecta dinámicamente un puerto en la variable de entorno $PORT.
# Le decimos a Spring Boot que escuche en ese puerto, o en el 8080 por defecto.
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar app.jar"]