# Utilise une image parent Maven pour la construction
FROM maven:3.8.5-openjdk-8 AS build

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie les fichiers pom.xml et src dans le répertoire de travail
COPY pom.xml .
COPY src ./src

# Compile le projet
RUN mvn clean package -DskipTests

# Utilise une image parent OpenJDK pour l'exécution
FROM openjdk:8-jre-slim

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier jar généré du premier conteneur vers le second conteneur
COPY --from=build /app/target/config-server-0.0.1-SNAPSHOT.jar ./config-server.jar

# Expose le port 8888
EXPOSE 8888

# Définit la commande d'exécution
ENTRYPOINT ["java", "-jar", "./config-server.jar"]
