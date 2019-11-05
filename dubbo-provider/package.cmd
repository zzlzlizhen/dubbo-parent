@echo off
cd ..
mvn clean package -pl dubbo-provider -am -Dmaven.test.skip=true
pause