# ==========================================
# Etapa 1: Compilación (Build)
# ==========================================
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copiamos archivos
COPY . .

# Ajustamos permisos
RUN chmod +x ./gradlew

# Agregamos banderas de memoria para que Gradle no sature la RAM de Render
# -Xmx384m limita a Java a usar máximo 384MB de los 512MB disponibles
# --no-daemon evita que se quede un proceso extra colgado consumiendo RAM
# Usa el mismo Dockerfile de antes, pero asegúrate de que esta línea esté así:
RUN ./gradlew build -x test --no-daemon -Dorg.gradle.jvmargs="-Xmx384m"

# ==========================================
# Etapa 2: Ejecución (Run)
# ==========================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

# También limitamos la RAM al ejecutar la app para que no se apague después
ENTRYPOINT ["sh", "-c", "java -Xmx384m -Dserver.port=${PORT:-8080} -jar app.jar"]