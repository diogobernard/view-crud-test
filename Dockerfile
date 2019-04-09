FROM java:8

COPY target/view-crud-test.jar /usr/src/
WORKDIR /usr/src

ENTRYPOINT ["java", "-jar","view-crud-test.jar"]