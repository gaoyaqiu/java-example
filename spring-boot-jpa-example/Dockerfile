FROM registry.cn-shanghai.aliyuncs.com/gaoyaqiu/oracle-java:8_server-jre_unlimited
MAINTAINER  <gyq30494613@gmail.com>

ADD entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ADD app.jar /app.jar

ENTRYPOINT ["/entrypoint.sh"]
