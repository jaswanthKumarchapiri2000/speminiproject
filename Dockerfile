FROM openjdk:8
COPY ./target/spe-mini-project-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java" ,"-jar" , "spe-mini-project-1.0-SNAPSHOT-jar-with-dependencies.jar" , "Main"]