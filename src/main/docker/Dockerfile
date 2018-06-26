FROM java:8
VOLUME /tmp
ADD qa-cinema-2.0.3.RELEASE.jar qa-cinema-2.0.3.RELEASE.jar
RUN bash -c 'touch /qa-cinema-2.0.3.RELEASE.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/qa-cinema-2.0.3.RELEASE.jar"]