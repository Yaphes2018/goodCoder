#!/bin/bash

if [ ! -d '/home/map/tt/backup/temp' ]
then mkdir -p /home/map/tt/backup/temp
fi
cp -rf /home/map/odp_cater/log/php-error.log /home/map/tt/backup/temp
tar -zcvf /home/map/tt/backup/temp$(date +%Y%m%d).tar.gz /home/map/tt/backup/
rm -rf /home/map/tt/backup/temp

#配置定时任务自动执行脚本
#0 0 * * sun /home/map/odp_xtools/php/bin/php /home/map/odp_xtools/app/xexception/script/linux/linuxscript/backup.sh
