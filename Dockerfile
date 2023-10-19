FROM openjdk

MAINTAINER paritosh22777

WORKDIR /app

COPY target/phone-book-system.jar /app/phone-book-system.jar

ENTRYPOINT ["java", "-jar", "phone-book-systme.jar"]