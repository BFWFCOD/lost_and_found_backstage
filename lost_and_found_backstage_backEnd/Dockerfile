FROM hub.c.163.com/library/java:latest
VOLUME /tmp
ARG JAR_FILE
ADD target/${JAR_FILE} lost_and_found_backstage_backend.jar
RUN bash -c 'touch /lost_and_found_backstage_backend.jar'
ENTRYPOINT ["java","-jar","/lost_and_found_backstage_backend.jar"]