
#
#
# ###########################
# Compile Artifacts
# ###########################
FROM maven:3.6.3-jdk-11 AS maventmp

COPY entrypoint /home/app/
RUN curl https://downloads.apache.org//ant/binaries/apache-ant-1.10.9-bin.tar.gz > /home/app/apache-ant-1.10.9-bin.tar.gz \
    && ls -l /home/app/apache-ant-1.10.9-bin.tar.gz

COPY cadastro-clientes-glue /home/app/cadastro-clientes-glue
COPY cadastro-clientes-dao /home/app/cadastro-clientes-dao
COPY cadastro-clientes-service /home/app/cadastro-clientes-service
COPY cadastro-clientes-endpoint /home/app/cadastro-clientes-endpoint
COPY cadastro-clientes-db /home/app/cadastro-clientes-db
COPY pom.xml /home/app/


WORKDIR /home/app/

RUN tar xf apache-ant-1.10.9-bin.tar.gz \
    && mvn clean install -Dmaven.test.skip=true 
    

#
#
# ###########################
# Amazon Corretto JDK
# ###########################
FROM openjdk:17-jdk-buster

RUN set -eux \
    && apt-get update
    
ENV TZ=America/Sao_Paulo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD mkdir /opt/app
COPY --from=maventmp /home/app/cadastro-clientes-endpoint/target/cadastro-clientes-endpoint.jar /opt/app/
COPY --from=maventmp /home/app/entrypoint /opt/app/
COPY --from=maventmp /home/app/apache-ant-1.10.9 /opt/app/apache-ant-1.10.9
COPY --from=maventmp /home/app/cadastro-clientes-db /opt/app/cadastro-clientes-db

WORKDIR /opt/app

RUN groupadd -r platformbuilder \
    && useradd -r -s /bin/false -g platformbuilder platformbuilder \
    && chown -R platformbuilder:platformbuilder /opt/app 

USER platformbuilder

EXPOSE 8080

RUN chmod 0755 /opt/app/entrypoint
ENTRYPOINT /opt/app/entrypoint

