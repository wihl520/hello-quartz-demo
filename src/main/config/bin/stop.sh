#!/bin/sh
NAME=gz-eagle-collector
echo "----Kill $NAME----"
ID=`ps -ef | grep "$NAME" | grep -v "$0" | grep -v "grep" | awk '{print $2}'`
echo $ID
for id in $ID
do
kill -9 $id
echo "killed $id"
done
echo "----!!----"
