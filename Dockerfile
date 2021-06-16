FROM openjdk:8
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
#RUN javac Main.java
EXPOSE 8080
CMD ["java", "-jar", "target/DropWizardExample-0.0.1-SNAPSHOT.jar", "server"]