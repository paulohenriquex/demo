# 1. Imagem base com Java 21 rodando num Linux leve
FROM eclipse-temurin:21-jre-alpine

# 2. Pasta onde a aplicação vai rodar dentro do container
WORKDIR /app

# 3. Copia o seu .jar da pasta target do Mac para dentro do container
COPY target/*.jar app.jar

# 4. Avisa que o container vai usar a porta 8080
EXPOSE 8080

# 5. Comando que liga o Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]