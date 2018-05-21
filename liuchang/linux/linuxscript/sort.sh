#!/bin/bash

log="The squid project provides a number of resources toassist users design,implement and support squid installations. Please browsethe documentation and support sections for more infomation"
#按单词出现频率降序排序
echo $log | tr "A-Z" "a-z" | tr -cs "a-zA-Z" "\n" | sort | uniq -c | sort -nr
#按字母出现频率降序排序
log2=$(echo $log | sed -e s/[\ ]*[\.]*[\,]*//g | tr "A-Z" "a-z")
echo $log2 | fold -w 1 | sort | uniq -c | sort -nr
