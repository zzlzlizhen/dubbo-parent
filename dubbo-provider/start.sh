#!/bin/bash 
echo "start..."
PROJECT_NAME=dubbo-provider
SERVER_PORT=8080
LOGGING_LEVEL=ERROR
DISCONF_EVN=online
BASE_PATH=`cd "$(dirname "$0")"; pwd`
echo "${BASE_PATH}/${PROJECT_NAME}.jar"
nohup /usr/local/jdk1.8.0_151/bin/java -Ddisconf.env=${DISCONF_EVN} -Dlogging.level=${LOGGING_LEVEL} -jar -Xms1000m -Xmx1000m -Xmn512m -Xss1024k -XX:SurvivorRatio=8 -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:MaxTenuringThreshold=15 -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+UseCMSCompactAtFullCollection -XX:+ExplicitGCInvokesConcurrent -XX:+DoEscapeAnalysis ${BASE_PATH}/${PROJECT_NAME}.jar --server.port=${SERVER_PORT} > stdout &
echo "${PROJECT_NAME} application is started."
