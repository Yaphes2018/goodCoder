#!/bin/bash

url=$1
dir=$2

down(){
    if [ -z $url ] #判断是否有输入参数
    then 
        echo "Please enter url"
    elif [ -z $dir ]
    then 
        echo "Please enter the directory you want to save"
    fi
    if [ ! -d $dir ] #判断目录是否存在,若不存在则新增并执行下载任务
    then 
        read -p "the directory is not exist,do you want to create,enter y(n)" answer
        if [ $answer == "y" ]
	then
	    mkdir -p $dir
	    wget $dir $url 1>/dev/null 2>&1
	    if [ $? -eq 0 ]
   	    then return 0  #执行成功，返回0
	    else return 56 #执行失败，返回56
	    fi
        else return 55 #不同意创建目录，返回55
	fi
    else
            wget $dir $url 1>/dev/null 2>&1
            if [ $? -eq 0 ]
            then return 0  #执行成功，返回0
            else return 56 #执行失败，返回56
            fi
	fi
}

down $url $dir
# sh down.sh  "https://kunlun.ele.me/upcui/retail/soataskdownloadfile?id=517574&task_type=export_sku&wid=2185907240" "/home/map/tt/ooooooooooooooo"
