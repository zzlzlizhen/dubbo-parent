@echo off
cd ..
mvn clean package -pl dubbo-consumer -am -Dmaven.test.skip=true
pause