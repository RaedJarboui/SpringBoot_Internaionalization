FROM openjdk:8
EXPOSE 8080
ADD /target/acm-crm-translate-api-0.0.1-SNAPSHOT.jar acm-crm-translate-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","acm-crm-translate-api-0.0.1-SNAPSHOT.jar"]