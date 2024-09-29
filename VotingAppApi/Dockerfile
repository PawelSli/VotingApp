# Stage 1: Build the Java application
FROM amazoncorretto:17-alpine AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw package -DskipTests

# Stage 2: Run the application
FROM amazoncorretto:17-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar VotingAppApi.jar

EXPOSE 8080

CMD ["java", "-jar", "VotingAppApi.jar"]
