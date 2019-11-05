nohup java -jar -Xms1000m -Xmx1000m -Xmn512m -Xss1024k -XX:SurvivorRatio=8 -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:MaxTenuringThreshold=15 -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:+UseCMSCompactAtFullCollection -XX:+ExplicitGCInvokesConcurrent -XX:+DoEscapeAnalysis dubbo-consumer.jar --server.port=80 > stdout &