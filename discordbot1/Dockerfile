FROM alpine:latest
RUN apk add openjdk16 -X http://dl-cdn.alpinelinux.org/alpine/edge/testing
RUN export JAVA_HOME="/usr/lib/jvm/java-16-openjdk"
RUN wget https://dlcdn.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.tar.gz
RUN tar -xvf apache-maven-3.8.2-bin.tar.gz
COPY . /discordbot1
WORKDIR discordbot1
RUN /apache-maven-3.8.2/bin/mvn clean package
CMD ["java", "-jar", "/discordbot1/target/discordbot1-0.0.1-SNAPSHOT.jar"]