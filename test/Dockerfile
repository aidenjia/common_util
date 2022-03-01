FROM ubuntu
ENV DEBIAN_FRONTEND=noninteractive
ENV TZ=America/New_York

RUN apt-get update &&  \
    apt-get install -y openjdk-8-jre openjdk-8-jdk &&  \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* && \
    chown root:root /usr/lib/jvm -R


RUN apt-get update && apt-get install -y locales && rm -rf /var/lib/apt/lists/* \
    && localedef -i en_US -c -f UTF-8 -A /usr/share/locale/locale.alias en_US.UTF-8
ENV LANG en_US.utf8

COPY target/test-1.0.0-SNAPSHOT.jar /work/
CMD java -cp /work/\* com.charset.test.TestMain