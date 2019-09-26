#!/bin/sh
JAVA_OPTS="-server -Xms128m -Xmx512m -XX:-UseGCOverheadLimit -DappName=gz-eagle-collector -Djava.rmi.server.hostname=127.0.0.1 -Djava.net.preferIPv4Stack=true -XX:+UseParallelGC -XX:+UseParallelOldGC -XX:ParallelGCThreads=8 -XX:+PrintGCDetails"
nohup java -javaagent:eagle-starter-1.0.0.jar $JAVA_OPTS -jar eagle-starter-1.0.0.jar&