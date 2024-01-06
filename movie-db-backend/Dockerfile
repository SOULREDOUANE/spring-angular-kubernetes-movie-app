# Start with a base Java image
FROM openjdk:17-jdk-alpine

# Make port 8081 available 
EXPOSE 8080

ADD target/anwar-0.0.1-SNAPSHOT.jar the_movie_db_api-0.0.1-SNAPSHOT.jar

# Execute the jar upon container startup 
ENTRYPOINT ["java", "-jar", "/the_movie_db_api-0.0.1-SNAPSHOT.jar"]