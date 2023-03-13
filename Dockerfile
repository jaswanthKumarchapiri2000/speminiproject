FROM openjdk:8
COPY ./
WORKDIR ./
CMD ["java" ,"-cp" , "spe-mini-project-1.0-SNAPSHOT.jar" , "Main"]