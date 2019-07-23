#Defining the Environment.
FROM java:8-jdk-alpine

#Copying the jar.
COPY ./target/productcatalogue-0.0.1-SNAPSHOT.jar /usr/app/

#Setting the working directory.
WORKDIR /usr/app

#Running the jar
ENTRYPOINT ["java","-jar","productcatalogue-0.0.1-SNAPSHOT.jar"]
