FROM maven:latest
LABEL authors="vicheatachea"

WORKDIR /app

COPY . /app

COPY pom.xml /app/

RUN mvn package

CMD ["java", "-jar", "aikido-tracker.jar"]