FROM openjdk:21
#Править название
COPY target/demoSpring-0.0.1-SNAPSHOT.jar /usr/src/my-app/demoSpring-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/my-app
EXPOSE 8090
#Править название
CMD java -jar demoSpring-0.0.1-SNAPSHOT.jar