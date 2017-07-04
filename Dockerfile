#Dockerfile
FROM hub.c.163.com/library/centos:6.9

MAINTAINER xiaoxiao "leijianghua@chinamcloud.com"

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone 
#install JDK
#RUN yum install wget -y
#RUN wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.tar.gz
#RUN wget http://mirrors.aliyun.com/apache/tomcat/tomcat-7/v7.0.79/bin/apache-tomcat-7.0.79.tar.gz
RUN mkdir /usr/java/
ADD ./target/jdk-8u131-linux-x64.tar.gz /usr/java/
ADD ./target/apache-tomcat-7.0.79.tar.gz /home/
#RUN tar -zxvf jdk-8u131-linux-x64.tar.gz -C /usr/java/
#RUN tar -zxvf apache-tomcat-7.0.79.tar.gz -C /home/

ENV JAVA_HOME /usr/java/jdk1.8.0_131
ENV PATH $JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH
ENV CLASSPATH $CLASSPATH:$JAVA_HOME/lib:$JAVA_HOME/jre/lib

RUN rm -fr /home/apache-tomcat-7.0.79/webapps/*
COPY ./target/shop.war /home/apache-tomcat-7.0.79/webapps/
CMD /home/apache-tomcat-7.0.79/bin/catalina.sh run
EXPOSE 8080
#END
