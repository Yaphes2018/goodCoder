#!/bin/bash

if [ ! -d "/home/map/tt/" ]
then 
    mkdir -p /home/map/tt
fi
cd /home/map/tt
for i in $(seq 1 10)
do
    rand=$(cat /dev/urandom | tr -dc a-z | head -c 5)
    touch $rand"test.html"
done
