FROM openjdk:8
COPY ./spe-mini-project-1.0-SNAPSHOT.jar
WORKDIR ./
CMD ["java" ,"-cp" , "spe-mini-project-1.0-SNAPSHOT.jar" , "Main"]
