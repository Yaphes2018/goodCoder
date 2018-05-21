#!/bin/bash  

#方法一
for i in $(seq 1 255)
do
    ping -c 1 10.8.99.$i >/dev/null 2>&1
    if [ $? -eq 0 ]
    then
        echo "10.8.99.$i UP"
    else
        echo "10.8.99.$i DOWN"
    fi
done

#方法二
# nmap –sp 10.8.99.0/24：通过数据包检测，分析局域网内有几台主机是启动的。

