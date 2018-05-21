#!/bin/bash

#read读入方式
read -t 30 -p "Pls input two num:" a b 
if [ ${#a} -eq 0 ]||[ ${#b} -eq 0 ]
then echo "The number of parameters is incorrect, please input 2 Parameters"
exit 1
else
    expr $a + 10 &>/dev/null
    num1=$?
    expr $b + 10 &>/dev/null
    num2=$?
    if [ $num1 -ne 0 ]||[ $num2 -ne 0 ]
    then echo "The two numbers involved in the comparison must be an integer. Please re-enter"
    exit 2
    else
        if [ $a -gt $b ]
        then echo "$a is larger than $b"
        elif [ $a -lt $b ]
        then echo "$a is smaller than $b"
        else
        echo "$a is equal with $b"
        fi
    fi
fi
