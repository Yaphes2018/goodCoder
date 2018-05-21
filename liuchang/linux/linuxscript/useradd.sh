#!/bin/bash

if [ ! -f "/home/map/tt/userinfo.txt" ]
then
    touch /home/map/tt/userinfo.txt
fi
for i in $(seq 1 5)
do
    useradd test0$i
    password=$(head /dev/urandom | tr -dc A-Za-z | head -c 3)
    echo test$password | passwd --stdin test0$i
    echo test0$i test$password >> /home/map/tt/userinfo.txt
done
